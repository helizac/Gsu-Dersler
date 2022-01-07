def binary_search_non_recursive(myList: list, myNumber):
    begin = 0
    end = len(myList) - 1

    while begin <= end:
        middle = begin + (end - begin) // 2
        middle_value = myList[middle]

        if middle_value == myNumber:
            return middle

        elif myNumber < middle_value:
            end = middle - 1

        else:
            begin = middle + 1

    return None

"""

    <= Example Usage =>
    
    list = [a, b, c, ..., z]
                     
    print(binary_search_non_recursive(list, n))
                        
"""
