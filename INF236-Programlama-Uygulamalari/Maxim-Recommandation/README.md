# Maxim Recommandation

The idea of the project is to create a simple maxim recommendation engine based on user response.

## Contents
```
1 - Introduction
2 - Project Architecture
3 - Results
4 - Conclusion and Future Work
```

## Introduction
~~~
The idea of the project is to create a simple maxim recommendation engine based on user response.
And can be used in real world as a tool that people can use to find maxims which they forget some words of the maxim.

For exemple:
  Someone wants to use "What's good for the goose is good for the gander" sentence.
  But can't remember which word the sentence ends with like "What's good for the goose is good for the ..."
  So he/she can enter the answer to maxim recommendation engine "What's good for the goose is good for the"
  And engine returns "What's good for the goose is good for the gander"
  
That's the general idea.
~~~

## Project Architecture

The database is separated from the main file to make the code more readable. Therefore, the following file structure is used.
```
-app
  video.mp4
  favicon.png
  files.py ( that contains titles, sentences and some html & css )
  trmodel ( pre-trained Turkish model )
  turkish_stop_words.txt ( Words that have no meaning on their own in Turkish to be excluded from the calculation )
-main.py
-requirements.txt
-README.md
```

For this project there are several libraries that need to be installed in the terminal.
Use pip3 or pip for install packages.

```bash
pip install gensim        #For use trained models
pip install numpy         #For using matrixs easily
pip install pandas        #For making dataframe understandable and easy to change
pip install scikit_learn  # -> https://scikit-learn.org/stable/modules/generated/sklearn.metrics.pairwise.cosine_similarity.html
pip install streamlit     #For making website
```

You can run maxim-recommandation easily by `streamlit run main.py` in the cmd after installing packages.

We start by implementing the libraries.
```python3
import streamlit as st
import pandas as pd
import base64
import numpy as np
from gensim.models import KeyedVectors
from sklearn.metrics.pairwise import cosine_similarity
from app.files import hayat, aşk, şarkı, genel, rast_gele, play_bg_video, hide_streamlit_style
```

Next, we make our definitions inside a class to make our code more readable.
```python3
class falci:
    #Loading previously trained Turkish word vectors
    word_vectors = KeyedVectors.load_word2vec_format('app/trmodel', binary=True)

    #Allows get rid of characters other than letters, numbers and spaces for a string
    def rp_string(string: str):
        myString = ""
        for k in range(len(string)):
            if string[k].isalpha() or string[k].isdigit() or string[k].isspace():
                myString += string[k]
        return myString
        
    def construct_wv_matrices(df, answer):...
        """
        construct_wv_matrices(df, answer) converts the sentences words to vector for the given dataframe
        And simply according to an answer it scans the dataframe and returns the closest thing in the dataframe.
        """

    def recommendation_wv(answer, stop_words=None):...
        """
        recommendation_wv(answer, stop_words=None) pulls suggested answer from dataframe using construct_wv_matrices.
        And simply makes a suggestion to the answer the user entered.
        """
```

After using the data from app files, we can make our website after we implement it.

```python3
#Changing the title and favicon of the website
st.set_page_config(page_title="Falcı Pembe", page_icon="app/favicon.png")

#Integrating background video and some css changes
st.markdown(play_bg_video(data_url), unsafe_allow_html=True)
st.markdown(hide_streamlit_style, unsafe_allow_html=True)

#Sidebar content
st.sidebar.header("FALCI PEMBE")
st.sidebar.write("Neyse bahtın, çıksın falın!")
#User response to suggest
user_input = st.sidebar.text_input("Pembe abla, ne söyleyebilirsin hakkımda:",
                                   help="--Konu Başlıkları--\n\n1 - Hayat\n\n2 - "
                                        "Aşk\n\n3 - Şarkı\n\n4- Genel\n\n5- Rastgele"
                                        "\n\nDipnot: Rast gelsin işlerin be*"
                                        "\n\nİpucu: Merak ettiğiniz konu için konu ismini yazınız.")
#Output of Maxim suggestion
st.sidebar.write(falci.recommendation_wv(falci.rp_string(str(user_input).lower()), "app/turkish_stop_words.txt"))
```

## Results
When we run the whole program and enter an input, we can get the desired response in approximately .5 seconds, as we mentioned above.

You can see the final version of the website in "Image-1"

![](https://user-images.githubusercontent.com/54884571/141699304-1fd71e74-70f3-49bc-8eac-13c5ff4f855c.png)
<p align="center">
  Image-1
</p>

And the result of a few input attempts in "Image-2"

![](https://user-images.githubusercontent.com/54884571/141699311-8f4263ff-8487-4682-af0b-0d3befd32cf3.png)
<p align="center">
  Image-2
</p>

## Conclusion

The idea of the task is to make a basic saying proposal motor dependent on client reaction. 
What's more, can be utilized in genuine world as a device that individuals can use to find sayings which they neglect a few expressions of the saying.

### References
```
  [1] https://github.com/aycignl/python_hour/blob/master/life_coach_application.ipynb
  [2] https://github.com/uzay00/KaVe-Egitim/tree/master/VeriBilimi
  [3] https://github.com/akoksal/Turkish-Word2Vec
  [4] https://github.com/helizac/maxim-recommandation
```
