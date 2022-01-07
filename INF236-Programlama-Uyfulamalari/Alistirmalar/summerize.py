s1 = ['w1', 'w2', 'w3']
s2 = ['w2', 'w4', 'w5']
s3 = ['w1', 'w6', 'w7']
s4 = ['w2', 'w4', 'w8']
sentences = [s1, s2, s3, s4]


def summerize(list_of_sentences, number_of_wanted_sentence):
    words = sorted(set(sentence for list in list_of_sentences for sentence in list))

    scores = dict()

    for word in words:
        scores[word] = 0
        for sentence in sentences:
            if word in sentence:
                scores[word] += 1

    sentence_scores = [0] * len(sentences)
    # [[0, 6], [1, 6], [2, 4], [3, 6]]

    for i, c in enumerate(sentences):
        sentence_score = 0
        for word in c:
            sentence_score += scores[word]
        sentence_scores[i] = [i, sentence_score]

    sentence_scores.sort(reverse=True, key=lambda x: x[1])
    sentence_scores = sentence_scores[:number_of_wanted_sentence]

    print(sentence_scores)

    list = []
    for i in range(len(sentence_scores)):
        list.append(sentences[sentence_scores[i][0]])
    return list


print(summerize(sentences, 3))
