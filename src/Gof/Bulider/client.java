package Gof.Bulider;

public class client {

    public static void main(String[] args) {
        HouseDirector houseDirector = new HouseDirector(new CommonHouse());
        houseDirector.constructHouse();
    }
   
}
