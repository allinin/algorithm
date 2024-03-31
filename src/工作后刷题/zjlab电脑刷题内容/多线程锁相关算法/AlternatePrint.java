package 工作后刷题.zjlab电脑刷题内容.多线程锁相关算法;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ZBL
 * @Date: 2024-03-29  17:15
 * <p>
 * 3个线程按序打印输出A,B,C
 * TODO 参考链接：https://zhuanlan.zhihu.com/p/370130458
 */
public class AlternatePrint {


    public static void main(String[] args) {
        SyncMethod syncMethod = new SyncMethod();

        LockMethod lockMethod = new LockMethod();

//        new Thread(() -> syncMethod.print(0, "A")).start();
//        new Thread(() -> syncMethod.print(1, "B")).start();
//        new Thread(() -> syncMethod.print(2, "C")).start();
//        new Thread(() -> lockMethod.print(0,"A", lockMethod.condition1 ,lockMethod.condition2)).start();
//        new Thread(() -> lockMethod.print(1,"B", lockMethod.condition2,lockMethod.condition3)).start();
//        new Thread(() -> lockMethod.print(2,"C", lockMethod.condition3,lockMethod.condition1)).start();


//        while(true) {
//            Thread t1 = new Thread(new JoinMethod(null,"A"));
//            Thread t2 = new Thread(new JoinMethod(t1,"B"));
//            Thread t3 = new Thread(new JoinMethod(t2,"C"));
//            t1.start();
//            t2.start();
//            t3.start();
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        SemaphoreMethod semaphoreMethod = new SemaphoreMethod();
        new Thread(() -> semaphoreMethod.print(semaphoreMethod.semaphore1, semaphoreMethod.semaphore2)).start();
        new Thread(() -> semaphoreMethod.print(semaphoreMethod.semaphore2, semaphoreMethod.semaphore3)).start();
        new Thread(() -> semaphoreMethod.print(semaphoreMethod.semaphore3, semaphoreMethod.semaphore1)).start();


    }
}

//synchronized的方式实现
class SyncMethod {

    private volatile int num = 0;
    private Object lockObject = new Object();

    public void print(int targetNum, String printValue) {
        while (true) {

            synchronized (lockObject) {
                try {
                    while (num % 3 != targetNum) {
                        lockObject.wait();
                    }

                    Thread.sleep(1000);
                    System.out.println(printValue);
                    num++;
                    lockObject.notifyAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

//通过lock+join的方式精准控制
class LockMethod {
    private Lock lock = new ReentrantLock();
    private volatile int num = 0;

    //通过condition精准控制
    public Condition condition1 = lock.newCondition();

    public Condition condition2 = lock.newCondition();

    public Condition condition3 = lock.newCondition();

    public void print(int targetNum, String val, Condition curThread, Condition nextThread) {
        while (true) {
            lock.lock();
            try {
                while (num % 3 != targetNum) {

                    curThread.await();
                }
                Thread.sleep(1000);
                System.out.println(val);
                num++;
                nextThread.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

}

//这种方式其实已经是不止3个线程了，而是3个线程为1组，不停的启动实现的交替打印
class JoinMethod implements Runnable {

    private Thread beforThread;

    private String val;

    public JoinMethod(Thread beforeThread, String val) {
        this.beforThread = beforeThread;
        this.val = val;
    }

    @Override
    public void run() {
        if (beforThread != null) {
            try {
                beforThread.join();
                Thread.sleep(1000);
                System.out.println(val);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(val);
        }
    }
}

//利用semaphore 实现3个线程交替打印1-20的数字
class SemaphoreMethod {
    public Semaphore semaphore1 = new Semaphore(1);
    public Semaphore semaphore2 = new Semaphore(0);
    public Semaphore semaphore3 = new Semaphore(0);

    private volatile int num = 1;

    public void print(Semaphore curSemaphore, Semaphore nextSemaphore) {
        while (true) {
            try {
                curSemaphore.acquire();
                if (num > 20) {
                    nextSemaphore.release();
                    break;
                }
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " print " + num++);
                nextSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}






