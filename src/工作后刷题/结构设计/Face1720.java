package 工作后刷题.结构设计;

import java.util.PriorityQueue;

/**
 * @Author:zbl
 * @Date:2024/1/7 20:15
 * <p>
 * 连续中值(hard)
 * 随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。
 * <p>
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class Face1720 {


    class MedianFinder {
        private PriorityQueue<Integer> smallQueue;
        private PriorityQueue<Integer> bigQueue;

        private int smallSize;
        private int bigSize;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            this.bigQueue = new PriorityQueue<>((a, b) -> b - a);
            this.smallQueue = new PriorityQueue<>();
            this.smallSize = 0;
            this.bigSize = 0;
        }

        public void addNum(int num) {
            if (bigQueue.isEmpty() || num < bigQueue.peek()) {
                bigQueue.add(num);
                if (++bigSize > smallSize + 1) {
                    smallQueue.add(bigQueue.poll());
                    smallSize++;
                    bigSize--;
                }
            } else {
                smallQueue.add(num);
                if (++smallSize > bigSize + 1) {
                    bigQueue.add(smallQueue.poll());
                    smallSize--;
                    bigSize++;
                }
            }

        }

        public double findMedian() {
            if ((bigSize + smallSize) % 2 == 1) {
                return bigSize > smallSize ? (double) bigQueue.peek() : (double) smallQueue.peek();
            }
            return ((double) (bigQueue.peek() + smallQueue.peek())) / 2;
        }
    }
}
