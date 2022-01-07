for i in range(1,999):
    myTotal = 0
    for j in range(len(str(i))):
        myTotal += int(str(i)[j])
        
    if myTotal < 9:
        print(i, end=" ")
