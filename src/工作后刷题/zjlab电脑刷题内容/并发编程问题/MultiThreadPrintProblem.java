package 工作后刷题.zjlab电脑刷题内容.并发编程问题;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * 有三个线程，一个线程连续打印10次A,一个线程连续打印10次B,一个线程连续打印10次C.
 * 1.如何让三个线程交替执行？
 * 2.如何让三个线程依次执行？
 * 3.如何让三个线程同时进行？
 *
 * @author: ZBL
 * @date: 2024-11-29  17:26
 */
public class MultiThreadPrintProblem {

    static volatile int num = 0;


    public static void main(String[] args) {
//        processProblem1_2();
        Integer i = new Integer(100);
        Integer j = new Integer(100);
        System.out.println(i == j);

        Integer i1 = new Integer(100);
        Integer j1 = 100;
        System.out.println(i1 == j1);

        Integer i2 = 100;
        Integer j2 = 100;
        System.out.println(i2 == j2);

        Integer i3 = 128;
        Integer j3 = 128;
        System.out.println(i3 == j3);
    }

    //处理交替执行方法一
    public static void processProblem1() {
        new Thread(() -> {
            while (true) {
                if (num % 3 == 0) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println('A');
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ++num;
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                if (num % 3 == 1) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println('B');
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ++num;
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                if (num % 3 == 2) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println('C');
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ++num;
                }
            }
        }).start();
    }

    //交替执行方法二
    public static void processProblem1_2() {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);
        Semaphore semaphore3 = new Semaphore(1);

        try {
            semaphore2.acquire();
            semaphore3.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            while (true) {
                try {
                    semaphore1.acquire();
                    for (int i = 0; i < 10; i++) {
                        System.out.println('A');
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore2.release();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    semaphore2.acquire();
                    for (int i = 0; i < 10; i++) {
                        System.out.println('B');
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore3.release();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    semaphore3.acquire();
                    for (int i = 0; i < 10; i++) {
                        System.out.println('C');
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore1.release();
                }
            }
        }).start();

    }

    //处理依次执行,依次执行只是交替执行依次交替之后变终止操作罢了
    public static void processProblem2() {
        new Thread(() -> {
            while (true) {
                if (num % 3 == 0) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println('A');
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ++num;
                    return;
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                if (num % 3 == 1) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println('B');
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ++num;
                    return;
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                if (num % 3 == 2) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println('C');
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ++num;
                    return;
                }
            }
        }).start();


    }

    //处理同时执行
    public static void processProblem3() {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 3; i++) {
            int add = i;
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    System.out.println(System.currentTimeMillis());
                    for (int j = 0; j < 10; j++) {
                        System.out.println((char) ('A' + add));
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        try {
            Thread.sleep(500);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


}
