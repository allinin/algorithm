package JUC.SynchronousQueueDemo;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {

    public static void main(String[] args) {
//        SynchronousQueue<Integer> synchronousQueue=new SynchronousQueue<>();
//        new Thread(()->{
//
//                try {
//                    for(int i=1;i<6;i++) {
//                        synchronousQueue.put(i);
//
//                        System.out.println(Thread.currentThread().getName()+"\t"+"进队列"+i);
//                         TimeUnit.SECONDS.sleep(4);
//                    }
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//        },"AAA").start();
//
//
//        new Thread(()->{
//
//            try {
//                for(int i=0;i<6;i++) {
//                    Integer take = synchronousQueue.take();
//                    System.out.println(Thread.currentThread().getName()+"\t取到了"+take);
//                    TimeUnit.SECONDS.sleep(5);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        },"BBB").start();

//        Scanner in=new Scanner(System.in);
//
//        while(in.hasNextInt())
//        {
//            int  l=in.nextInt();
//            int  r=in.nextInt();
//            StringBuilder sb=new StringBuilder();
//            for(int i=1;i<l;i++)
//                sb.append(i);
//            int count=0;
//            for(int i=l;i<=r;i++)
//            {
//                sb.append(i);
//                StringBuilder temp=sb;
//                if(Integer.parseInt(temp.toString())%3==0)
//                    count++;
//            }
//            System.out.println(count);
//        }
        System.out.println(divided(2,5));
    }

    public static int divided(int l,int r)
    {
        if(l<1 || r>1e9)
            return 0;
        StringBuilder sb=new StringBuilder();
        StringBuilder sbr = new StringBuilder("");
        int count=0;
        for(int i=1;i<l;i++)
            sb.append(i);
        for(int i=l;i<=r;i++)
        {
            sb.append(i);
            StringBuilder temp=sb;
            if(Integer.parseInt(temp.toString())%3==0)
                count++;
        }
        return count;
    }
}
