package 工作后刷题.zjlab电脑刷题内容.股票买卖系列;

/**
 * @Author: ZBL
 * @Date: 2023-12-22  10:23
 *
 * 买卖股票的最佳时机IV，123题的进阶版
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
 *
 * 提示：
 *
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 */
public class Code188 {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        //以买入为下一笔交易的开始
        int[][][] dp = new int[n + 1][k + 1][2];//第i天完成j笔交易持有/不持有股票的收益
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 1) {
                    //第一天无论完成几笔交易，在不持有股票时收益一定是0
                    dp[1][j][0] = 0;
                    //第一天无论完成几笔交易，持有股票时收益一定是-prices[0]
                    dp[1][j][1] = -prices[0];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
                }

            }
        }
        return dp[n][k][0];
    }

    public static void main(String[] args) {
        System.out.println(new Code188().maxProfit(2,new int[]{3,2,6,5,0,3}));
    }
}
