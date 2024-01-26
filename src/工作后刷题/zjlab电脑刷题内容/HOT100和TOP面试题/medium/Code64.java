package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 */
public class Code64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[] dp1 = new int[m];
        int[] dp2 = new int[n];
        dp1[0] = grid[0][0];
        dp2[0] = grid[0][0];
        for(int i = 1;i < m;i++) {
            dp1[i] = dp1[i - 1] + grid[i][0];
        }
        for(int i = 1;i < n;i++) {
            dp2[i] = dp2[i - 1] + grid[0][i];
        }
        for(int i = 1;i < m;i++) {
            for(int j = 1;j < n;j++) {
                dp2[j] = grid[i][j] + Math.min(dp2[j],(j != 1 ? dp2[j - 1] : dp1[i]));
            }
        }
        return dp2[n - 1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1,2,3},{4,5,6}};
        System.out.println(new Code64().minPathSum(arr));
    }
}
