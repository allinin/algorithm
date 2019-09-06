package Gof.Singleton.Factory.factorymethod.order;

import Gof.Singleton.Factory.factorymethod.pizza.LDCheesePizza;
import Gof.Singleton.Factory.factorymethod.pizza.LDPepperPizza;
import Gof.Singleton.Factory.factorymethod.pizza.Pizza;

public class LDOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderPizza) {
        Pizza pizza = null;
        if(orderPizza.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderPizza.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        // TODO Auto-generated method stub
        return pizza;
    }
}
