package 工作后刷题.zjlab电脑刷题内容.分类刷题合集.滑动窗口;

import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-31  17:18
 * <p>
 * 最大连续1的个数III(medium)
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 0 <= k <= nums.length
 */
public class Code1004 {

    //窗口中最多出现k个0
    public int longestOnes(int[] nums, int k) {
        int zeroNum = 0, n = nums.length;
        for (int num : nums) {
            if (num == 0) {
                zeroNum++;
            }

        }
        if (zeroNum <= k) {
            return n;
        }
        int ans = 0;
        int left = 0, right = 0, count = 0;
        while (right < n) {
            if (nums[right++] == 1) {
                count++;
            }
            if (right - left <= count + k) {
                ans = Math.max(ans, right - left);
            } else {
                if (nums[left] == 1) {
                    count--;
                }
                left++;
            }
        }
        return ans;
    }
}
