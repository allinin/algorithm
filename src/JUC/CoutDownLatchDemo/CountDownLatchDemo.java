package JUC.CoutDownLatchDemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for(int i=1;i<7;i++)
        {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 国，被灭");
                countDownLatch.countDown();
            },CountryEnum.forEach(i).getName()).start();
        }
        countDownLatch.await();
        System.out.println("秦统一");
    }
    public static void main(String[] args) throws InterruptedException {
       closeDoor();
        System.out.println(CountryEnum.ONE);
        System.out.println(CountryEnum.ONE.getCode());
        System.out.println(CountryEnum.ONE.getName());
    }
}
