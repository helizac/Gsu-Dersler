import random


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


sample = random.sample(range(1, 50), 10)

print(f"Unsorted Array : {sample}")
print(f"Sorted Array   : {quick_sort(sample)}")
