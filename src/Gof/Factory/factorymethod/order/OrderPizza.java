package Gof.Factory.factorymethod.order;

import Gof.Factory.factorymethod.pizza.Pizza;

import java.util.Scanner;

public abstract class OrderPizza {

    abstract Pizza createPizza(String orderPizza);

    public OrderPizza()
    {
        Pizza pizza=null;
        String orderType="";
        do{
            orderType=getOrderType();
            pizza=createPizza(orderType);
            if(pizza!=null)
            {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.bake();
            }else {
                break;
            }

        }while(true);

    }

    public String getOrderType()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入pizza的种类： ");
        String str=scanner.next();
        return str;
    }
}
