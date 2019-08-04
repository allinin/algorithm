package org.sd.FlyWeight;

public class Client {
    public static void main(String[] args) {
        ConcreteChess chess1=FlyWeightFactory.getChess("block");
        ConcreteChess chess2=FlyWeightFactory.getChess("block");

        System.out.println(chess1);
        System.out.println(chess2);
    }
}

