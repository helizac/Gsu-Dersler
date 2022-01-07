number_weight = 1000

myNumber = 0

def myFactorial(number):
	factorial_number = 1
	if number is not 0:
		for i in range(1, number):
			factorial_number *= i
		return factorial_number
	else:
		return 0

for i in range(1, number_weight):
    myNumber += 1/myFactorial(i)   

e = myNumber

print(e)
