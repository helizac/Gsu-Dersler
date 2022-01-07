import math

number_weight = 1000

myNumber = 0

for i in range(1, number_weight):
    myNumber += 1/i**2    
pi = math.sqrt(6*(myNumber))

print(pi)
