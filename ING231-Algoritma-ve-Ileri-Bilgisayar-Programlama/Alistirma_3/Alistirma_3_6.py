import random


def counting_sort(_list: list):
    c = [0] * (max(_list) + 1)
    output = []

    for i in _list:
        c[i] += 1

    for i in range(1, len(c)):
        c[i] += c[i - 1]

    for i in range(1, len(c)):
        if c[i] != c[i-1]: output.append(i)

    return output


sample = random.sample(range(1, 50), 10)

print(f"Unsorted Array : {sample}")
print(f"Sorted Array   : {counting_sort(sample)}")
