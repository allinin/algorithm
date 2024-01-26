package 工作后刷题.zjlab电脑刷题内容.最长上升子序列系列;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2024-01-10  10:18
 * 最长数对链(medium)
 * 给你一个由 n 个数对组成的数对数组 pairs ，其中 pairs[i] = [lefti, righti] 且 lefti < righti 。
 * <p>
 * 现在，我们定义一种 跟随 关系，当且仅当 b < c 时，数对 p2 = [c, d] 才可以跟在 p1 = [a, b] 后面。
 * 我们用这种形式来构造 数对链 。
 * <p>
 * 找出并返回能够形成的 最长数对链的长度 。
 * <p>
 * 你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：pairs = [[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4] 。
 * 示例 2：
 * <p>
 * 输入：pairs = [[1,2],[7,8],[4,5]]
 * 输出：3
 * 解释：最长的数对链是 [1,2] -> [4,5] -> [7,8] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == pairs.length
 * 1 <= n <= 1000
 * -1000 <= lefti < righti <= 1000
 */
public class Code646 {

    //贪心的方式
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int ans = 1;
        int right = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > right) {
                right = pairs[i][1];
                ans++;
            }
        }
        return ans;
    }

    // LIS的方式
    public int findLongestChain2(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[pairs.length + 1];
        dp[1] = pairs[0][1];
        int len = 1;
        for (int i = 1; i < pairs.length; i++) {
            int left = 1, right = len + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (pairs[i][0] > dp[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == len + 1) {
                len++;
                dp[len] = pairs[i][1];
            } else {
                if (dp[left] > pairs[i][1]) {
                    dp[left] = pairs[i][1];
                }
            }
        }
        return len;
    }
}
