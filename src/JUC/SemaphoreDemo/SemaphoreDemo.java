package JUC.SemaphoreDemo;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);//模拟停车为的数量
        for(int i=0;i<6;i++)//模拟车的数量
        {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"\t 进入了一个停车位");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t出去停车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String .valueOf(i)).start();
        }
    }
}
