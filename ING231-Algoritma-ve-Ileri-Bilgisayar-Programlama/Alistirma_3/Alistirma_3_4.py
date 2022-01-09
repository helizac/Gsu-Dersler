import random


def insertion_sort(_list: list):
    for i in range(1, len(_list)):
        key = _list[i]
        j = i - 1

        while j >= 0 and key < _list[j]:
            _list[j + 1] = _list[j]
            j -= 1
        _list[j + 1] = key

    return _list


sample = random.sample(range(1, 50), 10)

print(f"Unsorted Array : {sample}")
print(f"Sorted Array   : {insertion_sort(sample)}")