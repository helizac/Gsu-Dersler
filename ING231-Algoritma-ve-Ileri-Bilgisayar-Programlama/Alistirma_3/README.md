# Sorting Algorithms in Python and Comparisons

## Comparisons of Algoritms

<div align="center">
   <p>The data in this picture consists of random lists with increasing number of elements in the list.<br></p>
   <div>
      <p float="left">
         <img align="left" src="https://github.com/helizac/Gsu-Dersler/blob/main/ING231-Algoritma-ve-Ileri-Bilgisayar-Programlama/Alistirma_3/Sorting%20Algorithms.png" width=450>
         <table>
            <thead>
               <tr>
                  <th align="center">Algorithm</th>
                  <th align="center">Best Case</th>
                  <th align="center">Worst Case</th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td align="center">Cocktail Sort</td>
                  <td align="center">O(n)</td>
                  <td align="center">O(n^2)</td>
               </tr>
               <tr>
                  <td align="center">Brick Sort</td>
                  <td align="center">O(n)</td>
                  <td align="center">O(n^2)</td>
               </tr>
                <tr>
                  <td align="center">Insertion Sort</td>
                  <td align="center">O(n)</td>
                  <td align="center">O(n^2)</td>
               </tr>
                <tr>
                  <td align="center">Count Sort</td>
                  <td align="center">O(n+k)</td>
                  <td align="center">O(n+k)</td>
               </tr>
                <tr>
                  <td align="center">Merge Sort</td>
                  <td align="center">O(nlog(n))</td>
                  <td align="center">O(nlog(n))</td>
               </tr>
                <tr>
                  <td align="center">Selection Sort</td>
                  <td align="center">O(n^2)</td>
                  <td align="center">O(n^2)</td>
               </tr>
                <tr>
                  <td align="center">Bubble Sort</td>
                  <td align="center">O(n)</td>
                  <td align="center">O(n^2)</td>
               </tr>
                <tr>
                  <td align="center">Quick Sort</td>
                  <td align="center">O(nlog(n))</td>
                  <td align="center">O(n^2)</td>
               </tr>
            </tbody>
         </table>
      </p>
   </div>
</div>

### Gnome Sort

```
def gnome_sort(_list: list):
    pos = 0
    while pos < len(_list):
        if pos == 0 or _list[pos] >= _list[pos - 1]:
            pos += 1
        else:
            _list[pos], _list[pos - 1] = _list[pos - 1], _list[pos]
            pos -= 1

    return _list
```

### Insertion Sort
```
def insertion_sort(_list: list):
    for i in range(1, len(_list)):
        key = _list[i]
        j = i - 1

        while j >= 0 and key < _list[j]:
            _list[j + 1] = _list[j]
            j -= 1
        _list[j + 1] = key

    return _list
```

### Selection Sort
```
def selection_sort(_list: list):
    for i in range(len(_list)):
        for j in range(i + 1, len(_list)):
            if _list[j] < _list[i]:
                _list[i], _list[j] = _list[j], _list[i]

    return _list
```

### Counting Sort
```
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
```

### Bubble Sort
```
def bubble_sort(_list: list):
    for i in range(len(_list)):
        for j in range(len(_list) - i - 1):
            if _list[j] > _list[j + 1]:
                _list[j], _list[j + 1] = _list[j + 1], _list[j]

    return _list
```

### Cocktail Sort
```
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
```

### Brick Sort
```
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
```

### Quick Sort
```
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
```

### Merge Sort
```
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
```
