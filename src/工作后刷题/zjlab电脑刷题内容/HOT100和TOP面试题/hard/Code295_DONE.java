package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

import java.util.PriorityQueue;

/**
 * @Author: ZBL
 * @Date: 2023-12-29  14:41
 * <p>
 * 数据流的中位数
 * <p>
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * <p>
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * <p>
 * MedianFinder() 初始化 MedianFinder 对象。
 * <p>
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * <p>
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * 输出
 * [null, null, null, 1.5, null, 2.0]
 * <p>
 * 解释
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * 提示:
 * <p>
 * -105 <= num <= 105
 * 在调用 findMedian 之前，数据结构中至少有一个元素
 * 最多 5 * 104 次调用 addNum 和 findMedian
 */
public class Code295_DONE {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    int smallSize;
    int largeSize;

    public Code295_DONE() {
        this.small = new PriorityQueue<>();
        this.large = new PriorityQueue<>((a, b) -> {
            if (a < b) {
                return 1;
            } else if (a > b) {
                return -1;
            } else {
                return 0;
            }
        });
        this.smallSize = 0;
        this.largeSize = 0;
    }

    public void addNum(int num) {
        if (!large.isEmpty() && num > large.peek()) {
            small.add(num);
            smallSize++;
            if (smallSize > largeSize + 1) {
                large.add(small.poll());
                largeSize++;
                smallSize--;
            }
        } else {
            large.add(num);
            largeSize++;
            if (largeSize > smallSize + 1) {
                small.add(large.poll());
                largeSize--;
                smallSize++;
            }
        }

    }

    public double findMedian() {
        if ((largeSize + smallSize) % 2 == 0) {
            return ((double) (large.peek() + small.peek())) / 2;
        } else {
            return largeSize > smallSize ? large.peek() : small.peek();
        }
    }
}
