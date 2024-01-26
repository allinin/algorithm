package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZBL
 * @Date: 2024-01-11  09:17
 * 数据流的秩
 * 假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。
 * 请实现数据结构和算法来支持这些操作，也就是说：
 * <p>
 * 实现 track(int x) 方法，每读入一个数字都会调用该方法；
 * <p>
 * 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例:
 * <p>
 * 输入:
 * ["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
 * [[], [1], [0], [0]]
 * 输出:
 * [null,0,null,1]
 * 提示：
 * <p>
 * x <= 50000
 * track 和 getRankOfNumber 方法的调用次数均不超过 2000 次
 */
public class Face1010 {

    class StreamRank {

        Map<Integer, Integer> map;

        public StreamRank() {
            this.map = new HashMap<>();
        }

        public void track(int x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        public int getRankOfNumber(int x) {
            int ans = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() <= x) {
                    ans += entry.getValue();
                }
            }
            return ans;
        }
    }

    //树状数组的方式，改题目应该默认了x取值为0<= x <= 50000
    class StreamRank2 {

        int[] count; //有效索引从1开始，代表第i个数


        public StreamRank2() {
            this.count = new int[50002];
        }

        private int lowBit(int x) {
            return x & (-x);
        }

        private void add(int x,int delta) {
            while(x <= 50001 ) {
                count[x] += delta;
                x += lowBit(x);
            }
        }

        private int getSum(int x) {
            int sum = 0;
            while(x >= 1) {
                sum += count[x];
                x -= lowBit(x);
            }
            return sum;
        }




        public void track(int x) {
            add(x + 1,1);
        }

        public int getRankOfNumber(int x) {
            return getSum(x +1);
        }
    }
}
