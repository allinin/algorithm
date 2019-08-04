package org.sd.prototype;

import sun.security.x509.FreshestCRLExtension;

import java.io.*;
import java.util.Date;

public class Client3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Date date = new Date(12312321331L);
        Sheep s1 = new Sheep("少利",date);
        System.out.println(s1.getDate());

        //使用序列化与反序列化实现复制
        ByteArrayOutputStream bs=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bs);
        oos.writeObject(s1);
        byte[] bytes=bs.toByteArray();

        ByteArrayInputStream bis=new ByteArrayInputStream(bytes);
        ObjectInputStream ois=new ObjectInputStream(bis);
        Sheep s2=(Sheep)ois.readObject();//克隆的对象

        //修改原对象的属性
        date.setTime(12314444);
        System.out.println(s1.getDate());
        System.out.println(s2);
        System.out.println(s2.getDate());


    }
}
