def sum_total(n):
    if n == 1:
        return 1
    else:
        return n + sum_total(n-1)


num = int(input("n: "))
print(sum_total(num))