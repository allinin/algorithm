package Gof.Singleton.Factory.factorymethod.order;

import Gof.Singleton.Factory.factorymethod.pizza.BJCheesePizza;
import Gof.Singleton.Factory.factorymethod.pizza.BJPepperPizza;
import Gof.Singleton.Factory.factorymethod.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderPizza) {

        Pizza pizza=null;
        if(orderPizza.equals("cheese"))
       {
           pizza=new BJCheesePizza();

       }else if(orderPizza.equals("pepper"))
        {
            pizza=new BJPepperPizza();
        }
        return pizza;
    }
}
