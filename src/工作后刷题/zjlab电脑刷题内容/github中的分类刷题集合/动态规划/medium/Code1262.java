package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.medium;

/**
 * @Author: ZBL
 * @Date: 2024-02-19  13:52
 * 可被三整除的最大和(medium)
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 *
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 */
public class Code1262 {

    //空间复杂度O(n)
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][3];//表示nums中前i个数组成的子数组元素和%3 = j的最大元素和
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for(int i = 1;i <= n;i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][(j + nums[i - 1]) % 3] + nums[i - 1]);
            }
        }
        return dp[n][0];
    }

    //滚动数组优化，空间复杂度o(1)
    public int maxSumDivThree2(int[] nums) {
        int n = nums.length;
        int[]dpPre = new int[3];//表示nums中前i个数组成的子数组元素和%3 = j的最大元素和
        dpPre[1] = Integer.MIN_VALUE;
        dpPre[2] = Integer.MIN_VALUE;

        int[]dp = new int[3];//表示nums中前i个数组成的子数组元素和%3 = j的最大元素和
        dp[1] = Integer.MIN_VALUE;
        dp[2] = Integer.MIN_VALUE;
        for(int i = 1;i <= n;i++) {

            for (int j = 0; j < 3; j++) {
                dp[j] = Math.max(dpPre[j], dpPre[(j + nums[i - 1]) % 3] + nums[i - 1]);
            }

            for(int k = 0;k < 3;k++) {
                dpPre[k] = dp[k];
            }

        }
        return dp[0];
    }

}
