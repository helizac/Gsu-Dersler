import random


def bubble_sort(_list: list):
    for i in range(len(_list)):
        for j in range(len(_list)-i-1):
            if _list[j] > _list[j+1]:
                _list[j], _list[j+1] = _list[j+1], _list[j]

    return _list


sample = random.sample(range(1, 50), 10)

print(f"Unsorted Array : {sample}")
print(f"Sorted Array   : {bubble_sort(sample)}")