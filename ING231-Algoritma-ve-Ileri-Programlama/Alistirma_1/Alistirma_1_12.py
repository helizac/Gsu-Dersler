def question14(birth_year):
    age = 2005 - birth_year
    
    sum_of_numbers = 0
    for i in str(birth_year):
        sum_of_numbers += int(i)
    
    if age == sum_of_numbers:
        print(birth_year)
        
for i in range(2005):
    question14(i)
