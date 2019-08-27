package org.sd.Adapter;

public class Client1 extends Person{

    public static void main(String[] args) {
        Person p=new Client1();
        System.out.println(p.getName());

    }
}
class Person{
    private String name="person";
    int age=0;

    public String getName() {
        return name;
    }
}
