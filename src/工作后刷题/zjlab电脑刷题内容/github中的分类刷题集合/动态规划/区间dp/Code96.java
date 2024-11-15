package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.区间dp;

/**
 * 不同的二叉搜索树 medium
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 19
 *
 * @author: ZBL
 * @date: 2024-11-15  20:23
 */
public class Code96 {

    public int numTrees(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }
        //区间长度
        for (int len = 2; len <= n; len++) {
            //起始位置
            for (int start = 1; start <= n; start++) {
                //终点位置
                int end = start + len - 1;
                if (end > n) {
                    break;
                }
                //以mid为根节点
                for (int mid = start; mid <= end; mid++) {
                    //左子树的数量 * 右子树的数量
                    dp[start][end] += (mid - 1 >= start ? dp[start][mid - 1] : 1) * (mid + 1 <= end ? dp[mid + 1][end] : 1);
                }
            }
        }
        return dp[1][n];
    }

    //优化
    public int numTrees2(int n) {
        int[] dp = new int[n + 1]; //i个数组成的二叉搜索树的数量
        dp[1] = 1;
        dp[0] = 1;
        for(int len = 2;len <= n;len++) {
            //根节点
            for(int i = 1;i <= len;i++) {
                dp[len] += dp[i - 1] * dp[len - i];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Code96().numTrees2(10));
    }
}
