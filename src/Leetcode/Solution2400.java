package Leetcode;

/**
 * @Author:zbl
 * @Date:2023/12/30 11:18
 * <p>
 * 恰好移动k步到达某一位置的方法数
 * <p>
 * 给你两个 正 整数 startPos 和 endPos 。最初，你站在 无限 数轴上位置 startPos 处。在一步移动中，你可以向左或者向右移动一个位置。
 * <p>
 * 给你一个正整数 k ，返回从 startPos 出发、恰好 移动 k 步并到达 endPos 的 不同 方法数目。由于答案可能会很大，返回对 109 + 7 取余 的结果。
 * <p>
 * 如果所执行移动的顺序不完全相同，则认为两种方法不同。
 * <p>
 * 注意：数轴包含负整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：startPos = 1, endPos = 2, k = 3
 * 输出：3
 * 解释：存在 3 种从 1 到 2 且恰好移动 3 步的方法：
 * - 1 -> 2 -> 3 -> 2.
 * - 1 -> 2 -> 1 -> 2.
 * - 1 -> 0 -> 1 -> 2.
 * 可以证明不存在其他方法，所以返回 3 。
 * 示例 2：
 * <p>
 * 输入：startPos = 2, endPos = 5, k = 10
 * 输出：0
 * 解释：不存在从 2 到 5 且恰好移动 10 步的方法。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= startPos, endPos, k <= 1000
 */
public class Solution2400 {

    private static final int MOD = 1000000007;

    public static int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[3050][k + 1];
        dp[startPos + 1000 + 1][1] = 1;
        dp[startPos + 1000 -1][1] = 1;
        for (int i = 2; i <= k; i++) {
            for (int j = 1000 + startPos - i; j <= 1000 + startPos + i; j++) {
                dp[j][i] = (dp[j - 1][i - 1] + dp[j + 1][i - 1]) % MOD;
            }
        }
        return dp[endPos + 1000][k];
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(1,2,3));
    }
}
