def myDef():
    for i in range(10,99):
        for j in range(10,99):
            if int(str(i)+str(j)) == (i + j)*11:
                return i, j
            
print(f"{myDef()}")
