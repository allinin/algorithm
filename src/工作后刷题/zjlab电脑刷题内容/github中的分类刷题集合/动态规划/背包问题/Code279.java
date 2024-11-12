package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.背包问题;

import java.util.Arrays;

/**
 * 完全平方数 medium
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 * 1/5
 *
 * @author: ZBL
 * @date: 2024-11-11  19:03
 */
public class Code279 {

    //完全背包
    public int numSquares(int n) {
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            return 1;
        }
        int[] dp = new int[n + 1];

        Arrays.fill(dp, n);
        dp[1] = 1;
        dp[0] = 0;
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Code279().numSquares(6));
    }
}
