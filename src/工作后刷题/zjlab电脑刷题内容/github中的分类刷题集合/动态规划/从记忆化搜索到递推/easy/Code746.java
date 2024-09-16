package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.从记忆化搜索到递推.easy;

import java.util.Arrays;

/**
 * 使用最小花费爬楼梯 EASy
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 *
 *
 * 示例 1：
 *
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * 示例 2：
 *
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 *
 *
 * 提示：
 *
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 * @Author:zbl
 * @Date:2024/9/16 20:46
 */
public class Code746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n - 1] = cost[n - 1];
        dp[n - 2] = cost[n - 2];
        for(int i = n - 3;i >= 0;i--) {
            dp[i] = Math.min(dp[i + 1],dp[i + 2]) + cost[i];
        }
        return Math.min(dp[0],dp[1]);
    }
}
