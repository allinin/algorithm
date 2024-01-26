package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

/**
 * 最长有效括号
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 */
public class Code32 {

    public int longestValidParentheses(String s) {
        int n = s.length(),ans = 0;
        int[] dp = new int[n + 1];//以第i个字符为结尾的有效括号字串的长度
        for(int i = 2;i <= n;i++) {
            char c = s.charAt(i - 1);
            if(c == '(') {
                continue;
            }
            char pre = s.charAt(i - 2);
            if(pre == '(') {
                dp[i] = 2 + dp[i - 2];
            } else {
                int prePreIndex = i - dp[i - 1] - 2;
                if(prePreIndex >= 0 && s.charAt(prePreIndex) == '(') {
                    dp[i] = dp[i - 1] + 2 + dp[prePreIndex];
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new Code32().longestValidParentheses("()(())");
        System.out.println(i);
    }
}
