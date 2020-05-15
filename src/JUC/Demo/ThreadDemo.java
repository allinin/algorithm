package JUC.Demo;

/**
 * @author zbl
 * @version 1.0
 * @content: test isInterrupted(）与interrupted()方法
 * @date 2020/4/15 22:42
 */
public class ThreadDemo {

    public static class MyThread extends Thread{
        @Override
        public void run() {
//            try {
//                Thread.sleep(4000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            for(;;);
        }
    }
    public static void main(String[] args) {

        MyThread myThread=new MyThread();
        myThread.start();
        try{
            Thread.sleep(1000);
            myThread.interrupt();
            System.out.println(myThread.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
