package JUC.threadlocal;

import java.util.concurrent.CountDownLatch;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/3/29 10:47
 */
public class ThreadLocalDemo {
    private String string;
    ThreadLocal<String> threadLocal=new ThreadLocal<>();

    private String getString() {
        return threadLocal.get();
    }

    private void setString(String string) {
        threadLocal.set(string);
    }

    public static void main(String[] args) {
        int threads = 9;
        ThreadLocalDemo demo = new ThreadLocalDemo();
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(() -> {
                demo.setString(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("demo.getString()================>" +
                        Thread.currentThread().getName()+" "+ demo.getString());
                countDownLatch.countDown();
            }, "执行线程 - " + i);
            thread.start();
        }

    }

}
