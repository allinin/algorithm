package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.区间dp.medium;

/**
 * 最长回文子序列 medium
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * <p>
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 *
 * @author: ZBL
 * @date: 2024-09-09  19:35
 */
public class Code516 {

    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1]; // i - j子串的最大回文子序列长度

        for (int i = 1; i <= len; i++) {
            dp[i][i] = 1;
        }

        for (int i = 2; i <= len; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (s.charAt(j - 1) == s.charAt(i - 1)) {
                    if(i - j >= 2) {
                        dp[j][i] = dp[j + 1][i - 1] + 2;
                    } else {
                        dp[j][i] = 2;
                    }
                } else {
                   dp[j][i] = Math.max(dp[j + 1][i],dp[j][i - 1]);
                }
            }
        }
        return dp[1][len];
    }

    /**
     * 空间优化：
     * 把 f 数组的第一个维度去掉。相当于把 f[i] 和 f[i+1] 保存到同一个一维数组中。
     *
     * 但一个萝卜一个坑，f[j−1] 要么保存的是 f[i+1][j−1]，要么保存的是 f[i][j−1]，怎么妥当地处理新旧数据？对于本题来说，
     * 可以用变量 pre 记录 f[i+1][j−1] 的值。计算到 f[j] 时，f[j−1] 保存的是新数据 f[i][j−1]，旧数据 f[i+1][j−1] 可以从 pre 中取到
     *
     * 链接：https://leetcode.cn/problems/longest-palindromic-subsequence/solutions/2203001/shi-pin-jiao-ni-yi-bu-bu-si-kao-dong-tai-kgkg/
     * @return
     */
    public static int longestPalindromeSubseq2(String s) {
        int len = s.length();
        int[] dp = new int[len];
        for(int i = len - 1;i >= 0;i--) {
            dp[i] = 1;
            int pre =0; // 初始为：dp[i + 1][i]
            for(int j = i + 1;j < len;j++) {
                int tmp = dp[j];
                if(s.charAt(j) == s.charAt(i)) {
                    dp[j] = 2 + pre;
                } else {
                    dp[j] = Math.max(dp[j - 1],dp[j]);
                }
                pre = tmp;
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq2("bbbab"));
    }
}
