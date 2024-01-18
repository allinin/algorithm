package 工作后刷题.丑数类似题;

/**
 * @Author:zbl
 * @Date:2024/1/15 22:06
 * <p>
 * 丑数II(medium)
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * <p>
 * 丑数 就是质因子只包含 2、3 和 5 的正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1690
 */
public class Code264 {

    //dp动态规划
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        //当前乘以2，乘以3，乘以5的索引位置
        int idx2 = 1, idx3 = 1, idx5 = 1;
        for (int i = 2; i <= n; i++) {
            //下一个丑数一定是当前索引位置乘以对应值中的最小值
            int min = Math.min(dp[idx2] * 2, Math.min(dp[idx3] * 3, dp[idx5] * 5));
            //如果当前索引位置乘以对应值等于最小值，则索引+1,表示当前位置的计算结束
            if (min == dp[idx3] * 3) {
                idx3++;
            }
            if (min == dp[idx2] * 2) {
                idx2++;
            }
            if (min == dp[idx5] * 5) {
                idx5++;
            }
            dp[i] = min;
        }
        return dp[n];
    }

}
