for i in range(10000,99999):
   # prime numbers are greater than 1
   if i > 1:
       for j in range(7,i):
           if ( (i % 2 == 0) or (i % 3 == 0) or (i % 5 == 0) or (i % 7 == 0)):
               break
           if (i % j) == 0:
               break
       else:
           print(i)
