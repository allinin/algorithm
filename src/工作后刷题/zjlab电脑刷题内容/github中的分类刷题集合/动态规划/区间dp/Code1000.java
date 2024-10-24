package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.区间dp;

import java.util.Arrays;

/**
 * 合并石头的最低成本 hard
 * 有 n 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
 * <p>
 * 每次 移动 需要将 连续的 k 堆石头合并为一堆，而这次移动的成本为这 k 堆中石头的总数。
 * <p>
 * 返回把所有石头合并成一堆的最低成本。如果无法合并成一堆，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [3,2,4,1], K = 2
 * 输出：20
 * 解释：
 * 从 [3, 2, 4, 1] 开始。
 * 合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
 * 合并 [4, 1]，成本为 5，剩下 [5, 5]。
 * 合并 [5, 5]，成本为 10，剩下 [10]。
 * 总成本 20，这是可能的最小值。
 * 示例 2：
 * <p>
 * 输入：stones = [3,2,4,1], K = 3
 * 输出：-1
 * 解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.
 * 示例 3：
 * <p>
 * 输入：stones = [3,5,1,2,6], K = 3
 * 输出：25
 * 解释：
 * 从 [3, 5, 1, 2, 6] 开始。
 * 合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
 * 合并 [3, 8, 6]，成本为 17，剩下 [17]。
 * 总成本 25，这是可能的最小值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == stones.length
 * 1 <= n <= 30
 * 1 <= stones[i] <= 100
 * 2 <= k <= 30
 *
 * @author: ZBL
 * @date: 2024-10-24  14:40
 */
public class Code1000 {

//    public int mergeStones(int[] stones, int k) {
//        if (stones == null || stones.length < k) {
//            return -1;
//        }
//        int n = stones.length;
//        int[] preSum = new int[n + 1]; //前缀和，用于辅助计算
//        for (int i = 1; i <= n; i++) {
//            preSum[i] = preSum[i - 1] + stones[i - 1];
//        }
//        int[][][] dp = new int[n][n][k + 1];//stone的i - j的石头分成m推的最小成本
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                Arrays.fill(dp[i][j], -1);//表示还没计算过
//            }
//        }
//        return dfs(0, n - 1, 1, preSum, dp,k);
//    }
//
//    private int dfs(int start, int end, int targetNum, int[] preSum, int[][][] dp,int k) {
//        if (dp[start][end][targetNum] != -1) {
//            return dp[start][end][targetNum];
//        }
//        if (targetNum == 1) { // 合成一堆
//            return dp[start][end][1] = start == end ? 0 :
//        }
//    }

}
