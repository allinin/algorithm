package 工作后刷题.zjlab电脑刷题内容.股票买卖系列;


/**
 *
 * 买卖股票的最佳时机含冷冻期
 *
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 * <p>
 * 输入: prices = [1]
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 */
public class Code309 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n + 1][2];//第i天不持有股票/持有股票
        //或者int[][] dp = new int[n + 1][3];表示不持有股票处于冷冻期，不持有股票并不处于冷冻期，持有股票三种状态的收益
        for (int i = 1; i <= n; i++) {
            if(i == 1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i - 1];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1],dp[i - 2][0] - prices[i - 1]);//因为有冷冻期，需要前天不持有股票
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,0,2};
        System.out.println(new Code309().maxProfit(arr));
    }
}
