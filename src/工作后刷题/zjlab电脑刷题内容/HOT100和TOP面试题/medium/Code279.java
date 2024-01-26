package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.Arrays;

/**
 * 完全平方数
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
 */
public class Code279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            double sqrt = Math.sqrt(i);
            if (sqrt == Math.floor(sqrt)) {
                dp[i] = 1;
            } else {
                for (int j = 1; j * j < i; j++) {
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                }
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Code279().numSquares(12));
    }
}
