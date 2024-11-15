package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.区间dp;

import java.util.Arrays;

/**
 * 最长回文子串 medium
 * 给你一个字符串 s，找到 s 中最长的
 * 回文
 * <p>
 * 子串
 * 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * @author: ZBL
 * @date: 2024-11-15  19:52
 */
public class Code5 {

    //区间dp的写法
    public String longestPalindrome(String s) {
        int len = s.length();
        int start = 0, end = 0;
        int max = 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        //区间长度
        for (int range = 2; range <= len; range++) {
            //当前长度下的起始端点
            for (int i = 0; i < len; i++) {
                int j = i + range - 1;
                if (j >= len) {
                    break;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2) {
                        dp[i][j] = 2;
                        //等于零说明中间的部分不是回文串
                    } else if (dp[i + 1][j - 1] != 0) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    }
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    //直接设定中心点，然后往两边延伸的写法
    public String longestPalindrome2(String s) {
        int len = s.length();
        int start = 0, end = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int left = i, right = i;//以当前点为中心
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > max) {
                    start = left;
                    end = right;
                    max = right - left + 1;
                }
                left--;
                right++;
            }
            //以中间间隙为中心
            left = i;
            right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > max) {
                    start = left;
                    end = right;
                    max = right - left + 1;
                }
                left--;
                right++;
            }

        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code5().longestPalindrome2("aacabdkacaa"));
    }
}
