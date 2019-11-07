package JUC.CyclicBarrierDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println(Thread.currentThread().getName()+"集齐龙珠，召唤神龙");
        });
        for(int i=1;i<=7;i++)
        {
           final int temp=i;//用于lambda表达式中
          new Thread(()->{
              System.out.println(Thread.currentThread().getName()+"\t得到第"+temp+"颗龙珠");
              try {
                  cyclicBarrier.await();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              } catch (BrokenBarrierException e) {
                  e.printStackTrace();
              }
          },String.valueOf(i)).start();
        }

    }
}
