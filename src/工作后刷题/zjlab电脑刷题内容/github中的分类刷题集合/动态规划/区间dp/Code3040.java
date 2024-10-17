package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.区间dp;

import java.util.Arrays;

/**
 * 相同分数的最大操作数目II medium
 * 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作中的 任意 一个：
 * <p>
 * 选择 nums 中最前面两个元素并且删除它们。
 * 选择 nums 中最后两个元素并且删除它们。
 * 选择 nums 中第一个和最后一个元素并且删除它们。
 * 一次操作的 分数 是被删除元素的和。
 * <p>
 * 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
 * <p>
 * 请你返回按照上述要求 最多 可以进行的操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,1,2,3,4]
 * 输出：3
 * 解释：我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [1,2,3,4] 。
 * - 删除第一个元素和最后一个元素，分数为 1 + 4 = 5 ，nums = [2,3] 。
 * - 删除第一个元素和最后一个元素，分数为 2 + 3 = 5 ，nums = [] 。
 * 由于 nums 为空，我们无法继续进行任何操作。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,6,1,4]
 * 输出：2
 * 解释：我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [6,1,4] 。
 * - 删除最后两个元素，分数为 1 + 4 = 5 ，nums = [6] 。
 * 至多进行 2 次操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 2000
 * 1 <= nums[i] <= 1000
 *
 * @author: ZBL
 * @date: 2024-10-17  18:38
 */
public class Code3040 {

    public int maxOperations(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[3][n][n];//表示从i-j子数组进行操作的最大操作数
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int res = 0;
        res = Math.max(res, process(0, n - 1, nums[0] + nums[1], dp[0],nums));
        res = Math.max(res, process(0, n - 1, nums[n - 1] + nums[n - 2], dp[1],nums));
        res = Math.max(res, process(0, n - 1, nums[0] + nums[n - 1], dp[2],nums));
        return res;
    }

    private int process(int startIndex, int endIndex, int targetNum, int[][] dp,int[] nums) {
        if (startIndex >= endIndex) {
            return 0;
        }
        if (dp[startIndex][endIndex] != -1) {
            return dp[startIndex][endIndex];
        }
        int ans = 0;
        if(nums[startIndex] + nums[startIndex + 1] == targetNum) {
            ans = Math.max(ans,1 + process(startIndex + 2,endIndex,targetNum,dp,nums));
        }
        if(nums[startIndex] + nums[endIndex] == targetNum) {
            ans = Math.max(ans,1 + process(startIndex + 1,endIndex - 1,targetNum,dp,nums));
        }
        if(nums[endIndex] + nums[endIndex - 1] == targetNum) {
            ans = Math.max(ans,1 + process(startIndex,endIndex - 2,targetNum,dp,nums));
        }
        dp[startIndex][endIndex] = ans;
        return ans;
    }
}
