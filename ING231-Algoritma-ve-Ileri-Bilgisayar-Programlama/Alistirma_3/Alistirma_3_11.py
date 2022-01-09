import random


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


sample = random.sample(range(1, 50), 10)

print(f"Unsorted Array : {sample}")
print(f"Sorted Array   : {merge_sort(sample)}")