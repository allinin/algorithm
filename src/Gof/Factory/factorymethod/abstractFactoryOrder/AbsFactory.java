package Gof.Factory.factorymethod.abstractFactoryOrder;

import Gof.Factory.factorymethod.pizza.Pizza;

public interface AbsFactory {
    public Pizza createPizze(String orderType);
}
