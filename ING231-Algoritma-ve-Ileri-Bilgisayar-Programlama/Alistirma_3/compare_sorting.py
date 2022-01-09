import random
from timeit import default_timer as timer
import matplotlib.pyplot as plt


def stupid_sort(_list: list):
    while not all(a <= b for a, b in zip(_list, _list[1:])):
        random.shuffle(_list)

    return _list


def gnome_sort(_list: list):
    pos = 0
    while pos < len(_list):
        if pos == 0 or _list[pos] >= _list[pos - 1]:
            pos += 1
        else:
            _list[pos], _list[pos - 1] = _list[pos - 1], _list[pos]
            pos -= 1

    return _list


def insertion_sort(_list: list):
    for i in range(1, len(_list)):
        key = _list[i]
        j = i - 1

        while j >= 0 and key < _list[j]:
            _list[j + 1] = _list[j]
            j -= 1
        _list[j + 1] = key

    return _list


def selection_sort(_list: list):
    for i in range(len(_list)):
        for j in range(i + 1, len(_list)):
            if _list[j] < _list[i]:
                _list[i], _list[j] = _list[j], _list[i]

    return _list


def counting_sort(_list: list):
    c = [0] * (max(_list) + 1)
    output = []

    for i in _list:
        c[i] += 1

    for i in range(1, len(c)):
        c[i] += c[i - 1]

    for i in range(1, len(c)):
        if c[i] != c[i - 1]: output.append(i)

    return output


def bubble_sort(_list: list):
    for i in range(len(_list)):
        for j in range(len(_list) - i - 1):
            if _list[j] > _list[j + 1]:
                _list[j], _list[j + 1] = _list[j + 1], _list[j]

    return _list


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


def quick_sort(_list):
    def sort(_list, low, high):
        if len(_list) == 1:
            return _list
        if low < high:
            i = (low - 1)

            for j in range(low, high):
                if _list[j] <= _list[high]:
                    i = i + 1
                    _list[i], _list[j] = _list[j], _list[i]

            _list[i + 1], _list[high] = _list[high], _list[i + 1]
            i += 1

            sort(_list, low, i - 1)
            sort(_list, i + 1, high)
        return _list

    return sort(_list, 0, len(_list) - 1)


def merge_sort(_list):
    list_length = len(_list)
    output = []
    i = j = 0

    if list_length == 1:
        return _list

    mid_point = list_length // 2

    left_partition = merge_sort(_list[:mid_point])
    right_partition = merge_sort(_list[mid_point:])

    while i < len(left_partition) and j < len(right_partition):
        if left_partition[i] < right_partition[j]:
            output.append(left_partition[i])
            i += 1
        else:
            output.append(right_partition[j])
            j += 1
    output.extend(left_partition[i:])
    output.extend(right_partition[j:])

    return output


sorting_algorithms = {  # "Stupid Sort": stupid_sort,
    "Gnome Sort": gnome_sort,
    "Insertion Sort": insertion_sort,
    "Selection Sort": selection_sort,
    "Counting Sort": counting_sort,
    "Bubble Sort": bubble_sort,
    "Cocktail Sort": cocktail_sort,
    "Brick Sort": brick_sort,
    "Quick Sort": quick_sort,
    "Merge Sort": merge_sort
}

comparison_datas = {}

sample = random.sample(range(1, 50), 1)

for name, value in sorting_algorithms.items():
    start_time = timer()
    value(sample)
    comparison_datas[name] = [timer() - start_time]

for i in sorted(random.sample(range(1, 1000), 50)):
    sample = random.sample(range(1, 1000), i)

    for name, value in sorting_algorithms.items():
        start_time = timer()
        value(sample)
        comparison_datas[name].append(timer() - start_time)

comparison_datas = sorted(comparison_datas.items(), key=lambda x: sum(x[1]))
print(comparison_datas)

plt.xlabel("Number of Elements in List")
plt.ylabel("Run Time")
plt.title("Sorting Algoritm Comparison")
for i in range(len(comparison_datas)-1):
    plt.plot(comparison_datas[i][1], label=str(comparison_datas[i][0]))
plt.legend()
plt.show()