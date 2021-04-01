package JUC.美团笔面试题;


import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zbl
 * @version 1.0 Synchronized实现
 * @content:3个生产者生产包子，2个消费者消费包子，篮子的大小为10，生产者的生产速度为10s,消费者消费速度为2s.
 *
 * @date 2021/3/26 15:59
 */
public class ProducerConsumer {


    public static void main(String[] args) {

        Shop shop = new Shop();
        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer(shop);
            producer.start();
        }

        for (int i = 0; i < 2; i++) {
            Consumer consumer = new Consumer(shop);
            consumer.start();
        }
    }

}
/**
 * 商店类（Shop）:定义一个成员变量，表示第几个面包，提供生产面包和消费面包的操作；
 */
class Shop {
    private int bread = 0;
    /**
     * 生产面包
     */
    public synchronized void produceBread() {
        if (bread < 10) {
            bread++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + bread + "个面包");
            notify(); // 唤醒消费者线程
        } else {
            try {
                wait(); // 告诉生产者等待一下
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费面包
     */
    public synchronized void consumeBread() {
        if (bread > 0) {
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + bread + "个面包");
            bread--;
            notify(); // 唤醒生产者线程
        } else {
            try {
                wait(); // 告诉消费者等待一下
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 生产者类（Producer）：继承Thread类，重写run()方法，调用生产面包的操作
 */
class Producer extends Thread {
    private Shop shop;

    public Producer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产面包.....");
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shop.produceBread() ;
        }
    }
}

/**
 * 消费者类（Consumer）：继承Thread类，重写run()方法，调用消费面包的操作
 */
class Consumer extends Thread {
    private Shop shop;
    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费面包.....");
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shop.consumeBread();
        }
    }
}





