package org.sd.prototype;

import java.util.Date;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date(1234788848);
        Sheep s1 = new Sheep("多里", date);
        System.out.println(s1);
        System.out.println(s1.getName());
        System.out.println(s1.getDate());
        //date.setTime(23432432423L);

        Sheep s2 = (Sheep) s1.clone();
        date.setTime(23432432423L);
        System.out.println(s2);
        System.out.println(s2.getName());
        System.out.println(s2.getDate());
        System.out.println(s1.getDate());



    }
}