package Gof.Factory.factorymethod.abstractFactoryOrder;

import Gof.Factory.factorymethod.pizza.BJCheesePizza;
import Gof.Factory.factorymethod.pizza.BJPepperPizza;
import Gof.Factory.factorymethod.pizza.Pizza;

public class BJFactory implements AbsFactory{

    @Override
    public Pizza createPizze(String orderType) {
        Pizza pizza=null;
        if(orderType.equals("cheese"))
        {
            pizza=new BJCheesePizza();
        }else if(orderType.equals("pepper"))
        {
            pizza=new BJPepperPizza();
        }
        return pizza;
    }
}
