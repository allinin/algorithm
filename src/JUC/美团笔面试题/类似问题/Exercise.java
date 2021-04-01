package JUC.美团笔面试题.类似问题;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zbl
 * @version 1.0
 * @content: 各个线程按序打印输出1,2,3
 * @date 2020/4/16 17:40
 */
public class Exercise {

    public static void main(String[] args) {
        Resource resource=new Resource();
        new Thread(()->{
            while(true){
                resource.print1();
            }
        },"AA").start();
        new Thread(()->{
            while(true){
                resource.print2();
            }
        },"BB").start();
        new Thread(()->{
            while(true){
                resource.print3();
            }
        },"CC").start();
    }
}

class Resource{

    private int num=1; //标志位，控制打印顺序
    private Lock lock=new ReentrantLock();
    Condition c1=lock.newCondition();
    Condition c2=lock.newCondition();
    Condition c3=lock.newCondition();

    public void print1(){
        lock.lock();
        try{
            while(num!=1){
                c1.await();
            }

            System.out.println(Thread.currentThread().getName()+"输出"+num);
            Thread.sleep(500);
            num=2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void print2(){
        lock.lock();
        try{
            while(num!=2){
                c2.await();
            }

            System.out.println(Thread.currentThread().getName()+"输出"+num);
            Thread.sleep(500);
            num=3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void print3(){
        lock.lock();
        try{
            while(num!=3){
                c3.await();
            }

            System.out.println(Thread.currentThread().getName()+"输出"+num);
            Thread.sleep(500);
            num=1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
