package JUC.demo3;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable实现多线程。。。。");
        return 121212;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread=new MyThread();
        FutureTask<Integer> futureTask=new FutureTask<>(myThread);
        new Thread(futureTask,"aa").start();
        Integer integer = futureTask.get();
        System.out.println(integer);
    }


}
