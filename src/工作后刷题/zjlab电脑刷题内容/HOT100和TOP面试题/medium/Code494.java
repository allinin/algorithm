package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 目标和
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
 */
public class Code494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = target;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1 || sum < 0) {
            return 0;
        }
        int newTarget = sum / 2;
        //等价于找出和为sum / 2的子序列的数量,前i个元素中和为j的子序列的数量
        int[] dp = new int[newTarget + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = newTarget; j >= 0; j--) {
                int num = nums[i - 1];
                //只能不选择当前元素
                if(num > j) {
                    continue;
                } else {
                    //选择当前元素的数量 + 不选当前元素的数量
                    dp[j] = dp[j - num] + dp[j];
                }
            }
        }
        return dp[newTarget];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,1,1};
        System.out.println(new Code494().findTargetSumWays(nums,3));
    }
}
