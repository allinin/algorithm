package 工作后刷题.zjlab电脑刷题内容.打家劫舍系列;

/**
 * @Author: ZBL
 * @Date: 2023-12-26  13:53
 * <p>
 * 打家劫舍II
 * <p>
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
 */
public class Code213 {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        int ans = 0;
        //不偷第一个,相当于2-n随便偷
        for (int i = n; i >= 2; i--) {
            if(i == n) {
                dp[n][0] = 0;
                dp[n][1] = nums[i - 1];
            } else {
                dp[i][0] = Math.max(dp[i + 1][1], dp[i + 1][0]);
                dp[i][1] = nums[i - 1] + dp[i + 1][0];
            }
        }
        ans = Math.max(dp[2][1],dp[2][0]);
        int[][] dp2 = new int[n + 1][2];
        //偷第一个的情况,相当于1 —— n-1随便偷
        for(int i = n - 1;i >= 1;i--) {
            if(i == n - 1) {
                dp2[i][0] = 0;
                dp2[i][1] = nums[i - 1];
            } else {
                dp2[i][0] = Math.max(dp2[i + 1][1], dp2[i + 1][0]);
                dp2[i][1] = nums[i - 1] + dp2[i + 1][0];
            }

        }
        return Math.max(Math.max(dp2[1][1],dp[1][0]),ans);
    }

    //写法二：
    public int rob2(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        //偷最后一个,相当于2-n随便偷,并且取值dp[n][1]表示偷最后一个
        dp[2][1] = nums[1];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0]  + nums[i - 1];
        }
        int[][] dp2 = new int[n][2];
        //不偷最后一个,相当于1 —— n-1随便偷
        dp2[1][1] = nums[0];
        for(int i = 2;i < n;i++) {
            dp2[i][0] = Math.max(dp2[i - 1][0], dp2[i - 1][1]);
            dp2[i][1] = dp2[i - 1][0]  + nums[i - 1];
        }
        return Math.max(Math.max(dp2[n - 1][1],dp2[n - 1][0]),dp[n][1]);
    }

    public static void main(String[] args) {
        System.out.println(new Code213().rob(new int[]{1,2,3}));
    }
}
