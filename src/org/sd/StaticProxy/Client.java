package org.sd.StaticProxy;

import org.sd.dyanmicProxy.RealStar;
import org.sd.dyanmicProxy.Star;

public class Client {
    public static void main(String[] args) throws Throwable {
        Star real=new RealStar();
        Star proxy1=new ProxyStar(real);
        proxy1.confer();
        proxy1.signContract();
        proxy1.bookTicket();
        proxy1.sing();
        proxy1.collectMoney();

    }

}
