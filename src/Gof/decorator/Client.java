package Gof.decorator;

public class Client {
    public static void main(String[] args) {
        Drink drink=new LongBlack();

        MikeCoffee mikeCoffee=new MikeCoffee(drink);
        System.out.println(mikeCoffee.getDes());
        System.out.println(mikeCoffee.getPrice());
    }
}
