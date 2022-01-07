myList = []
list_i = []
for i in range(1,125):
    if 125%i == 200%i == 350%i:
        list_i.append(i)
        myList.append(125%i)
        
print(list_i[myList.index(max(myList))])
