package Gof.Factory.factorymethod.abstractFactoryOrder;

import Gof.Factory.factorymethod.pizza.LDCheesePizza;
import Gof.Factory.factorymethod.pizza.LDPepperPizza;
import Gof.Factory.factorymethod.pizza.Pizza;

public class LDFactory implements AbsFactory {
    @Override
    public Pizza createPizze(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
