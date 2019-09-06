package Gof.Singleton.Factory.factorymethod.abstractFactoryOrder;

public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new BJFactory());
    }
}
