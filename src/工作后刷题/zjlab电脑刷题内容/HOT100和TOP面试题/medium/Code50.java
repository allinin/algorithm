package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * @Author: ZBL
 * @Date: 2023-12-18  16:25
 * <p>
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * <p>
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n 是一个整数
 * 要么 x 不为零，要么 n > 0 。
 * -104 <= xn <= 104
 */
public class Code50 {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean flag = n < 0;
        long num = flag ? (long)n * (-1) : n;
        double muladd = 1d;
        while (num > 1) {
            if ((num & 1) == 1) {
                muladd *= x;
            }
            num /= 2;
            x *= x;
        }
        return flag ? 1 / (x * muladd) : x * muladd;
    }

    public static void main(String[] args) {
        System.out.println(new Code50().myPow(2, -2147483648));
    }
}
