import random


def brick_sort(_list: list):
    isSorted = False
    while not isSorted:
        isSorted = True
        for i in range(1, len(_list) - 1, 2):
            if _list[i] > _list[i + 1]:
                _list[i], _list[i + 1] = _list[i + 1], _list[i]
                isSorted = False

        for i in range(0, len(_list) - 1, 2):
            if _list[i] > _list[i + 1]:
                _list[i], _list[i + 1] = _list[i + 1], _list[i]
                isSorted = False

    return _list


sample = random.sample(range(1, 50), 10)

print(f"Unsorted Array : {sample}")
print(f"Sorted Array   : {brick_sort(sample)}")