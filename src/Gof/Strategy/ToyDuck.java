package Gof.Strategy;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class ToyDuck extends Duck{

    public ToyDuck(){
        flyBehavior=new NoFlyBehavior();
        quackBehavior=new NoQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("玩具鸭");
    }

    public void quack() {
        System.out.println("玩具鸭不能叫~~");
    }

    public void swim() {
        System.out.println("玩具鸭不会游泳~~");
    }
}
