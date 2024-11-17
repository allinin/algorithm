package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.区间dp.hard;

/**
 * 戳气球 hard
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * <p>
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * <p>
 * 求所能获得硬币的最大数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [3,1,5,8]
 * 输出：167
 * 解释：
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * 示例 2：
 * <p>
 * 输入：nums = [1,5]
 * 输出：10
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 *
 * @Author:zbl
 * @Date:2024/11/16 21:58
 */
public class Code312 {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] help = new int[len + 2];
        help[0] = 1;
        help[len + 1] = 1;
        for (int i = 1; i <= len; i++) {
            help[i] = nums[i - 1];
        }
        int[][] dp = new int[len + 2][len + 2]; // 戳破i - j个气球的最大值
        for (int i = 1; i <= len; i++) {
            dp[i][i] = help[i] * help[i - 1] * help[i + 1];
        }
        //区间范围
        for (int range = 2; range <= len; range++) {
            //区间起始点
            for (int start = 1; start <= len; start++) {
                int end = start + range - 1;
                if (end > len) {
                    break;
                }
                //最后戳的气球,通过保留当前mid位置的气球最后戳破，
                // 使得分割后的两个区间之间的计算不会相互依赖，而是会依赖于当前保留下的mid位置的这个气球
                for (int mid = start; mid <= end; mid++) {
                    if (mid == start) {
                        dp[start][end] = Math.max(dp[start][end], help[start - 1] * help[start] * help[end + 1] + dp[start + 1][end]);
                    } else if (mid == end) {
                        dp[start][end] = Math.max(dp[start][end], help[start - 1] * help[end] * help[end + 1] + dp[start][end - 1]);
                    } else {
                        dp[start][end] = Math.max(dp[start][end], help[start - 1] * help[mid] * help[end + 1] + dp[start][mid - 1] + dp[mid + 1][end]);
                    }
                }
            }
        }
        return dp[1][len];
    }

    public static void main(String[] args) {
        System.out.println(new Code312().maxCoins(new int[]{3, 1, 5, 8}));
    }

}
