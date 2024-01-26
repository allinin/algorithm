package 工作后刷题.zjlab电脑刷题内容.最长上升子序列系列;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2024-01-10  10:20
 * 俄罗斯套娃问题(hard)
 * <p>
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * <p>
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 注意：不允许旋转信封。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 示例 2：
 * <p>
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= envelopes.length <= 105
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 105
 */
public class Code354 {
    public int maxEnvelopes(int[][] envelopes) {
        //先按照其中的一个维度进行排序，然后变转化为了LIS问题
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        int[][] dp = new int[envelopes.length + 1][2];
        for (int[] help : dp) {
            Arrays.fill(help, Integer.MAX_VALUE);
        }
        dp[1][0] = envelopes[0][0];
        dp[1][1] = envelopes[0][1];
        int len = 1;
        for (int i = 1; i < envelopes.length; i++) {
            int left = 1, right = len + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (envelopes[i][0] > dp[mid][0] && envelopes[i][1] > dp[mid][1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == len + 1) {
                len++;
                dp[len][0] = envelopes[i][0];
                dp[len][1] = envelopes[i][1];
            } else {
                //此时如果成立，则dp[left][0]也有可能是等于envelpos[i][0]的
                if (dp[left][1] > envelopes[i][1]) {
                    dp[left][1] = envelopes[i][1];
                    dp[left][0] = envelopes[i][0];
                }
            }
        }
        return len;
    }
}
