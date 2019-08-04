package org.sd.Adapter;

public class Client1 {
    public void test1(Target target)
    {
        target.handleReq();
    }

    public static void main(String[] args) {
        Client1 c=new Client1();
        Adaptee adaptee=new Adaptee();

        Target t=new Adapter(adaptee);
        c.test1(t);
    }
}
