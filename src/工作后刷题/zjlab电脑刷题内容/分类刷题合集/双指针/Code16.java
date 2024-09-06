package 工作后刷题.zjlab电脑刷题内容.分类刷题合集.双指针;

import java.util.Arrays;

/**
 * 最接近的三数之和(medium)
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * 解释：与 target 最接近的和是 0（0 + 0 + 0 = 0）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 *
 * @author: ZBL
 * @date: 2024-09-06  19:20
 */
public class Code16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int diff = Integer.MAX_VALUE, ans = 0;
        for (int i = 0; i < len; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] < target) {
                    int tmp = target - nums[left] - nums[right] - nums[i];
                    if (tmp < diff) {
                        ans = nums[left] + nums[right] + nums[i];
                        diff = tmp;
                    }
                    left++;
                } else if (nums[left] + nums[right] + nums[i] > target) {
                    int tmp = -target + nums[left] + nums[right] + nums[i];
                    if (tmp < diff) {
                        ans = nums[left] + nums[right] + nums[i];
                        diff = tmp;
                    }
                    right--;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }
}
