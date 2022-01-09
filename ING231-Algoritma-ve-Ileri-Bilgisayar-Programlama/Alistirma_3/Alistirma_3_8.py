import random


def cocktail_sort(_list: list):
    swapped = True
    start = 0
    end = len(_list) - 1
    while swapped:
        swapped = False

        for i in range(start, end):
            if _list[i] > _list[i + 1]:
                _list[i], _list[i + 1] = _list[i + 1], _list[i]
                swapped = True

        if not swapped:
            break

        swapped = False

        end = end - 1

        for i in range(end - 1, start - 1, -1):
            if _list[i] > _list[i + 1]:
                _list[i], _list[i + 1] = _list[i + 1], _list[i]
                swapped = True

        start = start + 1

    return _list


sample = random.sample(range(1, 50), 10)

print(f"Unsorted Array : {sample}")
print(f"Sorted Array   : {cocktail_sort(sample)}")