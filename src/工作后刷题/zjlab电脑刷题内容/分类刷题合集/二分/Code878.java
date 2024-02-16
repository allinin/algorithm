package 工作后刷题.zjlab电脑刷题内容.分类刷题合集.二分;

/**
 * @Author: ZBL
 * @Date: 2024-01-30  09:12
 * 第N个神奇数字(hard)
 * 一个正整数如果能被 a 或 b 整除，那么它是神奇的。
 * <p>
 * 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 109 + 7 取模 后的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1, a = 2, b = 3
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 4, a = 2, b = 3
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * 2 <= a, b <= 4 * 104
 */
public class Code878 {

    private static final int MOD = 1000000007;

    //二分答案
    public int nthMagicalNumber(int n, int a, int b) {
        long min = 1l, max = 4 * 10000000000000l;
        while (min < max) {
            long mid = min + (max - min) / 2;
            if (check(mid, a, b, n)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return (int) (min % MOD);
    }

    private boolean check(long target, int a, int b, int n) {
        return target / a + target / b - target / lcm(a, b) >= n;
    }

    //求最大公约数
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    //求最小公倍数
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}
