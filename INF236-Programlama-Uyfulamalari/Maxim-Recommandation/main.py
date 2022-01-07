import streamlit as st
import pandas as pd
import base64
import numpy as np
from gensim.models import KeyedVectors
from sklearn.metrics.pairwise import cosine_similarity
from app.files import hayat, aşk, şarkı, genel, rast_gele, play_bg_video, hide_streamlit_style


class falci:
    word_vectors = KeyedVectors.load_word2vec_format('app/trmodel', binary=True)

    def rp_string(string: str):
        myString = ""
        for k in range(len(string)):
            if string[k].isalpha() or string[k].isdigit() or string[k].isspace():
                myString += string[k]
        return myString

    def jaccard_similarity(list1, list2):
        intersection = len(list(set(list1).intersection(list2)))
        union = (len(set(list1)) + len(set(list2))) - intersection
        return float(intersection) / union

    def random_jaccard_recommandation(user_input):
        jaccard_similarity_list = []
        user_input = user_input.lower()

        if user_input in categories_name:
            n = categories_name.index(user_input)
            recommendation = df["sentence"][df["category"] == user_input].sample().values[0]

            return categories_msg[n] + recommendation
        else:
            if len(user_input.split()) > 1:
                for i in range(len(df)):
                    jaccard_similarity_list.append(falci.jaccard_similarity(df["sentence_c"][i], user_input))
                    max_index = jaccard_similarity_list.index(max(jaccard_similarity_list))
                    recommendation = df['sentence'][max_index]
            else:
                recommendation = df["sentence"].sample().values[0]
            return recommendation

    def construct_wv_matrices(df, answer):
        word_matrix = np.zeros((len(df), 400))
        for i in range(len(df)):
            wv_sum = np.zeros((1, 400))
            for j in df.iloc[i]['sentence_c'].split(' '):
                try:
                    wv_sum += falci.word_vectors[j]
                except:
                    pass
            word_matrix[i] = np.divide(wv_sum, len(df.iloc[i]['sentence_c'].split(' ')))

            answer_vector = np.zeros((1, 400))
            for k in answer.split(' '):
                try:
                    answer_vector += falci.word_vectors[k]
                except:
                    pass
            answer_vector = np.divide(answer_vector, len(answer.split(' ')))

        return word_matrix, answer_vector

    def recommendation_wv(answer, stop_words=None):
        answer = answer.lower()

        if stop_words is not None:
            temp = open(stop_words, 'r', encoding="utf-8").read().split('\n')
            for i in range(len(temp) - 1):
                if " " + temp[i] + " " in answer:
                    answer = answer.replace(" " + temp[i] + " ", " ")

        if user_input in categories_name:
            n = categories_name.index(user_input)
            recommendation = df["sentence"][df["category"] == user_input].sample().values[0]

            return categories_msg[n] + recommendation
        else:
            if len(user_input.split()) > 1:
                word_matrix, answer_vector = falci.construct_wv_matrices(df, answer)

                score_board = []
                for i in range(len(df)):
                    score = cosine_similarity(word_matrix[i].reshape(1, 400), answer_vector.reshape(1, 400))
                    score_board.append(score)
                recommendation = df.iloc[score_board.index(max(score_board))].sentence
            else:
                recommendation = df["sentence"].sample().values[0]

            return recommendation


# DATABASE #
categories = [hayat, aşk, şarkı, genel, rast_gele]
categories_name = ["hayat", "aşk", "şarkı", "genel", "rastgele"]
categories_msg = ["Hayat sana ne mi diyor: ", "'O' ne mi düşünüyor: ", "Çok güzel bir şarkı önereyim sana: ",
                  "Havadan sudan: ", "Rast gele: "]

for i in range(len(categories)):
    categories[i] = categories[i].split("\n")

df = pd.DataFrame(columns=['sentence', 'category', 'category_msg'])

for i in range(len(categories_name)):
    for j in range(len(categories[i])):
        df = df.append(
            {'sentence': categories[i][j], 'category': categories_name[i], 'category_msg': categories_msg[i]},
            ignore_index=True)

    df = df[df['sentence'] != ""]
    df.reset_index(drop=True, inplace=True)

df["sentence_c"] = df['sentence'].copy()

for i in range(len(df)):
    df["sentence_c"][i] = df["sentence_c"][i].lower()
    df["sentence_c"][i] = falci.rp_string(df["sentence_c"][i])
    temp = open("app/turkish_stop_words.txt", 'r', encoding="utf-8").read().split('\n')
    for i in range(len(temp) - 1):
        if temp[i] in df["sentence_c"][i]:
            df["sentence_c"][i] = " " + df["sentence_c"][i].replace(temp[i] + " ", " ")

# BACKGROUND VIDEO ENCODING #
file_ = open("app/Falci_Pembe.mp4", "rb")
contents = file_.read()
data_url = base64.b64encode(contents).decode("utf-8")
file_.close()

# STREAMLIT WEBSITE #
st.set_page_config(page_title="Falcı Pembe", page_icon="app/favicon.png")

st.markdown(play_bg_video(data_url), unsafe_allow_html=True)
st.markdown(hide_streamlit_style, unsafe_allow_html=True)

st.sidebar.header("FALCI PEMBE")
st.sidebar.write("Neyse bahtın, çıksın falın!")
user_input = st.sidebar.text_input("Pembe abla, ne söyleyebilirsin hakkımda:",
                                   help="--Konu Başlıkları--\n\n1 - Hayat\n\n2 - "
                                        "Aşk\n\n3 - Şarkı\n\n4- Genel\n\n5- Rastgele"
                                        "\n\nDipnot: Rast gelsin işlerin be*"
                                        "\n\nİpucu: Merak ettiğiniz konu için konu ismini yazınız.")
st.sidebar.write(falci.recommendation_wv(falci.rp_string(str(user_input).lower()), "app/turkish_stop_words.txt"))
