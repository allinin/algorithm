package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.区间dp;

/**
 * 多边形三角剖分的最低得分 medium
 * 你有一个凸的 n 边形，其每个顶点都有一个整数值。给定一个整数数组 values ，其中 values[i] 是第 i 个顶点的值（即 顺时针顺序 ）。
 * <p>
 * 假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和。
 * <p>
 * 返回 多边形进行三角剖分后可以得到的最低分 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：values = [1,2,3]
 * 输出：6
 * 解释：多边形已经三角化，唯一三角形的分数为 6。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：values = [3,7,4,5]
 * 输出：144
 * 解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：values = [1,3,1,4,1,5]
 * 输出：13
 * 解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == values.length
 * 3 <= n <= 50
 * 1 <= values[i] <= 100
 *
 * @author: ZBL
 * @date: 2024-10-24  14:18
 */
public class Code1039_done {

    public int minScoreTriangulation(int[] values) {
        if (values == null || values.length < 3) {
            return 0;
        }
        int n = values.length;
        int[][] dp = new int[n][n];//第一个顶点到到第j个顶点组成的多变型的最低分数
        //区间长度
        for (int l = 2; l < n; l++) {
            for (int i = 0; i < n; i++) { //起点
                int j = i + l; //终点
                if (j >= n) {
                    break;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], values[i] * values[k] * values[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
