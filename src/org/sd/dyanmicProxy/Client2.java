package org.sd.dyanmicProxy;

import java.lang.reflect.Proxy;

public class Client2 {
    public static void main(String[] args) throws Throwable {
        Star realStar=new RealStar();
        StarHandler starHandler=new StarHandler(realStar);
        Star proxy= (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Star.class},starHandler);
        proxy.bookTicket();
    }
}
