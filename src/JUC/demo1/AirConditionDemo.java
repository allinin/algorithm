package JUC.demo1;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirCondition{
    private int number=0;
//    public synchronized void increment() throws InterruptedException {
//
//        //判断
//        while(number!=0)
//        {
//            this.wait();
//        }
//
//        //干活
//
//        number++;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//
//        //通知
//        this.notifyAll();
//    }
//
//    public synchronized void decrement() throws InterruptedException {
//        while(number==0)
//        {
//            this.wait();
//        }
//
//        number--;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//
//        this.notifyAll();
//    }

    //用lock
    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();

      public void increment()
    {
        lock.lock();
        try{

            while(number!=0)
            {
                condition.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);

            condition.signalAll();

        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void decrement()
    {
        lock.lock();
        try{

            while(number==0)
            {
                condition.await();
            }

            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);

            condition.signalAll();

        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}

public class AirConditionDemo {

    public static void main(String[] args) {

        AirCondition airCondition=new AirCondition();

        new Thread(()->{
            try {
                for(int i=0;i<10;i++)
                airCondition.increment();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"AA").start();

        new Thread(()->{
            try {
                for(int i=0;i<10;i++)
                    airCondition.increment();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"BB").start();

        new Thread(()->{
            try {
                for(int i=0;i<10;i++)
                    airCondition.decrement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"CC").start();

        new Thread(()->{
            try {
                for(int i=0;i<10;i++)
                    airCondition.decrement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"DD").start();

    }
}
