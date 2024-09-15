package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.medium;

/**
 * @Author: ZBL
 * @Date: 2024-02-18  14:54
 * 环形子数组的最大和(medium)
 * 给定一个长度为n的环形整数数组nums ，返回 nums的非空子数组的最大可能和 。
 * <p>
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * <p>
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * 示例 2：
 * <p>
 * 输入：nums = [5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * 示例 3：
 * <p>
 * 输入：nums = [3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 */
public class Code918 {

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int max = getMax(nums);
        int min = getMin(nums);
        //避免最小子数组就是整个数组的情况
        if(sum == min) {
            return max;
        }
        //仿照求取数组的最大子数组，环形子数组的最大子数组要么等于普通的数组的最大数组，要么等于普通数组的最小子数组取反的情况
        return Math.max(max,sum - min);

    }

    //求和最小的子数组
    private int getMin(int[] arr) {
        int ans = Integer.MAX_VALUE,sum = 0;
        for(int i = 0;i < arr.length;i++) {
            sum += arr[i];
            ans = Math.min(ans,sum);
            if(sum > 0) {
                sum = 0;
            }
        }
        return ans;
    }

    //求和最大的子数组
    private int getMax(int[] arr) {
        int ans = Integer.MIN_VALUE,sum = 0;
        for(int i = 0;i < arr.length;i++) {
            sum += arr[i];
            ans = Math.max(ans,sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
}
