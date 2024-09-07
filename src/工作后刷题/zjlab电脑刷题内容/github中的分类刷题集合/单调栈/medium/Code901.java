package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.单调栈.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:zbl
 * @Date:2024/2/7 17:59
 * 股票价格跨度（medium)
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的跨度 。
 * <p>
 * 当日股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来7天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 * <p>
 * 实现 StockSpanner 类：
 * <p>
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的跨度 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * 输出：
 * [null, 1, 1, 1, 2, 1, 4, 6]
 * <p>
 * 解释：
 * StockSpanner stockSpanner = new StockSpanner();
 * stockSpanner.next(100); // 返回 1
 * stockSpanner.next(80);  // 返回 1
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(70);  // 返回 2
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(75);  // 返回 4 ，因为截至今天的最后4个股价 (包括今天的股价 75) 都小于或等于今天的股价。
 * stockSpanner.next(85);  // 返回 6
 * <p>
 * 提示：
 * <p>
 * 1 <= price <= 105
 * 最多调用 next 方法 104 次
 */
public class Code901 {

    class StockSpanner {

        List<Integer> list;

        public StockSpanner() {
            this.list = new ArrayList<>();
        }

        public int next(int price) {
            int ans = 1;
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) <= price) {
                    ans++;
                } else {
                    break;
                }
            }
            list.add(price);
            return ans;
        }
    }

    class StockSpanner2 {


        Stack<int[]> stack;
        int idx = -1;

        public StockSpanner2() {
            this.stack = new Stack<>();
            stack.push(new int[]{-1,Integer.MAX_VALUE});
        }

        public int next(int price) {
            idx++;
            while(!stack.isEmpty() && stack.peek()[1] <= price) {
                stack.pop();
            }
            int ans = idx - stack.peek()[0];
            stack.push(new int[] {idx,price});
            return ans;
        }
    }
}
