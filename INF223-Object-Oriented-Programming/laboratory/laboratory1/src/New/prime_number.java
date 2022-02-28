package New;

public class prime_number {

    public static void isNumber(int number){

        boolean flag = false;
        for(int i = 2; i <= number/2; ++i){
            if(number % i == 0){
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println(number);
        }
    }

    public static void printAllBetween(int numberOfDigits){
        for(int i = 10^numberOfDigits; i < (10^(numberOfDigits+1)); i++){
            isNumber(i);
        }
    }

    public static void main(String[] args){ printAllBetween(5); }
}