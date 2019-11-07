package JUC.blockingqueue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{
    private volatile boolean flag=true;
    private AtomicInteger atomicInteger=new AtomicInteger();
    private BlockingQueue<String> blockingQueue=null;

    public MyResource(BlockingQueue<String> blockingQueue)
    {
        this.blockingQueue=blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd()throws Exception
    {
        String data=null;
        boolean returnValue;
        while(flag)
        {
            data=atomicInteger.incrementAndGet()+"";
            returnValue=blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(returnValue)
            {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列数据"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t插入队列数据"+data+"失败");
            }

            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t:停止表示flag"+flag);
    }

    public void myConsumer()throws Exception{
        String result=null;
        while(flag)
        {
            result=blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(result==null || "".equalsIgnoreCase(result))
            {
                flag=false;
                System.out.println(Thread.currentThread().getName()+"\t"+"超过2m没有收到消费退出");
                System.out.println();
                System.out.println();
            }
            System.out.println(Thread.currentThread().getName()+"\t消费队列"+result+"成功");
        }
    }

    public void stop()throws Exception
    {
        flag=false;
    }

}
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception {
        MyResource myResource=new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"pord").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        TimeUnit.SECONDS.sleep(8);
        System.out.println();
        System.out.println();
        System.out.println("时间到");

        myResource.stop();
    }

}
