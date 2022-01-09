import random


def selection_sort(_list: list):
    for i in range(len(_list)):
        for j in range(i + 1, len(_list)):
            if _list[j] < _list[i]:
                _list[i], _list[j] = _list[j], _list[i]

    return _list


sample = random.sample(range(1, 50), 10)

print(f"Unsorted Array : {sample}")
print(f"Sorted Array   : {selection_sort(sample)}")