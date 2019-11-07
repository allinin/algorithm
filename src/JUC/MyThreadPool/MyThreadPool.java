package JUC.MyThreadPool;

import java.util.concurrent.*;

public class MyThreadPool {

    public static void main(String[] args) {

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1L,
                TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(), //new ThreadPoolExecutor.AbortPolicy()
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        //模拟10个用户来办理业务
        try{
            for(int i=0;i<10;i++)
            {
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }
            System.out.println(Runtime.getRuntime().availableProcessors());
        }finally {
            threadPoolExecutor.shutdown();
        }
    }
}
