package org.sd.singleton;

import java.util.concurrent.CountDownLatch;

public class Client3 {
    public static void main(String[] args) throws InterruptedException {


    long start=System.currentTimeMillis();
    int threadNum=10;
   final CountDownLatch countDownLatch=new CountDownLatch(threadNum);
  for(int i=0;i<threadNum;i++){
        new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<1000000;i++){
					SingletonDemo4 s=SingletonDemo4.INSTANCE;


                }

                countDownLatch.countDown();
            }
        }).start();

    }
   countDownLatch.await();
   long end =System.currentTimeMillis();
        System.out.println(end-start);
}
}
