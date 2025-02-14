package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.从记忆化搜索到递推.medium;

/**
 * 统计构造好字符串的方案数 medium
 * 给你整数 zero ，one ，low 和 high ，我们从空字符串开始构造一个字符串，每一步执行下面操作中的一种：
 * <p>
 * 将 '0' 在字符串末尾添加 zero  次。
 * 将 '1' 在字符串末尾添加 one 次。
 * 以上操作可以执行任意次。
 * <p>
 * 如果通过以上过程得到一个 长度 在 low 和 high 之间（包含上下边界）的字符串，那么这个字符串我们称为 好 字符串。
 * <p>
 * 请你返回满足以上要求的 不同 好字符串数目。由于答案可能很大，请将结果对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：low = 3, high = 3, zero = 1, one = 1
 * 输出：8
 * 解释：
 * 一个可能的好字符串是 "011" 。
 * 可以这样构造得到："" -> "0" -> "01" -> "011" 。
 * 从 "000" 到 "111" 之间所有的二进制字符串都是好字符串。
 * 示例 2：
 * <p>
 * 输入：low = 2, high = 3, zero = 1, one = 2
 * 输出：5
 * 解释：好字符串为 "00" ，"11" ，"000" ，"110" 和 "011" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= low <= high <= 105
 * 1 <= zero, one <= low
 *
 * @author: ZBL
 * @date: 2024-11-04  19:13
 */
public class Code2466 {

    private final Integer MOD = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int sum = 0;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i < zero && i < one) {
                continue;
            }
            if (i >= zero) {
                dp[i] = dp[i - zero];
            }
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % MOD;
            }
            if (i >= low) {
                sum = (sum + dp[i]) % MOD;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code2466().countGoodStrings(3,3,1,1));
    }
}
