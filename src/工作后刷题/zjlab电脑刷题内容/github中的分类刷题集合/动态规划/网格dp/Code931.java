package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.网格dp;

import java.util.Arrays;

/**
 * 下降路径最小和 medium
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：如图所示，为和最小的下降路径
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 *
 * @author: ZBL
 * @date: 2024-11-20  19:09
 */
public class Code931 {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        int min = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] += Math.min(matrix[i + 1][j], Math.min(j - 1 >= 0 ? matrix[i + 1][j - 1] : Integer.MAX_VALUE, j + 1 < n ? matrix[i + 1][j + 1] : Integer.MAX_VALUE));
                if (i == 0) {
                    min = Math.min(min, matrix[0][j]);
                }
            }
        }
        return min;
    }
}
