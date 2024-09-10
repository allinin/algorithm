package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.滑动窗口;

/**
 * @Author: ZBL
 * @Date: 2024-01-26  12:29
 * <p>
 * 乘积小于k的子数组(medium)
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 */
public class Code713 {

    //个人电脑已经done
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int multiSum = 1, ans = 0, left = 0, right = 0, n = nums.length;
        while (right < n) {
            multiSum *= nums[right++];
            if (multiSum < k) {
                ans += (right - left);
            } else {
                while (multiSum >= k && left < n) {
                    multiSum /= nums[left++];
                }
                ans += (right - left);
            }
        }
        return ans;
    }

    //二刷
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0,right = 0,len = nums.length;
        int multiSum = 1;
        int ans = 0;
        while(right < len) {
            multiSum *= nums[right++];
            while (multiSum >= k && left < right) {
                multiSum /= nums[left++];
            }
            //计算以nums[right]结尾的子数组的数量
            ans += (right - left);
        }
        return ans;
    }
}
