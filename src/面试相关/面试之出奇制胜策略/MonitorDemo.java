package 面试相关.面试之出奇制胜策略;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zbl
 * @version 1.0
 * @content: 使用google .guava类库实现消费者，生产者问题
 * @date 2020/2/15 9:27
 */
public class MonitorDemo {
    private LinkedList<Integer> buffer = new LinkedList<>();
    //最大容量
    private static final int MAX = 10;
    //记录生产的编号
    private static AtomicInteger count = new AtomicInteger(0);

    private Monitor monitor = new Monitor();

    //生产者
    public void produce(int value) {
        try {
            monitor.enterWhen(monitor.newGuard(() -> {
                return buffer.size() < MAX;
            }));
            buffer.addLast(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            monitor.leave();
            ;
            System.out.println("生产完毕，缓冲区大小" + buffer.size());
        }
    }

    //消费者
    public int consume() {
        try {
            monitor.enterWhen(monitor.newGuard(() -> {
                return buffer.size() > 0;
            }));
            return buffer.removeFirst();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        } finally {
            monitor.leave();
            System.out.println("消费完毕，缓冲区大小：" + buffer.size());
        }
    }

    public static void main(String[] args) {
        MonitorDemo monitorDemo = new MonitorDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        //将线程池包装
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);
        //向线程池中放入三个消费者
        for(int i=0;i<3;i++){
            listeningExecutorService.submit(()->{
                while(true){
                    int res = count.getAndAdd(1);
                    monitorDemo.produce(res);
                    System.out.println("生产："+res);
                }
            });
        }
        for(int i=0;i<3;i++){
            listeningExecutorService.submit(()->{
                while(true){

                    int consume = monitorDemo.consume();
                    System.out.println("消费："+consume);
                }
            });
        }
    }
}
