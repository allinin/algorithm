package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.滑动窗口.最大连续1的个数系列题目;

/**
 * 最大连续1的个数 easy
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * 示例 2:
 *
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1.
 * @Author:zbl
 * @Date:2024/10/1 15:29
 */
public class Code485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int left = 0,right = 0,len = nums.length;
        while(right < len) {
            if(nums[right++] == 1) {
                ans = Math.max(ans,right - left);
            } else {
                left = right;
            }
        }
        return ans;
    }
}
