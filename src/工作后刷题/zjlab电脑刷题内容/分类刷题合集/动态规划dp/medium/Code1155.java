package 工作后刷题.zjlab电脑刷题内容.分类刷题合集.动态规划dp.medium;

/**
 * @Author: ZBL
 * @Date: 2024-02-04  09:35
 * 掷骰子等于目标和的方法数(medium)
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 * <p>
 * 给定三个整数 n、k 和 target，请返回投掷骰子的所有可能得到的结果（共有 kn 种方式），使得骰子面朝上的数字总和等于 target。
 * <p>
 * 由于答案可能很大，你需要对 109 + 7 取模。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1, k = 6, target = 3
 * 输出：1
 * 解释：你掷了一个有 6 个面的骰子。
 * 得到总和为 3 的结果的方式只有一种。
 * 示例 2：
 * <p>
 * 输入：n = 2, k = 6, target = 7
 * 输出：6
 * 解释：你掷了两个骰子，每个骰子有 6 个面。
 * 有 6 种方式得到总和为 7 的结果: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1。
 * 示例 3：
 * <p>
 * 输入：n = 30, k = 30, target = 500
 * 输出：222616187
 * 解释：返回的结果必须对 109 + 7 取模。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n, k <= 30
 * 1 <= target <= 1000
 */
public class Code1155 {

    private static final Integer MOD = 1000000007;
    //方法一:
    public int numRollsToTarget(int n, int k, int target) {
        if (target < n) {
            return 0;
        }

        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= target; i++) {
                if (i < j) {
                    continue;
                }
                for (int m = 1; m <= Math.min(k, i); m++) {
                    dp[j][i] = (dp[j][i] + dp[j - 1][i - m]) % MOD;
                }
            }
        }

        return dp[n][target];
    }
    //方法二:
    public int numRollsToTarget2(int n, int k, int target) {
        if (target < n) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= n; j++) {
            for (int i = target; i >= 0; i--) {
                dp[i] = 0;
                for (int m = 1; m <= Math.min(k, i); m++) {
                    dp[i] = (dp[i] + dp[i - m]) % MOD;
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int n = 30, k = 30, target = 500;
        System.out.println(new Code1155().numRollsToTarget(n, k, target));
    }
}
