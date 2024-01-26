package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-10  14:58
 * 布尔运算
 * 给定一个布尔表达式和一个期望的布尔结果 result，
 * 布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。
 * 实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "1^0|0|1", result = 0
 * <p>
 * 输出: 2
 * 解释: 两种可能的括号方法是
 * 1^(0|(0|1))
 * 1^((0|0)|1)
 * 示例 2:
 * <p>
 * 输入: s = "0&0&0&1^1|0", result = 1
 * <p>
 * 输出: 10
 * 提示：
 * <p>
 * 运算符的数量不超过 19 个
 */
public class Face0814 {

    //区间dp
    public static  int countEval(String s, int result) {
        if(s.length() < 3) {
            return s.charAt(0) - '0' == result ? 1 : 0;
        }
        int[][][] dp = new int[s.length()][s.length()][2];
        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) == '0') {
                dp[i][i][0] = 1;
            }
            if(s.charAt(i) == '1') {
                dp[i][i][1] = 1;
            }
        }
        for (int len = 3; len <= s.length(); len += 2) {
            for (int left = 0; left <= s.length() - len; left += 2) {
                int right = left + len - 1;
                for (int i = left + 1; i <= right; i += 2) {
                    char action = s.charAt(i);
                    if (action == '&') {
                        dp[left][right][0] += dp[left][i - 1][0] * dp[i + 1][right][1] + dp[left][i - 1][0] * dp[i + 1][right][0] + dp[left][i - 1][1] * dp[i + 1][right][0];
                        dp[left][right][1] += dp[left][i - 1][1] * dp[i + 1][right][1];
                    }
                    if (action == '|') {
                        dp[left][right][0] += dp[left][i - 1][0] * dp[i + 1][right][0];

                        dp[left][right][1] += dp[left][i - 1][0] * dp[i + 1][right][1] + dp[left][i - 1][1] * dp[i + 1][right][1] + dp[left][i - 1][1] * dp[i + 1][right][0];
                    }
                    if (action == '^') {
                        dp[left][right][0] += dp[left][i - 1][0] * dp[i + 1][right][0] + dp[left][i - 1][1] * dp[i + 1][right][1];
                        dp[left][right][1] += (dp[left][i - 1][0] * dp[i + 1][right][1] + dp[left][i - 1][1] * dp[i + 1][right][0]);
                    }

                }
            }
        }

        return dp[0][s.length() - 1][result];
    }



    public static void main(String[] args) {
        System.out.println(countEval("0|0|1&1",1));
    }
}
