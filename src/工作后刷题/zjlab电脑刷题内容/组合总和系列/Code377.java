package 工作后刷题.zjlab电脑刷题内容.组合总和系列;

/**
 * 组合总和IV(medium)
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * <p>
 * 题目数据保证答案符合 32 位整数范围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 * <p>
 * 输入：nums = [9], target = 3
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 * <p>
 * <p>
 * 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
 *
 * @author: ZBL
 * @date: 2024-08-28  19:44
 */
public class Code377 {

    //组合背包问题
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];//用前i个数，组成大小为j的数共有多少种方式
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= n; j++) {
                if(i >= nums[j - 1]) {
                    dp[i] += dp[i - nums[j - 1]];
                }
            }
        }
        return dp[target];
    }
}
