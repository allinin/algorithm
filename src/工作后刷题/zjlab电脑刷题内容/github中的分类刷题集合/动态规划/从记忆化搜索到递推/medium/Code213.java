package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.从记忆化搜索到递推.medium;

/**
 * 打家截舍II MEDIUM
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * @author: ZBL
 * @date: 2024-11-06  19:06
 */
public class Code213 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int ans = 0;
        int[][] dp = new int[n][2];//从第i个房子开始偷到最后能够偷的最大值
        dp[n - 1][1] = nums[n - 1]; //偷最后一个房子，则不能偷第一个房子
        for (int i = n - 2; i >= 1; i--) {
            dp[i][0] = Math.max(dp[i + 1][1], dp[i + 1][0]);
            dp[i][1] = nums[i] + dp[i + 1][0];
        }
        ans = Math.max(ans, Math.max(dp[1][1], dp[1][0]));
        int[][] dp1 = new int[n][2];
        //不偷最后一个房子
        for (int i = n - 2; i >= 0; i--) {
            dp1[i][0] = Math.max(dp1[i + 1][1], dp1[i + 1][0]);
            dp1[i][1] = nums[i] + dp1[i + 1][0];
        }
        return Math.max(ans, Math.max(dp1[0][1], dp1[0][1]));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1};
        System.out.println(new Code213().rob(arr));
    }
}
