package Gof.Singleton.Factory.simpleFactory;

public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给中国披散准备原材料！！");
    }
}