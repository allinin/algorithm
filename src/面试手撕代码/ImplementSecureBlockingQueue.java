package 面试手撕代码;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 实现一个线程安全的阻塞队列
 * @date 2020/7/6 20:11
 */
public class ImplementSecureBlockingQueue {

    class MyBlockingQueue{
        //通过List来实现
        private LinkedList<Integer> list=new LinkedList<>();
        private int max;//最大容量
        private int min=0;
        private AtomicInteger count=new AtomicInteger();
        private ReentrantLock lock=new ReentrantLock();//锁
        private Condition notEmpty=lock.newCondition();//非空
        private Condition notFull=lock.newCondition();//非满

        public MyBlockingQueue(int max){
            this.max=max;
        }

        //放入
        public void put(Integer num){
            lock.lock();
            try{
              while(count.get()==max){
                  notFull.await();
              }
              list.add(num);
              count.incrementAndGet();
              notEmpty.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        //取出
        public int poll(){
            lock.lock();
            int res=0;
            try{
                while (count.get()==min){
                    notEmpty.await();
                }
                res=list.pollFirst();
                count.decrementAndGet();
                notFull.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            return  res;
        }
    }

    public static void main(String[] args) {
        ImplementSecureBlockingQueue implementSecureBlockingQueue=
                new ImplementSecureBlockingQueue();
        MyBlockingQueue myBlockingQueue=implementSecureBlockingQueue.new MyBlockingQueue(3);
        myBlockingQueue.put(1);
        myBlockingQueue.put(2);
        myBlockingQueue.put(3);
        int res=myBlockingQueue.poll();
        System.out.println(res);
        myBlockingQueue.put(4);

    }



}
