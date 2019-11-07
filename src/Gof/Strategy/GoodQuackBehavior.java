package Gof.Strategy;

public class GoodQuackBehavior implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("大声的叫");
    }
}
