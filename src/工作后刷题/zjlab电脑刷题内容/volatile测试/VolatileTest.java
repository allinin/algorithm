package 工作后刷题.zjlab电脑刷题内容.volatile测试;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ZBL
 * @date: 2024-12-06  09:39
 */
public class VolatileTest {

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.print(Thread.currentThread().getName());
                set.add(i);
                System.out.println(": set size = " + set.size());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.print(Thread.currentThread().getName());
                System.out.println(": set size = " + set.size());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();
    }
}
