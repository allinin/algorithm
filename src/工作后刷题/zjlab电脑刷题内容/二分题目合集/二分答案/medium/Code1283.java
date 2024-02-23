package 工作后刷题.zjlab电脑刷题内容.二分题目合集.二分答案.medium;

/**
 * @Author: ZBL
 * @Date: 2023-12-28  09:23
 * 使结果不超过阈值的最小除数
 * <p>
 * 给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，
 * 并对除法结果求和。
 * <p>
 * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
 * <p>
 * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
 * <p>
 * 题目保证一定有解。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,5,9], threshold = 6
 * 输出：5
 * 解释：如果除数为 1 ，我们可以得到和为 17 （1+2+5+9）。
 * 如果除数为 4 ，我们可以得到和为 7 (1+1+2+3) 。如果除数为 5 ，和为 5 (1+1+1+2)。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,5,7,11], threshold = 11
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：nums = [19], threshold = 5
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 10^4
 * 1 <= nums[i] <= 10^6
 * nums.length <= threshold <= 10^6
 */
public class Code1283 {

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] % threshold == 0 ? nums[0] / threshold : nums[0] / threshold + 1;
        }
        int left = 1, right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums, threshold)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean check(int target, int[] nums, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += num / target;
            if (num % target != 0) {
                sum++;
            }
        }
        return sum <= threshold;
    }

}
