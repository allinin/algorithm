package Gof.Factory.simpleFactory;

public class SimpleFatory {

    String orderType="";

    public Pizza createPizza(String orderType)
    {
        Pizza pizza=null;
        if(orderType.equals("cheese"))
        {
            pizza=new CheesePizza();
            pizza.setName("奶酪披萨");
        }else if(orderType.equals("greek"))
        {
            pizza=new GreekPizza();
            pizza.setName("希腊披萨");
        }else if(orderType.equals("pepper"))
        {
            pizza=new PepperPizza();
            pizza.setName("胡椒披萨");
        }
        return pizza;
    }
}
