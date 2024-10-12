package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.滑动窗口.最大连续1的个数系列题目;

/**
 * @Author: ZBL
 * @Date: 2024-01-31  19:04
 *
 * 最大连续1的个数Ⅱ(medium)
 * 题目：给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
 * 示例 1：
 *
 * 输入：[1,0,1,1,0]
 *
 * 输出：4
 *
 * 解释：翻转第一个 0 可以得到最长的连续 1。
 *
 * 当翻转以后，最大连续 1 的个数为 4。
 *
 * 注：
 *
 * 输入数组只包含 0 和 1.
 * 输入数组的长度为正整数，且不超过 10,000
 */
public class Code487 {

    //窗口中最多出现一个0,所以窗口的最大长度为1的个数+1
    public int longestOnes(int[] nums) {
        int zeroNum = 0, n = nums.length;
        for (int num : nums) {
            if (num == 0) {
                zeroNum++;
            }

        }
        if (zeroNum <= 1) {
            return n;
        }
        int ans = 0;
        int left = 0, right = 0, count = 0;
        while (right < n) {
            if (nums[right++] == 1) {
                count++;
            }
            if (right - left <= count + 1) {
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

    //重温
    public int longestOnes2(int[] nums) {
        int left = 0,right = 0,len = nums.length,ans = 0;
        int zeroNum = 0;
        while(right < len) {
            if(nums[right++] == 0) {
                zeroNum++;
            }
            if(zeroNum > 1) {
                while(zeroNum > 1) {
                    if(nums[left++] == 0) {
                        zeroNum--;
                    }
                }
            } else {
                ans = Math.max(ans,right - left);
            }

        }
        return ans;
    }
}
