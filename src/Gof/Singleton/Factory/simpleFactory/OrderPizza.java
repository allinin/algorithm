package Gof.Singleton.Factory.simpleFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizza {

    Pizza pizza=null;
    SimpleFatory simpleFatory;

    public  OrderPizza(SimpleFatory simpleFatory)
    {
        setSimpleFatory(simpleFatory);
    }
    public void setSimpleFatory(SimpleFatory simpleFatory)
    {
        this.simpleFatory=simpleFatory;
        String orderType="";//用户输入
        do{
            orderType=getOrderType();
            Pizza pizza = simpleFatory.createPizza(orderType);
            if(pizza!=null)
            {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.bake();
            }else{
                break;
            }
        }while(true);
    }





    public  String getOrderType()
    {
        try{
            BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类：");
            String str= strin.readLine();
            return str;
        }catch (Exception e)
        {  e.printStackTrace();
            return "";
        }
    }
}
