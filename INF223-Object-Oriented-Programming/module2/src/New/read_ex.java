package New;

import java.util.Scanner;

public class read_ex {

    public static void isNumber(int number){

        if(number > 0){
            boolean flag = false;
            for(int i = 2; i <= number/2; ++i){
                if(number % i == 0){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                System.out.println(number + " is a prime number.");
            }
            else{
                System.out.println(number + " is not a prime number!");
            }
        }
        else{
            System.out.println("Prime numbers can be checked for numbers greater than 0");
        }

    }

    public static void main(String[] args){
        Scanner myInput = new Scanner(System.in);
        int i = myInput.nextInt();

        isNumber(i);
    }
}
