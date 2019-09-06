package Gof.Singleton.Factory.factorymethod.abstractFactoryOrder;

import Gof.Singleton.Factory.factorymethod.pizza.BJCheesePizza;
import Gof.Singleton.Factory.factorymethod.pizza.BJPepperPizza;
import Gof.Singleton.Factory.factorymethod.pizza.Pizza;
import org.sd.composite.AbstractFile;

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
