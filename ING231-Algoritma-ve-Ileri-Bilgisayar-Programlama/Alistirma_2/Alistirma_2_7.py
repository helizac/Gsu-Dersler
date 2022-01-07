def binary_search(myList: list, begin, end, x):
    if end >= begin:

        mid = (end + begin) // 2

        if myList[mid] == x:
            return mid

        elif myList[mid] > x:
            return binary_search(myList, begin, mid - 1, x)

        else:
            return binary_search(myList, mid + 1, end, x)

    else:
        return None


def binary_search_recursive(myArray: list, a):
    return binary_search(myArray, 0, len(myArray), a)


"""

    <= Example Usage =>

    list = [a, b, c, ..., z]

    print(binary_search_recursive(list, n))

"""
