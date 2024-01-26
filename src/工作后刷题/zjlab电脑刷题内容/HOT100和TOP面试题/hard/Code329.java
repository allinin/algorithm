package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

/**
 * @Author: ZBL
 * @Date: 2024-01-02  10:14
 * <p>
 * 矩阵中的最长递增路径
 * <p>
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * 示例 3：
 * <p>
 * 输入：matrix = [[1]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 */
public class Code329 {

    int ans = 0;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];//表示从i,j位置开始的最长路径
        //因为要保证单调递增，所以不会出现重复的情况
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, process(matrix, i, j, dp));
            }
        }
        return ans;
    }

    private int process(int[][] matrix, int row, int col, int[][] dp) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int tmp = 0;
        if (row + 1 < matrix.length && matrix[row + 1][col] > matrix[row][col]) {
            tmp = Math.max(tmp, process(matrix, row + 1, col, dp));
        }
        if (row - 1 >= 0 && matrix[row - 1][col] > matrix[row][col]) {
            tmp = Math.max(tmp, process(matrix, row - 1, col, dp));
        }
        if (col + 1 < matrix[0].length && matrix[row][col + 1] > matrix[row][col]) {
            tmp = Math.max(tmp, process(matrix, row, col + 1, dp));
        }
        if (col - 1 >= 0 && matrix[row][col - 1] > matrix[row][col]) {
            tmp = Math.max(tmp, process(matrix, row, col - 1, dp));
        }

        dp[row][col] = 1 + tmp;
        return dp[row][col];
    }

}
