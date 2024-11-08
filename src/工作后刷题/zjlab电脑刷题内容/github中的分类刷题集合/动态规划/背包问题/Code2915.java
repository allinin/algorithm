package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.背包问题;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和为目标值的最长子序列的长度 medium
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 target 。
 * <p>
 * 返回和为 target 的 nums 子序列中，子序列 长度的最大值 。如果不存在和为 target 的子序列，返回 -1 。
 * <p>
 * 子序列 指的是从原数组中删除一些或者不删除任何元素后，剩余元素保持原来的顺序构成的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5], target = 9
 * 输出：3
 * 解释：总共有 3 个子序列的和为 9 ：[4,5] ，[1,3,5] 和 [2,3,4] 。最长的子序列是 [1,3,5] 和 [2,3,4] 。所以答案为 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,1,3,2,1,5], target = 7
 * 输出：4
 * 解释：总共有 5 个子序列的和为 7 ：[4,3] ，[4,1,2] ，[4,2,1] ，[1,1,5] 和 [1,3,2,1] 。最长子序列为 [1,3,2,1] 。所以答案为 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5,4,5], target = 3
 * 输出：-1
 * 解释：无法得到和为 3 的子序列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * 1 <= target <= 1000
 *
 * @author: ZBL
 * @date: 2024-11-07  09:45
 */
public class Code2915 {

    // 0-1背包问题
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        int sum = nums.stream().mapToInt(num -> num).sum();
        if (sum < target) {
            return -1;
        }
        int[] dp = new int[target + 1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            for (int j = target; j >= 1; j--) {
                if (j >= num && dp[j - num] != -1) {
                    dp[j] = Math.max(dp[j - num] + 1, dp[j]);
                }
            }
        }
        dp[0] = 0;
        return dp[target];
    }

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,1,5,4,5);
        int target = 3;
        System.out.println(new Code2915().lengthOfLongestSubsequence(list,target));
    }
}
