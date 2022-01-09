import random


def stupid_sort(_list: list):
    while not all(a <= b for a, b in zip(_list, _list[1:])):
        random.shuffle(_list)

    return _list


sample = random.sample(range(1, 50), 10)

print(f"Unsorted Array : {sample}")
print(f"Sorted Array   : {stupid_sort(sample)}")