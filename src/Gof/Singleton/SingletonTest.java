package Gof.Singleton;

public class SingletonTest {
    public static void main(String[] args) {
        SingleTon2 instance1= SingleTon2.getInstance();
        SingleTon2 instance2=SingleTon2.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

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
