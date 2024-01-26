package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

/**
 * @Author: ZBL
 * @Date: 2023-12-18  16:24
 * <p>
 * 通配符匹配 与code10正则表达式比较
 * 给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符序列（包括空字符序列）。
 * 判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2：
 * <p>
 * 输入：s = "aa", p = "*"
 * 输出：true
 * 解释：'*' 可以匹配任意字符串。
 * 示例 3：
 * <p>
 * 输入：s = "cb", p = "?a"
 * 输出：false
 * 解释：'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length, p.length <= 2000
 * s 仅由小写英文字母组成
 * p 仅由小写英文字母、'?' 或 '*' 组成
 */
public class Code44 {
    public boolean isMatch(String s, String p) {
        if ((s == null || s.length() == 0) && (p == null || p.length() == 0)) {
            return true;
        }
        if (p == null || p.length() == 0) {
            return false;
        }
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];//s的前i字符是否跟p的前j个字符相匹配
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            } else {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] |= dp[i - 1][j - 1];
                } else {
                    if (p.charAt(j - 1) == '*') {
                       dp[i][j] = dp[i - 1][j] || dp[i][j - 1];//分别对应匹配多个与匹配0个的情况
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Code44().isMatch("adceb", "*a*b"));
    }
}
