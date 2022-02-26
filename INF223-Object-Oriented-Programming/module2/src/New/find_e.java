package New;

public class find_e {

    static int factorial(int n){
        if (n == 0)
            return 1;
        else
            return(n * factorial(n-1));
    }

    public static void main(String[] args){

        float e = 0;

        for(int i = 0; i < 20; ++i){
            float myFac = (float) (1.0/factorial(i));
            e += myFac;
        }
        System.out.println(e);
    }
}