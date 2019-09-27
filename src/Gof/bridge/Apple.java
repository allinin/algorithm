package Gof.bridge;

public class Apple implements Brand{

    @Override
    public void open() {
        System.out.println("苹果手机开机");

    }

    @Override
    public void call() {
        System.out.println("苹果手机开机");

    }

    @Override
    public void close() {
        System.out.println("苹果手机开机");

    }
}
