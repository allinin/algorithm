package org.sd.exercise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{

    private int nums=30;

    Lock lock=new ReentrantLock();
    public void sale()
    {
        lock.lock();
        try{
            if(nums>0){
                System.out.println(Thread.currentThread().getName()+"\t卖出第"+(nums--)+"\t 还剩下："+nums);
            }
        }finally {
            lock.unlock();
        }
    }
}

public class SaleTicketDemo {
    public static void main(String[] args) {

        Ticket ticket=new Ticket();

        new Thread(()->{for(int i=0;i<40;i++) ticket.sale();},"A").start();
        new Thread(()->{for(int i=0;i<40;i++) ticket.sale();},"B").start();
        new Thread(()->{for(int i=0;i<40;i++) ticket.sale();},"C").start();





    }
}
