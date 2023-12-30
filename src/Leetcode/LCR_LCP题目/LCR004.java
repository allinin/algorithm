package Leetcode.LCR_LCP题目;

/**
 * @Author:zbl
 * @Date:2023/12/30 20:01
 *
 * 只出现一次的数字II
 *
 *给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [0,1,0,1,0,1,100]
 * 输出：100
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 *
 *
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 *
 *
 * 注意：本题与主站 137 题相同：https://leetcode-cn.com/problems/single-number-ii/
 *
 */
public class LCR004 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 31;i >=0;i--) {
            int sum = 0;
            for(int num : nums) {
                sum +=(1 & (num >> i));
            }
            ans |= (sum % 3) << i;
        }
        return ans;
    }
}
