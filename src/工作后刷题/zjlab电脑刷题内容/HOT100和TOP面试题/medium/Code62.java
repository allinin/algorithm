package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.Arrays;

/**
 *
 * 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 */
public class Code62 {

    public int uniquePaths(int m, int n) {
       int[] dp = new int[n];
       Arrays.fill(dp,1);
       for(int i = 1;i < m;i++) {
           for(int j = 1;j < n;j++) {
               dp[j] += dp[j - 1];
           }
       }
       return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code62().uniquePaths(3,2));
    }
}
