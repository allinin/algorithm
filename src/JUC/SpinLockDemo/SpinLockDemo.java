package JUC.SpinLockDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

//写一个自旋锁的例子
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    public void myLock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t coming in ");
        while(!atomicReference.compareAndSet(null,thread))
        {

        }
    }
    public void myUnlock(){
        Thread thread=Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\tinvoke myUnlock");
    }

    public static void main(String[] args) {
      SpinLockDemo spinLockDemo=new SpinLockDemo();
      new Thread(()->{
          spinLockDemo.myLock();
          try{TimeUnit.SECONDS.sleep(5);}catch (Exception e){e.printStackTrace();}
          spinLockDemo.myUnlock();
      },"AA").start();

      try{TimeUnit.SECONDS.sleep(1);}catch (Exception e){e.printStackTrace();}
      new Thread(()->{
          spinLockDemo.myLock();
          try{TimeUnit.SECONDS.sleep(2);}catch (Exception e){e.printStackTrace();}
          spinLockDemo.myUnlock();
      },"BB").start();

    }
}
