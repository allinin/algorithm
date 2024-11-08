package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.背包问题;

/**
 * 分割等和子集 medium
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 * @author: ZBL
 * @date: 2024-11-08  18:20
 */
public class Code416 {

    //0-1背包问题
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum / 2; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] |= dp[j - nums[i]];
                }
            }
        }
        return dp[sum / 2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11};
        System.out.println(new Code416().canPartition(nums));
    }
}
