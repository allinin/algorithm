package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

/**
 * 戳气球
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * <p>
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
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
 */
public class Code312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] help = new int[n + 2];
        help[0] = 1;
        help[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            help[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];//戳破i - j范围的气球的最大收益
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                if (i == j) {
                    dp[j][i] = help[i] * help[i - 1] * help[i + 1];
                }
                Integer max = Integer.MIN_VALUE;

                //最后戳破的气球，通过最后戳破的气球将需要戳破的气球分为了两部分即：j -> k-1,k + 1->i,两部分互不影响
                for (int k = j; k <= i; k++) {
                    if (k == j) {
                        max = Math.max(max, dp[j + 1][i] + help[j] * help[j - 1] * help[i + 1]);
                    } else if (k == i) {
                        max = Math.max(max, dp[j][i - 1] + help[i] * help[i + 1] * help[j - 1]);
                    } else {
                        max = Math.max(max, help[k] * help[j - 1] * help[i + 1] + dp[j][k - 1] + dp[k + 1][i]);
                    }
                }
                dp[j][i] = max;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,8};
        System.out.printf(new Code312().maxCoins(nums) + "");
    }
}

