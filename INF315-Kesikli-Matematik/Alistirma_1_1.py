from typing import List


# Exemple 1
def pgcd(nombres: List[int]):
    result = nombres[0]
    for x in nombres[1:]:
        if result < x:
            temp = result
            result = x
            x = temp

        while x != 0:
            temp = x
            x = result % x
            result = temp

    return result


# Exemple 2
def ppcm(nombres: List[int]):
    def _pgcd(a, b):
        if a == 0:
            return b
        return _pgcd(b % a, a)

    res = nombres[0]
    for i in nombres[1:]:
        res *= i // _pgcd(res, i)
    return res


# Exemple 3
def premierEntreEux(valuer1: int, valuer2: int):
    return True if (pgcd([valuer1, valuer2]) == 1) else False


# Exemple 4
def estPremier(valeur, i=2):
    if valeur <= 2:
        return True if (valeur == 2) else False
    if valeur % i == 0:
        return False
    if i * i > valeur:
        return True

    return estPremier(valeur, i + 1)


# Exemple 5
from time import time


def execution_exemple():
    start_time = time()
    calculate_something = 10000 ** 10000 - 9999 ** 9999
    end_time = time()
    execution_time = end_time - start_time

    print("{:.10f}".format(execution_time))


# Exemple 6
def compare_execution_time():
    def estPremier2(n):
        for i in range(2, int(n ** (1 / 2) + 1)):
            if (n % i) == 0:
                return False
        return True

    start_time1 = time()
    estPremier(524287)
    end_time1 = time()
    execution_time1 = end_time1 - start_time1
    print(f"estPremier method execution time: " + "{:.10f}".format(execution_time1))

    start_time2 = time()
    estPremier2(524287)
    end_time2 = time()
    execution_time2 = end_time2 - start_time2
    print(f"estPremier2 method execution time: " + "{:.10f}".format(execution_time2))

    print("estPremier2 est plus rapide que estPremier" if (execution_time2 < execution_time1) else (
        "estPremier2 est égal à bestPremier" if (execution_time2 == execution_time1) else "estPremier2 plus lent que bestPremier"))


# Exemple 7
def calculerBezout(a: int, b: int):
    if b == 0:
        print(f"{a}x1+{b}x0={a}")
        return 1, 0, a
    else:
        q, r = a // b, a % b
        x, y, g = calculerBezout(b, r)

        return y, x - q * y, g


# Exemple 8
def calculerPermutation(mot: str):
    def factorial(n):
        if n == 1:
            return 1
        else:
            return n * factorial(n-1)

    a = factorial(len(mot))

    _dict = {}
    for i in mot:
        if i in _dict:
            _dict[i] += 1
        else:
            _dict[i] = 1

    b = 1
    for value in _dict.values():
        b *= factorial(value)

    print(f"Le nombre de mots possibles que l’on peut écrire avec les caractères de '{mot}': {a//b}")

    return a//b


# Exemple 9
def combinaison(n, p):
    def factorial(x):
        if x == 1:
            return 1
        else:
            return x * factorial(x-1)

    return factorial(n)//(factorial(n-p)*factorial(p))


# Exemple 10
def calculerDeterminant(matrice: List[List[int]]):
    """
    :param matrice: Example : [[1, 2, 3], [4, 5, 4], [3, 2, 1]] -> -8
    :return: Determinant of matrix
    """
    if not all(len(matrice[k]) == len(matrice) for k in range(len(matrice))):
        raise SyntaxError("La matrice doit être une matrice carrée.")

    n = len(matrice)
    for i in range(n):
        for j in range(i+1, n):
            matrice[j] = [x - y for x, y in zip(matrice[j], [k*(matrice[j][i]/matrice[i][i]) for k in matrice[i]])]

    prod = 1

    for i in range(n):
        prod *= matrice[i][i]

    return round(prod, 10)
