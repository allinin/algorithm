package JUC.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{
    private int number=1;//标志位，用来控制哪个线程来执行
    private Lock lock=new ReentrantLock();
    Condition c1=lock.newCondition();
    Condition c2=lock.newCondition();
    Condition c3=lock.newCondition();

    public void print5()
    {
        lock.lock();
        try{
            while(number!=1)
            {
                c1.await();

            }

            for(int i=0;i<5;i++)
            {
                System.out.println(Thread.currentThread().getName()+"\t"+i );
            }

            number=2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10()
    {
        lock.lock();
        try{
            while(number!=2)
            {
                c2.await();

            }

            for(int i=0;i<10;i++)
            {
                System.out.println(Thread.currentThread().getName()+"\t"+i );
            }

            number=3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15()
    {
        lock.lock();
        try{
            while(number!=3)
            {
                c3.await();

            }

            for(int i=0;i<15;i++)
            {
                System.out.println(Thread.currentThread().getName()+"\t"+i );
            }

            number=1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * 多个线程之间按顺序调用，实现A->B-C
 *
 */
public class ConditionDemo {

    public static void main(String[] args) {
        ShareData shareData=new ShareData();
        new Thread(()->{
            for(int i=0;i<5;i++)
                shareData.print5();
        },"AA").start();
        new Thread(()->{
            for(int i=0;i<5;i++)
                shareData.print10();
        },"BB").start();
        new Thread(()->{
            for(int i=0;i<5;i++)
                shareData.print15();
        },"CC").start();
    }
}
