package 工作后刷题.zjlab电脑刷题内容.二分题目合集.最小化最大值;

/**
 * @Author: ZBL
 * @Date: 2023-12-27  14:02
 * <p>
 * 最小化数组中的最大值
 * <p>
 * 给你一个下标从 0 开始的数组 nums ，它含有 n 个非负整数。
 * <p>
 * 每一步操作中，你需要：
 * <p>
 * 选择一个满足 1 <= i < n 的整数 i ，且 nums[i] > 0 。
 * 将 nums[i] 减 1 。
 * 将 nums[i - 1] 加 1 。
 * 你可以对数组执行 任意 次上述操作，请你返回可以得到的 nums 数组中 最大值 最小 为多少。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,7,1,6]
 * 输出：5
 * 解释：
 * 一串最优操作是：
 * 1. 选择 i = 1 ，nums 变为 [4,6,1,6] 。
 * 2. 选择 i = 3 ，nums 变为 [4,6,2,5] 。
 * 3. 选择 i = 1 ，nums 变为 [5,5,2,5] 。
 * nums 中最大值为 5 。无法得到比 5 更小的最大值。
 * 所以我们返回 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,1]
 * 输出：10
 * 解释：
 * 最优解是不改动 nums ，10 是最大值，所以返回 10 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 2 <= n <= 105
 * 0 <= nums[i] <= 109
 */
public class Code2439_DONE {

    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        int left = 1, right = 1;
        for (int i = 0; i < n; i++) {
            right = Math.max(nums[i], right);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int target, int[] nums) {
        long diff = 0;//避免超出int的范围,表示前面的数能够帮助后面的数承载多少的差值
        for(int num : nums) {
            if(num < target) {
                diff += (target - num);
            } else {
                if(diff < num - target) {
                    return false;
                }
                diff -= (num - target);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 2, 2, 9, 19, 16, 0, 3, 15};
        System.out.println(new Code2439_DONE().minimizeArrayValue(arr));
    }
}
