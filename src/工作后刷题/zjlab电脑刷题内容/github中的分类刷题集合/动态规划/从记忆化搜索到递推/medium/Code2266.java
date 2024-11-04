package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.从记忆化搜索到递推.medium;

/**
 * 统计打字方案数 medium
 * lice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
 * <p>
 * <p>
 * <p>
 * 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
 * <p>
 * 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
 * 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
 * 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
 * <p>
 * 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
 * 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
 * <p>
 * 由于答案可能很大，将它对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：pressedKeys = "22233"
 * 输出：8
 * 解释：
 * Alice 可能发出的文字信息包括：
 * "aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
 * 由于总共有 8 种可能的信息，所以我们返回 8 。
 * 示例 2：
 * <p>
 * 输入：pressedKeys = "222222222222222222222222222222222222"
 * 输出：82876089
 * 解释：
 * 总共有 2082876103 种 Alice 可能发出的文字信息。
 * 由于我们需要将答案对 109 + 7 取余，所以我们返回 2082876103 % (109 + 7) = 82876089 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= pressedKeys.length <= 105
 * pressedKeys 只包含数字 '2' 到 '9' 。
 *
 * @author: ZBL
 * @date: 2024-11-04  19:31
 */
public class Code2266 {
    private final Integer MOD = 1000000007;

    private int[] HELP_ARR = new int[]{0, 0, 3, 3, 3, 3, 3, 4, 3, 4};

    public int countTexts(String pressedKeys) {
        int sum = 0;
        if (pressedKeys == null || pressedKeys.length() == 0) {
            return 0;
        }
        int[] dp = new int[pressedKeys.length() + 1];
        dp[1] = 1;
        dp[0] = 1;
        int startIndex = 1;
        for (int i = 2; i <= pressedKeys.length(); i++) {
            if (pressedKeys.charAt(i - 1) != pressedKeys.charAt(i - 2)) {
                dp[i] = dp[i - 1];
                startIndex = i;
            } else {
                int diffNum = HELP_ARR[pressedKeys.charAt(i - 1) - '0'];
                for (int j = i - Math.min(diffNum, i - startIndex + 1); j < i; j++) {
                    dp[i] = (dp[i] + dp[j]) % MOD;
                }
            }
        }
        return dp[pressedKeys.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Code2266().countTexts("222222222222222222222222222222222222"));
    }
}
