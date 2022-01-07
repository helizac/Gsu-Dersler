import random


def take_input():
    try:
        user_input = int(input("Lütfen 10 ile 98 arasında bir sayı giriniz. ( 10 ve 98 dahil ) ==> "))
        if not (10 <= user_input <= 98):
            print("Nizami bir sayı giriniz!")
            take_input()
        return user_input
    except:
        print("Lütfen bir TAMSAYI giriniz!")
        take_input()


mastermind = True
while mastermind:

    userInput = 0

    dogruyer = yanlisyer = 0

    number = random.randint(10, 98)

    while str(number)[0] == str(number)[1]:
        number = random.randint(10, 98)

    while userInput != number:
        userInput = take_input()
        if str(userInput)[0] == str(number)[0] or str(userInput)[1] == str(number)[1]:
            dogruyer += 1
        if str(userInput)[0] != str(number)[0] or str(userInput)[1] != str(number)[1]:
            yanlisyer -= 1
        print(f"Doğru Yer: {dogruyer}\nYanlış Yer: {yanlisyer}")

    print(f"\nDoğru Sayı! Oyunu Kazandınız >> {number}")

    loop = True
    while loop:
        print()
        yes_no = input("Bir oyun daha oynamak ister misin ? Evet : e / Hayır : h ")
        if yes_no == "e":
            loop = False
            mastermind = True
        elif yes_no == "h":
            loop = False
            mastermind = False
            print("\nOyun Bitti!")
        else:
            loop = True
