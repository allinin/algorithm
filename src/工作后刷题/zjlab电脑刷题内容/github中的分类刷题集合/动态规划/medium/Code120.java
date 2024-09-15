package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.medium;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-02-04  09:26
 * <p>
 * 三角形最小路劲和(medium)
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点在这里指的是下标与上一层结点下标相同或者等于下一层结点下标 + 1的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * <p>
 * 输入：triangle = [[-10]]
 * 输出：-10
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 */
public class Code120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        int[] pre = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        Arrays.fill(pre,Integer.MAX_VALUE);
        pre[0] = triangle.get(0).get(0);
        dp[0] = pre[0];
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);

            for (int j = 0; j < list.size(); j++) {
                if (j > 0) {
                    dp[j] = list.get(j) + Math.min(pre[j], pre[j - 1]);
                } else {
                    dp[j] = list.get(j) + pre[j];
                }
            }

            for (int j = 0; j < list.size(); j++) {
                pre[j] = dp[j];
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }
}
