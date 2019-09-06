package Gof.Singleton.Factory.factorymethod.abstractFactoryOrder;

import Gof.Singleton.Factory.factorymethod.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    AbsFactory absFactory;

    public OrderPizza(AbsFactory absFactory)
    {
        setAbsFactory(absFactory);
    }

    private void setAbsFactory(AbsFactory absFactory)
    {
        String orderType="";
        Pizza pizza=null;
        this.absFactory=absFactory;
        do{
            orderType=getType();
            pizza=absFactory.createPizze(orderType);
            if(pizza!=null)
            {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                break;
            }
        }while(true);
    }

    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
