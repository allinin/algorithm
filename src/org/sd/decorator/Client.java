package org.sd.decorator;



public class Client {
    public static void main(String[] args) {
        ICar car=new Car();
        car.move();
        FlyCar flyCar=new FlyCar(car);
        flyCar.move();
        SwimmingCar swimmingCar =new SwimmingCar(car);
        swimmingCar.move();
        SwimmingCar swimmingCar1=new SwimmingCar(flyCar);
        swimmingCar1.move();
    }
}
