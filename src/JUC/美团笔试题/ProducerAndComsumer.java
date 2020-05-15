package JUC.美团笔试题;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zbl
 * @version 1.0
 * @content:3个生产者生产包子，2个消费者消费包子，篮子的大小为10，生产者的生产速度为10s,消费者消费速度为2s.

 * @date 2020/4/16 12:31
 */
public class ProducerAndComsumer {

    public static void main(String[] args) {
        MyResource myResource=new MyResource();
        new Thread(()->{
            while(true)
            myResource.produce();
        },"生产者1").start();
        new Thread(()->{
            while(true)
            myResource.produce();
        },"生产者2").start();
        new Thread(()->{
            while (true)
            myResource.produce();
        },"生产者3").start();
        new Thread(()->{
            while (true)
            myResource.consume();
        },"消费者1").start();
        new Thread(()->{
            while(true)
            myResource.consume();
        },"消费者2").start();

    }
}

class MyResource{
    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    private int num=0;

    //生产
    public void produce(){
        lock.lock();
        try{
            while(num==10){
                condition.await();
            }
            //干活
            num++;
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+"生产了第"+num+"个馒头");
            condition.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    //消费
    public void consume(){
        lock.lock();
        try{

            while(num==0){
                condition.await();
            }

            num--;
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"消费了第"+(num+1)+"个馒头");
            condition.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }



}
