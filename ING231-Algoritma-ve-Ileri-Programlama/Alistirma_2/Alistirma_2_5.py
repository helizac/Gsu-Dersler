def isPrime(n, i=2):
    if n == 2:
        return True
    elif n < 2:
        return False

    if n % i == 0:
        return False
    if i * i > n:
        return True

    return isPrime(n, i + 1)


for j in range(10000, 100000): #34346 --> b = "furkan" b[:4]
    isNumberSuperPrime = True
    for a in range(len(str(j))):
        if not isPrime(int(str(j)[:len(str(j))-a])):
            isNumberSuperPrime = False
        if not isNumberSuperPrime:
            break
    if isNumberSuperPrime:
        print(j)