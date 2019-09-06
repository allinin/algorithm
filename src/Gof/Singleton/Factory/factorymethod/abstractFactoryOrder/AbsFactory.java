package Gof.Singleton.Factory.factorymethod.abstractFactoryOrder;

import Gof.Singleton.Factory.factorymethod.pizza.Pizza;

public interface AbsFactory {
    public Pizza createPizze(String orderType);
}
