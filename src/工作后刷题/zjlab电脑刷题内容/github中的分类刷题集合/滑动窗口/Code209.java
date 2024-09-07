package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.滑动窗口;

/**
 * @Author: ZBL
 * @Date: 2024-01-26  12:28
 * 长度最小的子数组(medium)
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 *
 * 进阶：
 *
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 */
public class Code209 {

    //回顾
    public int minSubArrayLen2(int target, int[] nums) {
        int ans = Integer.MAX_VALUE,left = 0,right = 0;
        int sum = 0;
        while(right < nums.length) {
            sum += nums[right++];
            while(sum >= target) {
                ans = Math.min(ans,right - left);
                sum -= nums[left++];
            }
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }

    //个人电脑上已经done
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0,right = 0;
        int ans = Integer.MAX_VALUE,sum = 0;
        while(right < nums.length) {
            sum += nums[right++];
            while(sum >= target) {
                ans = Math.min(ans,right - left);
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
