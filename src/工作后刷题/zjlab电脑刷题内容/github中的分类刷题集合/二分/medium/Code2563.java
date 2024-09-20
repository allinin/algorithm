package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二分.medium;

import java.util.Arrays;

/**
 * 统计公平数对的数目 medium
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和两个整数 lower 和 upper ，返回 公平数对的数目 。
 * <p>
 * 如果 (i, j) 数对满足以下情况，则认为它是一个 公平数对 ：
 * <p>
 * 0 <= i < j < n，且
 * lower <= nums[i] + nums[j] <= upper
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,7,4,4,5], lower = 3, upper = 6
 * 输出：6
 * 解释：共计 6 个公平数对：(0,3)、(0,4)、(0,5)、(1,3)、(1,4) 和 (1,5) 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,7,9,2,5], lower = 11, upper = 11
 * 输出：1
 * 解释：只有单个公平数对：(2,3) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums.length == n
 * -109 <= nums[i] <= 109
 * -109 <= lower <= upper <= 109
 *
 * @author: ZBL
 * @date: 2024-09-20  18:46
 */
public class Code2563 {

    public long countFairPairs(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            long min = lower - nums[i];
            long max = upper - nums[i];
            if (min > nums[nums.length - 1] || max < nums[0]) {
                continue;
            }
            int firstIndex = findFirstIndex(min, nums, i + 1, nums.length - 1);
            int lastIndex = findLastIndex(max, nums, i + 1, nums.length - 1);
            ans += (lastIndex - firstIndex);
            if (nums[lastIndex] <= max ) {
                ans++;
            }
        }
        return ans;
    }

    private int findFirstIndex(long target, int[] nums, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // >= target
                right = mid;
            }
        }
        return left;
    }

    private int findLastIndex(long target, int[] nums, int left, int right) {
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // <= target
                left = mid;
            }
        }
        return left;
    }
}
