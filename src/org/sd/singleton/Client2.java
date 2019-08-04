package org.sd.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

//测试反射和反序列化破解单例模式
public class Client2 {
    public static void main(String[] args) throws Exception {
        SingletonDemo1 s5=SingletonDemo1.getInstance();
        System.out.println(s5);

        //反射方式直接调用私有构造器
        Class<?> clazz=Class.forName("org.sd.singleton.SingletonDemo1");
        Constructor<?> constructor=clazz.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        SingletonDemo1 s1=(SingletonDemo1)constructor.newInstance();
        SingletonDemo1 s2=(SingletonDemo1)constructor.newInstance();
        System.out.println(s1);
        System.out.println(s2);

        //通过反序列化的方式构造多个对象
        FileOutputStream fos=new FileOutputStream("d:/a.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(s5);
        oos.close();
        fos.close();
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("d:/a.txt"));
        SingletonDemo1 s6=(SingletonDemo1)ois.readObject();
        System.out.println(s6);



    }
}
