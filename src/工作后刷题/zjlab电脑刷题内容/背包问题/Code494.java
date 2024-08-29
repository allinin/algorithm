package 工作后刷题.zjlab电脑刷题内容.背包问题;

/**
 * 目标和(medium)
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * <p>
 * 输入：nums = [1], target = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 *
 * @author: ZBL
 * @date: 2024-08-29  19:30
 */
public class Code494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = target;
        for (int num : nums) {
            sum += num;
        }
        if (sum < 0 || sum % 2 == 1) {
            return 0;
        }

        int[] dp = new int[sum / 2 + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = sum / 2; j >= 0; j--) {
                if (j >= num) {
                    dp[j] += dp[j - num];
                }
            }
        }
        return dp[sum / 2];
    }
}
