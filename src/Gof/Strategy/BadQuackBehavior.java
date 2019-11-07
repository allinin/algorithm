package Gof.Strategy;

public class BadQuackBehavior implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("小声的叫");
    }
}
