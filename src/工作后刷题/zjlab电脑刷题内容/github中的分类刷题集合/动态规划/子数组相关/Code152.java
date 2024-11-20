package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.子数组相关;

import java.util.Arrays;

/**
 * 乘积最大子数组 medium
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何子数组的乘积都 保证 是一个 32-位 整数
 *
 * @author: ZBL
 * @date: 2024-11-19  19:34
 */
public class Code152 {
    public int maxProduct(int[] nums) {
        int m = nums.length;
        int[][] dp = new int[m + 1][2];//以第i个元素结尾的最大/最小组数
        int ans = Integer.MIN_VALUE;
        for (int[] tmp : dp) {
            Arrays.fill(tmp, 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] >= 0) {
                dp[i][0] = Math.max(dp[i - 1][0], 1) * nums[i - 1];
                dp[i][1] = Math.min(dp[i - 1][1], 1) * nums[i - 1];
            } else {
                dp[i][0] = Math.min(dp[i - 1][1], 1) * nums[i - 1];
                dp[i][1] = Math.max(dp[i - 1][0], 1) * nums[i - 1];
            }

            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Code152().maxProduct(new int[]{-2}));
    }
}
