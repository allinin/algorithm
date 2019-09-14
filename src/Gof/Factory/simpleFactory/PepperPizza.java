package Gof.Factory.simpleFactory;


public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给胡椒披散准备元才来");
    }
}
