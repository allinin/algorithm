package org.sd.singleton;

import java.io.Serializable;

public class SingletonDemo1 implements Serializable {
    //类初始时，立即加载这个对象，（没有延迟加载），加载类时，天然的是线程安全的。
    private static final SingletonDemo1 s=new SingletonDemo1();
    private SingletonDemo1(){}//私有化构造器
    //方法没有同步，调用效率高
    public static SingletonDemo1 getInstance()
    {return s;}

}
