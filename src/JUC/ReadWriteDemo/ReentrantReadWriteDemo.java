package JUC.ReadWriteDemo;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//模仿内存的一个类
class MyCache{

    private volatile Map<String,Object> map=new HashMap<>();//在缓存中的变量一般都用volatile修饰
    private ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();
    //写
    public void put(String key,Object value)
    {
        reentrantReadWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t正在写入。。"+key);
            //模拟网路的延时
            try{ TimeUnit.MICROSECONDS.sleep(300);}catch (Exception e){e.printStackTrace();}
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t写入完成");


        }finally {
            reentrantReadWriteLock.writeLock().unlock();
        }

    }
    //读
    public void get(String key)
    {
        reentrantReadWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在读取");
            try{TimeUnit.MICROSECONDS.sleep(300);}catch (Exception e){e.printStackTrace();}
           Object result= map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t读取完成了。。"+result);

        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}
public class ReentrantReadWriteDemo {

    public static void main(String[] args) {
      MyCache myCache=new MyCache();
      for(int i=1;i<6;i++)
      {   final int temp=i;
          new Thread(()->{
              myCache.put(temp+"",temp);
          },String.valueOf(i)).start();
      }

        for(int i=1;i<6;i++)
        {   final int temp=i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}
