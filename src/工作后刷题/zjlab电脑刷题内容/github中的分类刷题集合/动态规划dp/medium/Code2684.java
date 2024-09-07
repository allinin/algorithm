package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划dp.medium;

/**
 * @Author: ZBL
 * @Date: 2024-02-04  09:28
 * 矩阵中移动的最大次数(medium)
 * 给你一个下标从 0 开始、大小为 m x n 的矩阵 grid ，矩阵由若干 正 整数组成。
 * <p>
 * 你可以从矩阵第一列中的 任一 单元格出发，按以下方式遍历 grid ：
 * <p>
 * 从单元格 (row, col) 可以移动到 (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1) 三个单元格中任一满足值
 * 严格大于当前单元格的单元格。
 * 返回你在矩阵中能够移动的最大次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
 * 输出：3
 * 解释：可以从单元格 (0, 0) 开始并且按下面的路径移动：
 * - (0, 0) -> (0, 1).
 * - (0, 1) -> (1, 2).
 * - (1, 2) -> (2, 3).
 * 可以证明这是能够移动的最大次数。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[3,2,4],[2,1,9],[1,1,7]]
 * 输出：0
 * 解释：从第一列的任一单元格开始都无法移动。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 1000
 * 4 <= m * n <= 105
 * 1 <= grid[i][j] <= 106
 */
public class Code2684 {

    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];//表示从i,j位置移动的最大次数
        int ans = 0;
        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                if (i - 1 >= 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] > grid[i][j]){
                    dp[i][j] = Math.max(dp[i][j],1 + dp[i - 1][j + 1]);
                }
                if (j + 1 < grid[0].length && grid[i][j + 1] > grid[i][j]){
                    dp[i][j] = Math.max(dp[i][j],1 + dp[i][j + 1]);
                }
                if (i + 1 < grid.length && j + 1 < grid[0].length && grid[i + 1][j + 1] > grid[i][j]){
                    dp[i][j] = Math.max(dp[i][j],1 + dp[i + 1][j + 1]);
                }
            }
        }
        for(int i = 0;i < m;i++) {
            ans = Math.max(ans,dp[i][0]);
        }
        return ans;
    }

}
