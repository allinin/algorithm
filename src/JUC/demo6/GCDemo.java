package JUC.demo6;

import java.util.Random;

public class GCDemo {
    public static void main(String[] args) {
        long l = Runtime.getRuntime().maxMemory();
        System.out.println("-Xmx memory= "+(double)l/1024/1024+"MB");
        long l1 = Runtime.getRuntime().totalMemory();
        System.out.println((double)l1/1024/1024);

        String str="wwww";
        while(true)
        {
            str=str+ new Random().nextInt(999999)+new Random().nextInt(888999999);
        }
    }
}
