package org.sd.decorator;

import javax.swing.*;

public interface ICar {
    void move();
}

//concrete component
class Car implements ICar{

    @Override
    public void move() {
        System.out.println("在陆地上跑");
    }
}
//装饰角色
class SuperCar implements ICar{

    protected  ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
       car.move();
    }
}

//concreter decorator
class FlyCar extends SuperCar
{
    public FlyCar(ICar car)
    {super(car);}
    public void fly()
    {
        System.out.println("天上飞");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}
class SwimmingCar extends SuperCar{
    public SwimmingCar(ICar car)
    {
        super(car);
    }
    public void swim()
    {
        System.out.println("水中游");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
}
