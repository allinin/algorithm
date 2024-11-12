package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.状态机dp;

/**
 * 买卖股票的最佳时机IV hard
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 * <p>
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 *
 * @author: ZBL
 * @date: 2024-11-12  18:39
 */
public class Code188 {
    public int maxProfit(int k, int[] prices) {
        int m = prices.length;
        int[][][] dp = new int[m + 1][k + 1][2];//到了第i天最多经过j次交易不持有/持有股票的最大收益
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 1) {
                    dp[i][j][1] = -prices[0]; //第一天无论进行多少次交易，只要持有股票就只能是-prices[0]
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
                }
            }
        }
        return dp[m][k][0];
    }

    public static void main(String[] args) {
        System.out.println(new Code188().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
