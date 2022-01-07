#helizac çözümü
def cosine_similarity(vector1, vector2):
    sumxx, sumxy, sumyy = 0, 0, 0
    for i in range(len(vector1)):
        x = vector1[i]
        y = vector2[i]
        sumxx += x * x
        sumyy += y * y
        sumxy += x * y
    return sumxy / (sumxx ** .5 * sumyy ** .5)


X = [1, 0, 0, 0, 7, 0, 3]
Y = [1, 0, 0, 0, 7, 0, 3]

print(cosine_similarity(X, Y))

print("------------")

#uzay00 çözümü

def dot(X, Y):
    result = 0
    for i in range(len(X)):
        result += X[i] * Y[i]
    return result


def norm(X):
    result = dot(X, X)
    return pow(result, 1 / 2)


def cos(X, Y):
    return dot(X, Y) / (norm(X) * norm(Y))


print(cos(X, Y))
