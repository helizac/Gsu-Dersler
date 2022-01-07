_input = input("Sayı: ")

if len(_input) == 3:
    if _input[0] == _input[2]:
        print(f"{_input} bir palindromik sayıdır.")
    else:
        print(f"{_input} bir palindromik sayı değildir.")
elif len(_input) == 4:
    if _input[0] == _input[3] and _input[1] == _input[2]:
        print(f"{_input} bir palindromik sayıdır.")
    else:
        print(f"{_input} bir palindromik sayı değildir.")
