package ZUOSHEN.高频面试题.六大量运用优先级队列;

import java.util.PriorityQueue;

/**
 * @author zbl
 * @version 1.0
 * @content: 地主打算切开一根金条，按照长工的工作量每人分一部分。只有金匠才能切开金条，每切一次，金匠要收金条长度个金币，比如长度为15的金条切开一次要收15个铜币
 * 地主希望找到一种切开的方法，使得完成切分后能给金匠最少的金币
 * @date 2020/1/9 22:21
 */
public class Problem5 {

    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 3,6, 7, 8, 9 };
        System.out.println(lessMoney(arr));
    }
}
