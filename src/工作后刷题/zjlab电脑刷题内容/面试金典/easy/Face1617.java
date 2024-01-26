package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-15  10:10
 * 连续数列
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Face1617 {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i < nums.length;i++) {
            sum += nums[i];
            ans = Math.max(ans,sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
}
