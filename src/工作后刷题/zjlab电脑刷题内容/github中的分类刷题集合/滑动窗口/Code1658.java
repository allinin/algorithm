package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.滑动窗口;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZBL
 * @Date: 2024-01-25  11:15
 * 将X减到0的最少操作数(medium)
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，
 * 然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * <p>
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 */
public class Code1658 {

    Map<String, Integer> map = new HashMap<>();
    //超时
    public int minOperations(int[] nums, int x) {
        return process(nums, 0, nums.length - 1, x);
    }

    private int process(int[] nums, int left, int right, int x) {
        if (x == 0) {
            return 0;
        }
        if (left > right || (nums[left] > x && nums[right] > x)) {
            return -1;
        }
        if (left == right && nums[left] != x) {
            return -1;
        }
        String key = left + "_" + right;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int ans = 1;
        int tmp1 = 1000000000, tmp2 = 1000000000;
        if (nums[left] <= x) {
            tmp1 = process(nums, left + 1, right, x - nums[left]);
        }

        if (nums[right] <= x) {
            tmp2 = process(nums, left, right - 1, x - nums[right]);
        }
        if (tmp2 == -1 && tmp1 == -1) {
            map.put(key, -1);
            return -1;
        }

        tmp1 = tmp1 == -1 ? Integer.MAX_VALUE : tmp1;
        tmp2 = tmp2 == -1 ? Integer.MAX_VALUE : tmp2;

        ans += Math.min(tmp2, tmp1);
        map.put(key, ans);
        return ans;
    }

    //方法二：思路转化，等价于寻找和为nums中所有元素和-x的最长子数组的，滑动窗口解决
    //在个人电脑已经完成
    public int minOperations2(int[] nums, int x) {
        int sum = -x;
        for (int num : nums) {
            sum += num;
        }
        if (sum < 0) return -1;//此时sum < 0说明整个nums数组的元素和都小于x
        int left = 0, right = 0, n = nums.length, ans = -1;
        while (right < n) {
            sum -= nums[right++];
            while (sum < 0) {
                sum += nums[left++];
            }
            if (sum == 0) {
                ans = Math.max(ans, right - left);
            }
        }

        return ans == -1 ? -1 : n - ans;
    }

}
