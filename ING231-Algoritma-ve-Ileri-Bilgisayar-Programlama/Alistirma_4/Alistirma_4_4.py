def encrypt_vigenere(key: str, text: str, lan="en"):

    """

    Function that returns the text encrypted with the Vigenere Algorithm based on the key and text entered

    :param key: (str) Key to be used in order to decrypt text that is requested to be encrypted w/ Vigenere Algorithm
    :param text: (str) Text to be encrypted with the Vigenere Algorithm
    :param lan: ( Default Option = "en" ) Key to be used in order to decrypt text that is requested to be encrypted w/ Vigenere Algorithm
    :return: (str) Output text encrypted with Vigenere Algorithm

    Example: encrypt_vigenere("HELLO", "Text to be encrypted")
    return value: "aiiehvfppbjvjahlh"

    """

    for char in text:
        if not char.isalpha():
            text = text.replace(char, "")

    key = key.lower()
    text = text.lower()

    language_options = {
        "de": ["a", "ä", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "ö", "p", "q", "r", "s",
               "t", "u", "ü", "v", "w", "x", "y", "z", "ß"],
        "en": ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
               "v", "w", "x", "y", "z"],
        "fr": ["a", "à", "â", "b", "c", "ç", "d", "e", "é", "è", "ê", "ë", "f", "g", "h", "i", "î", "ï", "j", "k", "l",
               "m", "n", "o", "ô", "p", "q", "r", "s", "t", "u", "ù", "û", "ü", "v", "w", "x", "y", "ÿ", "z", "æ", "œ"],
        "tr": ["a", "b", "c", "ç", "d", "e", "f", "g", "ğ", "h", "ı", "i", "j", "k", "l", "m", "n", "o", "ö", "p", "r",
               "s", "ş", "t", "u", "ü", "v", "y", "z"]
    }

    if len(key) < len(text):
        key = str(key * (len(key) % len(text))) + str(key[:(len(text) - len(key))])
    elif len(key) > len(text):
        key = key[:text]

    value = ""
    for i in range(len(text)):
        index = language_options[lan].index(text[i]) + language_options[lan].index(key[i])
        value += language_options[lan][index] if index < len(language_options[lan]) else language_options[lan][
            index - ((index // (len(language_options[lan]) - 1)) * (len(language_options[lan]) - 1)) - 1]

    return value


def decipher_vigenere(key: str, text: str, lan="en"):

    """

    Function that decrypts and returns encrypted text according to Vigenere Algorithm with entered key

    :param key: (str) Key used to decrypt text encrypted with the Vigenere Algorithm
    :param text: (str) Text encrypted with a key using the Vigenere Algorithm
    :param lan: ( Default Option = "en" ) Language used to decrypt text encrypted with the Vigenere Algorithm
    :return: (str) Output text encrypted with Vigenere Algorithm

    Example: decipher_vigenere("HELLO", "aiiehvfppbjvjahlh")
    return value: "texttobeencrypted"

    """

    for char in text:
        if not char.isalpha():
            text = text.replace(char, "")

    key = key.lower()
    text = text.lower()

    language_options = {
        "de": ["a", "ä", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "ö", "p", "q", "r", "s",
               "t", "u", "ü", "v", "w", "x", "y", "z", "ß"],
        "en": ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
               "v", "w", "x", "y", "z"],
        "fr": ["a", "à", "â", "b", "c", "ç", "d", "e", "é", "è", "ê", "ë", "f", "g", "h", "i", "î", "ï", "j", "k", "l",
               "m", "n", "o", "ô", "p", "q", "r", "s", "t", "u", "ù", "û", "ü", "v", "w", "x", "y", "ÿ", "z", "æ", "œ"],
        "tr": ["a", "b", "c", "ç", "d", "e", "f", "g", "ğ", "h", "ı", "i", "j", "k", "l", "m", "n", "o", "ö", "p", "r",
               "s", "ş", "t", "u", "ü", "v", "y", "z"]
    }

    if len(key) < len(text):
        key = str(key * (len(key) % len(text))) + str(key[:(len(text) - len(key))])
    elif len(key) > len(text):
        key = key[:text]

    value = ""
    for i in range(len(text)):
        index = len(language_options[lan]) - (
                    language_options[lan].index(key[i]) - language_options[lan].index(text[i]))
        value += language_options[lan][index] if index < len(language_options[lan]) else language_options[lan][
            index - len(language_options[lan])]

    return value