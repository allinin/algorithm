package Gof.Strategy;

public class NoQuackBehavior implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("我根本不会叫啊");
    }
}
