package Gof.Singleton.Factory.simpleFactory;

public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给希腊披散准备原材料！！");
    }
}
