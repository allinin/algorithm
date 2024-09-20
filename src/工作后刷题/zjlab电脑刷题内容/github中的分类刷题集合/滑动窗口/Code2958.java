package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 *  最多k个重复元素的最长子数组 medium
 * 给你一个整数数组 nums 和一个整数 k 。
 *
 * 一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
 *
 * 如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
 *
 * 请你返回 nums 中 最长好 子数组的长度。
 *
 * 子数组 指的是一个数组中一段连续非空的元素序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1,2,3,1,2], k = 2
 * 输出：6
 * 解释：最长好子数组是 [1,2,3,1,2,3] ，值 1 ，2 和 3 在子数组中的频率都没有超过 k = 2 。[2,3,1,2,3,1] 和 [3,1,2,3,1,2] 也是好子数组。
 * 最长好子数组的长度为 6 。
 * 示例 2：
 *
 * 输入：nums = [1,2,1,2,1,2,1,2], k = 1
 * 输出：2
 * 解释：最长好子数组是 [1,2] ，值 1 和 2 在子数组中的频率都没有超过 k = 1 。[2,1] 也是好子数组。
 * 最长好子数组的长度为 2 。
 * 示例 3：
 *
 * 输入：nums = [5,5,5,5,5,5,5], k = 4
 * 输出：4
 * 解释：最长好子数组是 [5,5,5,5] ，值 5 在子数组中的频率没有超过 k = 4 。
 * 最长好子数组的长度为 4 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= nums.length
 * @author: ZBL
 * @date: 2024-09-20  19:53
 */
public class Code2958 {

    public int maxSubarrayLength(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0,left = 0,right = 0,len = nums.length;
        while(right < len) {
            int num = nums[right++];
            map.put(num,map.getOrDefault(num,0) + 1);
            if(map.get(num) <= k) {
                ans = Math.max(right - left,ans);
            } else {
                while(map.get(num) > k) {
                    int leftNum = nums[left++];
                    map.put(leftNum,map.get(leftNum) - 1);
                }
            }
        }
        return ans;
    }
}
