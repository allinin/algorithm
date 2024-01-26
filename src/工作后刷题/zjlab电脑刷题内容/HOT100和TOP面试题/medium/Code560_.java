package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;


import java.util.HashMap;
import java.util.Map;

/**
 * 和为k的子数组
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class Code560_ {


    public int subarraySum(int[] nums, int k) {
        int ans = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //未遍历元素之前存在和为0的空数组，出现次数为1
        map.put(0,1);
        for (int num : nums) {
            sum += num;
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, -1, 0};
        System.out.println(new Code560_().subarraySum(arr, 0));
    }

}
