package New;

public class palindromic {

    static void printPalindromic(int start, int recurrence){

        String strRecurrence = String.valueOf(recurrence);
        int strLength = strRecurrence.length();

        for(int j = start; j < recurrence; j++){
            String myStr = String.valueOf(j);
            boolean control = true;

            for(int i=0; i < strLength/2; i++){
                if(myStr.charAt(i) != myStr.charAt(myStr.length()-i-1)){
                    control = false;
                }
            }
            if(control){System.out.println(myStr);}
        }
    }

    public static void printAllBetween(int numberOfDigits){
        printPalindromic(10^numberOfDigits, (10^(numberOfDigits+1)));
    }
    public static void main(String[] args){
        printAllBetween(5);
    }
}