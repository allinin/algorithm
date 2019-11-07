package JUC.ABAResolve;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {

    private static AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {

        new Thread(()->{
            boolean b1 = atomicStampedReference.compareAndSet(100, 101, 1, 2);

            boolean b2=atomicStampedReference.compareAndSet(101,100,2,3);
            System.out.println(Thread.currentThread().getName()+"\t"+b2+atomicStampedReference.getReference().toString());

        },"AA").start();

        new Thread(()->{
            try{
                TimeUnit.SECONDS.sleep(3);}catch (Exception e){e.printStackTrace();}
               boolean b3= atomicStampedReference.compareAndSet(100,101,1,2);
            System.out.println(Thread.currentThread().getName()+"\t"+b3+atomicStampedReference.getReference().toString());
        },"BB").start();
    }
}
