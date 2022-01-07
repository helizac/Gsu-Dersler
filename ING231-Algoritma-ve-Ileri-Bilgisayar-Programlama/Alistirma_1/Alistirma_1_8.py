myNumber = 0

for i in range(100,999):
    if i%2 == 0:
        equal = 0
        if str(i)[0] == str(i)[1]:
            equal += 1
        if str(i)[0] == str(i)[2]:
            equal += 1
        if str(i)[1] == str(i)[2]:
            equal += 1
        
        if equal >= 1:
            myNumber += 1
        
print(myNumber)
