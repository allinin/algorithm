package 工作后刷题.zjlab电脑刷题内容.二分查找.最小化最大值;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2023-12-28  09:20
 * <p>
 * 最小化数对的最大差值(medium)
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 p 。请你从 nums 中找到 p 个下标对，
 * 每个下标对对应数值取差值，你需要使得这 p 个差值的 最大值 最小。同时，你需要确保每个下标在这 p 个下标对中最多出现一次。
 * <p>
 * 对于一个下标对 i 和 j ，这一对的差值为 |nums[i] - nums[j]| ，其中 |x| 表示 x 的 绝对值 。
 * <p>
 * 请你返回 p 个下标对对应数值 最大差值 的 最小值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,1,2,7,1,3], p = 2
 * 输出：1
 * 解释：第一个下标对选择 1 和 4 ，第二个下标对选择 2 和 5 。
 * 最大差值为 max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1 。所以我们返回 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,2,1,2], p = 1
 * 输出：0
 * 解释：选择下标 1 和 3 构成下标对。差值为 |2 - 2| = 0 ，这是最大差值的最小值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= p <= (nums.length)/2
 */
public class Code2616 {

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums, p)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //注意这个check方法的写法，取最相近的两个元素的差值，如果当前两个元素去到了，则需要i+2,跳过下一个元素，否则再取下一个元素与下下一个元素的差值
    private boolean check(int target, int[] nums, int p) {
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] <= target) {
                sum++;
                ++i;
            }
        }
        return sum >= p;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 1, 2, 7, 1, 3};
        int p = 2;
        System.out.println(new Code2616().minimizeMax(arr, p));
    }
}
