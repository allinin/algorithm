package Gof.Singleton.Factory.simpleFactory;

public class Test {
    public static void main(String[] args) {
        new OrderPizza(new SimpleFatory());
        System.out.println("结束");
    }
}
