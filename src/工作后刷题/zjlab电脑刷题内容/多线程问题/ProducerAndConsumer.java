package 工作后刷题.zjlab电脑刷题内容.多线程问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ZBL
 * @Date: 2024-03-29  16:56
 * <p>
 * 3个生产者生产包子，2个消费者消费包子，篮子的大小为10，生产者的生产速度为10s,消费者消费速度为2s.
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {
        BlockingQueueSolution solution1 = new BlockingQueueSolution(10);
        LockSolution syncSolution = new LockSolution(10, new ArrayList<>());
        for (int i = 0; i < 3; i++) {
            new Thread(syncSolution.new Producer()).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(syncSolution.new Consumer()).start();
        }
    }
}

//BlockingQueue阻塞队列的方式
class BlockingQueueSolution {

    private volatile int count;
    private BlockingQueue<Integer> blockingQueue;

    public BlockingQueueSolution(int size) {
        this.count = 0;
        this.blockingQueue = new ArrayBlockingQueue<>(size);
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10000);
                    blockingQueue.put(new Random().nextInt());
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产一个包子，当前剩余数量：" + count);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);
                    blockingQueue.take();
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费一个包子，当前剩余数量：" + count);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

//借助synchronized实现
class SyncSolution {

    private int max;

    private List<Integer> list;

    public SyncSolution(int max, List<Integer> list) {
        this.max = max;
        this.list = list;
    }


    class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    while (list.size() == max) {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    try {
                        Thread.sleep(3000);
                        int num = new Random().nextInt();
                        list.add(num);
                        System.out.println(Thread.currentThread().getName() + " produce :" + num + " 剩余： " + list.size());
                        list.notifyAll();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    while (list.isEmpty()) {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    try {
                        Thread.sleep(1000);
                        int num = list.remove(list.size() - 1);
                        System.out.println(Thread.currentThread().getName() + " consume :" + num + "剩余：" + list.size());
                        list.notifyAll();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

//借助Lock + condition实现
class LockSolution {

    private int max;

    private List<Integer> list;

    private Lock lock = new ReentrantLock();

    private Condition fullCondition = lock.newCondition();

    private Condition emptyCondition = lock.newCondition();

    public LockSolution(int max, List<Integer> list) {
        this.max = max;
        this.list = list;
    }


    class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (list.size() == max) {
                        fullCondition.await();
                    }
                    Thread.sleep(3000);
                    int next = new Random().nextInt();
                    list.add(next);
                    System.out.println(Thread.currentThread().getName() + " produce " + next + " 剩余：" + list.size());
                    emptyCondition.signalAll();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while(list.isEmpty()) {
                        emptyCondition.await();
                    }
                    Thread.sleep(1000);
                    Integer num = list.remove(list.size() - 1);
                    System.out.println(Thread.currentThread().getName() + " consume " + num + " 剩余：" + list.size());
                    fullCondition.signalAll();
                }catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
