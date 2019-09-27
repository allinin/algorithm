package Gof.decorator;

public class MikeCoffee extends Decorator{

    public MikeCoffee(Drink drink)
    {
        super(drink);
        setDes("加牛奶");
        setPrice(3.0f);
    }
}
