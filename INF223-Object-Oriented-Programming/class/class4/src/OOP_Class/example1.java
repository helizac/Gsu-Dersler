package OOP_Class;

class automobile {
    static String model = "BMW";

    void changeModelName(){
        model = "MERCEDES";
    }
    static void printModelName(){
        System.out.println(model);
    }
}

public class example1 {
    public static void main(String[] args){
        automobile a = new automobile();
        automobile b = new automobile();

        a.printModelName();
        b.printModelName();
        automobile.printModelName();

        a.changeModelName();

        a.printModelName();
        b.printModelName();
        automobile.printModelName();

        System.out.println(a.model);
        System.out.println(b.model);
        System.out.println(automobile.model);
    }
}

/*

BMW
BMW
BMW
MERCEDES
MERCEDES
MERCEDES
MERCEDES
MERCEDES
MERCEDES

 */