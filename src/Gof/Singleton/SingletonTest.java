package Gof.Singleton;

public class SingletonTest {
    public static void main(String[] args) {

        Singleton7 instance1= Singleton7.getInstance();
        Singleton7 instance2=Singleton7.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        Singleton8 s1=Singleton8.INSTACNE;
        Singleton8 s2=Singleton8.INSTACNE;
        System.out.println(s1==s2);
    }
}

//饿汉式（静态常量）
class SingleTon1{

    private SingleTon1()
    {

    }

    private final static SingleTon1 instance=new SingleTon1();

    public static SingleTon1 getInstance()
    {
        return instance;
    }
}
//饿汉式（静态代码块）
class SingleTon2{

    private SingleTon2(){}

    private static  SingleTon2 instance;

      static {
        instance=new SingleTon2();
      }
    public static SingleTon2 getInstance()
    {
        return instance;
    }
}

//懒汉式（线程不安全）
class Singleton3
{
    private static Singleton3 instance;
    private Singleton3(){}
    public static Singleton3 getInstance()
    {
        if(instance==null)
        {
            instance=new Singleton3();
        }
        return instance;
    }
}

//懒汉式（线程安全，同步方法）
class Singleton4
{
    private static Singleton4 instance;
    private Singleton4(){}
    public static synchronized Singleton4 getInstance()
    {
        if(instance==null)
            instance=new Singleton4();
        return instance;
    }

}

//懒汉式（同步代码块，不推荐）
class Singleton5
{
    private static Singleton5 instance;
    private Singleton5(){}
    public static Singleton5 getInstance()
    {
        if(instance==null)
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        return instance;
    }
}

//双重检查，同步代码块，线程安全
class Singleton6
{
    private static volatile Singleton6 instance;
    private Singleton6(){

    }
    //提供了一个静态的共有方法，加入了双重检查，解决了线程安全问题，同时解决了懒加载问题，保证了效率，推荐
    public static Singleton6 getInstance(){
        if(instance==null)
        {
            synchronized (Singleton6.class)
            {
                if(instance==null)
                    instance=new Singleton6();
            }
        }
        return instance;
    }



}


//静态内部类
class Singleton7 {
    private Singleton7() {

    }

    private static class SingletonInstance {

        private static final Singleton7 INSTANCE = new Singleton7();//final可以不加

    }

    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }

}

//枚举
enum Singleton8{
    INSTACNE;//属性
    public void sayOK()
    {
        System.out.println("ok");
    }
}
