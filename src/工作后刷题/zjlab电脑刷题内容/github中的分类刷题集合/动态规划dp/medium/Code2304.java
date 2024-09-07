package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划dp.medium;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2024-02-04  09:39
 * 网格中的最小路径代价(medium)
 * 给你一个下标从0开始的整数矩阵grid ，矩阵大小为 m x n ，由从0到 m * n - 1 的不同整数组成。
 * 你可以在此矩阵中，从一个单元格移动到下一行的任何其他单元格。如果你位于单元格(x, y)，且满足 x < m - 1 ，
 * 你可以移动到 (x + 1, 0), (x + 1, 1), ..., (x + 1, n - 1) 中的任何一个单元格。
 * 注意： 在最后一行中的单元格不能触发移动。
 * <p>
 * 每次可能的移动都需要付出对应的代价，代价用一个下标从0开始的二维数组moveCost表示，该数组大小为(m * n)xn ，
 * 其中moveCost[i][j]是从值为i的单元格移动到下一行第j列单元格的代价。从grid最后一行的单元格移动的代价可以忽略。
 * <p>
 * grid一条路径的代价是：所有路径经过的单元格的值之和加上所有移动的代价之和 。
 * 从第一行任意单元格出发，返回到达最后一行任意单元格的最小路径代价。
 * <p>
 * <p>
 * 示例 1：
 * 输入：grid = [[5,3],[4,0],[2,1]], moveCost = [[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]
 * 输出：17
 * 解释：最小代价的路径是 5 -> 0 -> 1 。
 * - 路径途经单元格值之和 5 + 0 + 1 = 6 。
 * - 从 5 移动到 0 的代价为 3 。
 * - 从 0 移动到 1 的代价为 8 。
 * 路径总代价为 6 + 3 + 8 = 17 。
 * 示例 2：
 * <p>
 * 输入：grid = [[5,1,2],[4,0,3]], moveCost = [[12,10,15],[20,23,8],[21,7,1],[8,1,13],[9,10,25],[5,3,2]]
 * 输出：6
 * 解释：
 * 最小代价的路径是 2 -> 3 。
 * - 路径途经单元格值之和 2 + 3 = 5 。
 * - 从 2 移动到 3 的代价为 1 。
 * 路径总代价为 5 + 1 = 6 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 50
 * grid 由从 0 到 m * n - 1 的不同整数组成
 * moveCost.length == m * n
 * moveCost[i].length == n
 * 1 <= moveCost[i][j] <= 100
 */
public class Code2304 {

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }
        for(int i = 1;i < m;i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                for (int k = 0; k < n; k++) {
                    int cost = moveCost[val][k];
                    dp[i + 1][k] = Math.min(dp[i + 1][k],dp[i][j] + cost + grid[i + 1][k]);
                }
            }
        }
        for(int i = 0;i < n;i++) {
            ans = Math.min(ans,dp[m - 1][i]);
        }

        return ans;
    }
}
