for i in range(100, 1000):
    #"100"==> ["1","0","0"]
    #"326"==> ["3","2","6"]
    if int(str(i)[0]) + int(str(i)[1]) == int(str(i)[2]):
        print(i)
