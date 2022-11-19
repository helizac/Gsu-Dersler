from typing import List


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
