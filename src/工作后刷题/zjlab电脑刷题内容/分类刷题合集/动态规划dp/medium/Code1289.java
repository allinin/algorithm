package 工作后刷题.zjlab电脑刷题内容.分类刷题合集.动态规划dp.medium;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2024-02-04  09:24
 * <p>
 * 下降路径最小和II(hard)
 * 给你一个 n x n 整数矩阵 grid ，请你返回非零偏移下降路径 数字和的最小值。
 * <p>
 * 非零偏移下降路径定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，
 * 相邻数字不在原数组的同一列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 * 示例 2：
 * <p>
 * 输入：grid = [[7]]
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * -99 <= grid[i][j] <= 99
 */
public class Code1289 {

    //o(n^3)
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int ans = Integer.MAX_VALUE;
        int[] dp = new int[n];
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = grid[0][i];
            pre[i] = grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            Arrays.fill(dp, Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        //这里其实就是找出pre中除了j位置以外的最小值
                        dp[j] = Math.min(dp[j], pre[k] + grid[i][j]);
                    }
                }
            }
            for (int m = 0; m < n; m++) {
                pre[m] = dp[m];
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i]);
        }

        return ans;
    }
    //方法二:优化最小值的求取.o(N^2)
    public int minFallingPathSum2(int[][] grid) {
        int n = grid.length;
        int ans = Integer.MAX_VALUE;
        int[] dp = new int[n];
        int[] pre = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = grid[0][i];
            pre[i] = grid[0][i];
        }
        int[][] minHelp = getMin(pre);
        for (int i = 1; i < n; i++) {
            Arrays.fill(dp, Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                dp[j] = Math.min(dp[j], Math.min(minHelp[j][0],minHelp[j][1]) + grid[i][j]);
            }
            for (int m = 0; m < n; m++) {
                pre[m] = dp[m];
            }
            minHelp = getMin(pre);
        }

        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i]);
        }

        return ans;
    }

    //求取arr中i位置左边及右边的最小值

    private int[][] getMin(int[] arr) {
        int n = arr.length;
        int[][] ans = new int[n][2];
        ans[0][0] = Integer.MAX_VALUE;
        ans[n - 1][1] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            ans[i][0] = Math.min(ans[i - 1][0],arr[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            ans[i][1] = Math.min(ans[i + 1][1],arr[i + 1]);
        }

        return  ans;

    }
}
