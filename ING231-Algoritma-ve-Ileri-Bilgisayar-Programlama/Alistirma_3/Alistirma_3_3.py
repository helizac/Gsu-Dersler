import random


def gnome_sort(_list: list):
    pos = 0
    while pos < len(_list):
        if pos == 0 or _list[pos] >= _list[pos-1]:
            pos += 1
        else:
            _list[pos], _list[pos-1] = _list[pos-1], _list[pos]
            pos -= 1

    return _list


sample = random.sample(range(1, 50), 10)

print(f"Unsorted Array : {sample}")
print(f"Sorted Array   : {gnome_sort(sample)}")