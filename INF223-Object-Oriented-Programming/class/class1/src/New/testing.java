package New;

class automobile {

    private String brand;
    public String getBrand(){ // Read Authority
        return this.brand;
    }
    public void setBrand(String brand){ // Write Authority
        this.brand = brand;
    }
}

public class testing {
    public static void main(String[] args){
        automobile _automobile = new automobile();

        System.out.println(_automobile.getBrand());

        _automobile.setBrand("New Brand");
        System.out.println(_automobile.getBrand());
    }
}