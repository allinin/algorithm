package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.从记忆化搜索到递推.medium;

/**
 * 珠宝的最高价值 medium
 * 现有一个记作二维矩阵 frame 的珠宝架，其中 frame[i][j] 为该位置珠宝的价值。拿取珠宝的规则为：
 * <p>
 * 只能从架子的左上角开始拿珠宝
 * 每次可以移动到右侧或下侧的相邻位置
 * 到达珠宝架子的右下角时，停止拿取
 * 注意：珠宝的价值都是大于 0 的。除非这个架子上没有任何珠宝，比如 frame = [[0]]。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: frame = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最高价值的珠宝
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 < frame.length <= 200
 * 0 < frame[0].length <= 200
 *
 * @Author:zbl
 * @Date:2024/9/16 20:59
 */
public class LCR166 {

    public int jewelleryValue(int[][] frame) {
        if (frame == null || frame.length == 0) {
            return 0;
        }
        int m = frame.length, n = frame[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = frame[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + frame[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + frame[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + frame[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
