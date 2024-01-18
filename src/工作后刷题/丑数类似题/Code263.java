package 工作后刷题.丑数类似题;

/**
 * @Author:zbl
 * @Date:2024/1/15 22:08
 * <p>
 * 丑数(easy)
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * <p>
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。
 * 示例 3：
 * <p>
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 */
public class Code263 {

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                return false;
            }
        }
        return true;
    }
}