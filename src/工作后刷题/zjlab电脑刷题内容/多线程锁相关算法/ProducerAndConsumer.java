package 工作后刷题.zjlab电脑刷题内容.多线程锁相关算法;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ZBL
 * @Date: 2024-03-29  16:56
 *
 * 3个生产者生产包子，2个消费者消费包子，篮子的大小为10，生产者的生产速度为10s,消费者消费速度为2s.
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        for(int i = 0;i < 3;i++) {
            new Thread(solution1.new Producer()).start();
        }
        for(int i = 0;i < 2;i++) {
            new Thread(solution1.new Consumer()).start();
        }
    }
}

//阻塞队列的方式
class Solution1 {

    private AtomicInteger count = new AtomicInteger(0);
    private BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    class Producer implements Runnable{

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(10000);
                    blockingQueue.put(0);
                    count.addAndGet(1);
                    System.out.println(Thread.currentThread().getName() + "生产一个包子，当前剩余数量：" + count.get());

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class Consumer implements Runnable{

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(2000);
                    blockingQueue.take();
                    count.addAndGet(-1);
                    System.out.println(Thread.currentThread().getName()+"消费一个包子，当前剩余数量：" + count.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
