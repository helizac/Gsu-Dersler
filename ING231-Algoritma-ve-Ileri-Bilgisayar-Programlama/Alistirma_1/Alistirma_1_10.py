total = 0

for i in range(10000, 99999):
    if(int(str(i)[0])+int(str(i)[1]) == int(str(i)[3])+int(str(i)[4])):
        total += 1
        
print(total)
