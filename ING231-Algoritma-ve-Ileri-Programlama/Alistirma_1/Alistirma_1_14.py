diff = 121212
myNumbers = []

scope = 1000

for i in range(scope):
	for j in range(scope):
		if i*j == 121212:
			if abs(i-j) < diff:
				diff = abs(i-j)
				myNumbers.clear()
				myNumbers.extend([i, j])

print(myNumbers)
