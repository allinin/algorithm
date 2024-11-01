package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.单调队列;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 购买水果需要的最少金币数 medium
 * 你在一个水果超市里，货架上摆满了玲琅满目的奇珍异果。
 * <p>
 * 给你一个下标从 1 开始的数组 prices ，其中 prices[i] 表示你购买第 i 个水果需要花费的金币数目。
 * <p>
 * 水果超市有如下促销活动：
 * <p>
 * 如果你花费 price[i] 购买了下标为 i 的水果，那么你可以免费获得下标范围在 [i + 1, i + i] 的水果。
 * 注意 ，即使你 可以 免费获得水果 j ，你仍然可以花费 prices[j] 个金币去购买它以获得它的奖励。
 * <p>
 * 请你返回获得所有水果所需要的 最少 金币数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：prices = [3,1,2]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 用 prices[0] = 3 个金币购买第 1 个水果，你可以免费获得第 2 个水果。
 * 用 prices[1] = 1 个金币购买第 2 个水果，你可以免费获得第 3 个水果。
 * 免费获得第 3 个水果。
 * 请注意，即使您可以免费获得第 2 个水果作为购买第 1 个水果的奖励，但您购买它是为了获得其奖励，这是更优化的。
 * <p>
 * 示例 2：
 * <p>
 * 输入：prices = [1,10,1,1]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 用 prices[0] = 1 个金币购买第 1 个水果，你可以免费获得第 2 个水果。
 * 免费获得第 2 个水果。
 * 用 prices[2] = 1 个金币购买第 3 个水果，你可以免费获得第 4 个水果。
 * 免费获得第 4 个水果。
 * 示例 3：
 * <p>
 * 输入：prices = [26,18,6,12,49,7,45,45]
 * <p>
 * 输出：39
 * <p>
 * 解释：
 * <p>
 * 用 prices[0] = 26 个金币购买第 1 个水果，你可以免费获得第 2 个水果。
 * 免费获得第 2 个水果。
 * 用 prices[2] = 6 个金币购买第 3 个水果，你可以免费获得第 4，5，6（接下来的三个）水果。
 * 免费获得第 4 个水果。
 * 免费获得第 5 个水果。
 * 用 prices[5] = 7 个金币购买第 6 个水果，你可以免费获得第 7 和 第 8 个水果。
 * 免费获得第 7 个水果。
 * 免费获得第 8 个水果。
 * 请注意，即使您可以免费获得第 6 个水果作为购买第 3 个水果的奖励，但您购买它是为了获得其奖励，这是更优化的。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 1000
 * 1 <= prices[i] <= 105
 *
 * @author: ZBL
 * @date: 2024-10-25  20:14
 */
public class Code2944 {

    private int ans = Integer.MAX_VALUE;

    //超时了
    public int minimumCoins(int[] prices) {
        process(prices, 2, 3, prices[0]);
        return ans;
    }

    private void process(int[] prices, int start, int end, int sum) {
        if (end > prices.length) {
            ans = Math.min(ans, sum);
            return;
        }
        for (int i = start; i <= end; i++) {
            process(prices, i + 1, i + i + 1, sum + prices[i - 1]);
        }
    }

    //记忆化搜索
    public int minimumCoins2(int[] prices) {
        int[] dp = new int[prices.length + 1]; // 从第i个开始的到最后的最小值
        return process(prices, 1, dp);
    }

    //单调队列的方法
    private int process(int[] prices, int start, int[] dp) {
        if (start + start >= prices.length) {
            return dp[start] = prices[start - 1];
        }
        if (dp[start] != 0) {
            return dp[start];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start + 1; i <= start + start + 1; i++) {
            res = Math.min(res, process(prices, i, dp));
        }
        return dp[start] = prices[start - 1] + res;
    }

    //单调队列的方式
    public int minimumCoins3(int[] prices) {
        int n = prices.length;
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{n + 1, 0});// 哨兵，其中的值表示从第i开始购买，购买所有水果的最小值，其中的值需要按照arr[1]单调递减排列
        for (int i = n; i > 0; i--) {
            while (deque.peekLast()[0] > i * 2 + 1) { // 右边离开窗口
                deque.pollLast();
            }
            int value = prices[i - 1] + deque.peekLast()[1];
            while (value < deque.peekFirst()[1]) {
                deque.pollFirst();
            }

            deque.addFirst(new int[]{i, value}); //左边进入窗口

        }
        return deque.peekFirst()[1];
    }

    //dp的方式
    public int minimumCoins4(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] dp = new int[n + 1]; // 从第i个开始的到最后的最小值
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = prices[n - 1];
        for (int i = n - 1; i >= 1; i--) {
            if (2 * i >= n) {
                dp[i] = prices[i - 1];
            } else {
                for (int j = i + 1; j <= 2 * i + 1; j++) {
                    dp[i] = Math.min(dp[i], prices[i - 1] + dp[j]);
                }
            }
        }
        return dp[1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2};
        System.out.println(new Code2944().minimumCoins4(arr));
    }
}
