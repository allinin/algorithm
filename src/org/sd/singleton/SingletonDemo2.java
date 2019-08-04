package org.sd.singleton;

public class SingletonDemo2 {
    private static SingletonDemo2 instance;
    private SingletonDemo2(){}
    public static synchronized SingletonDemo2 getInstance()
    {
        if(instance==null)
        {
            instance=new SingletonDemo2();
        }
        return  instance;
    }

}
