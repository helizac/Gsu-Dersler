_input = int(input("Lütfen bir tamsayı giriniz."))

boolean1 = True
for i in range(2, _input-1):
    if _input%i == 0:
        print(f"{_input} bir asal sayı değildir")
        boolean1 = False
        break

if boolean1:
    print(f"{_input} bir asal sayıdır")
