package New;

public class find_pi {

    static float inFin(int n){
        float total = 0;
        for(float i = 1; i < n; i++){
            total += 1/(i*i);
        }
        return total;
    }

    public static void main(String[] args){

        double pi = Math.sqrt(6*inFin(1000));
        System.out.println(pi);

    }
}