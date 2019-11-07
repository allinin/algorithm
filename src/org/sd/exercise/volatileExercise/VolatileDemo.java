package org.sd.exercise.volatileExercise;


import java.util.concurrent.TimeUnit;

class MyData{
    volatile  int number;
    public void add()
    {
        this.number=33;
    }
}
public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData=new MyData();
        new Thread(()->{
            try{
                TimeUnit.SECONDS.sleep(3);}catch (Exception e){
                e.printStackTrace();
            }
            myData.add();
            System.out.println(Thread.currentThread().getName()+" "+myData.number);
        },"aaa").start();

        while(myData.number==0){}

        System.out.println(Thread.currentThread().getName()+" "+myData.number);
    }
}
