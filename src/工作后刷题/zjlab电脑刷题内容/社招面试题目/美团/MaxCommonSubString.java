package 工作后刷题.zjlab电脑刷题内容.社招面试题目.美团;

/**
 * 最长公共子串（Longest Common Substring）： 是指两个字符串中最长连续相同的子串长度。
 * <p>
 * 例如：str1=“1AB2345CD”,str2=”12345EF”,则str1，str2的最长公共子串为2345
 *
 * @author: ZBL
 * @date: 2024-10-15  19:42
 */
public class MaxCommonSubString {

    public static String getMaxCommonString(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1]; //以s1的第i个字符，s2的第j个字符结尾的公共子串的最大长度
        String ans = "";
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > ans.length()) {
                        ans = s1.substring(i - dp[i][j], i);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getMaxCommonString("1AB2345CD", "12345EF"));
    }

}
