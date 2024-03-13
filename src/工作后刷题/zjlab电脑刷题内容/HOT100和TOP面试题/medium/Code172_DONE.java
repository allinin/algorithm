package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;


/**
 * @Author: ZBL
 * @Date: 2023-12-25  15:34
 * <p>
 * 阶乘后的0
 * <p>
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * <p>
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 104
 * <p>
 * <p>
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 */
public class Code172_DONE {

    //结尾是0，即求n!中质因子10的个数，10 = 2x5,所以求质因子5或者2的个数小的那个，
    // 而5的的个数小于2的个数，也就是求质因子5的个数
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int ans = 0;
        for(int i = 5;i <= n;i += 5) {
            for(int j = i;j % 5 == 0;j /= 5) {
                ans++;
            }
        }
        return ans;

    }
    public int trailingZeroes2(int n) {
        if (n < 5) {
            return 0;
        }
        int ans = 0;
        while(n != 0) {
            ans += n / 5;
            n /= 5;
        }
        return ans;

    }

    private static long help(int n) {
        if (n == 1) {
            return 1;
        }
        return n * help(n - 1);
    }

    public static void main(String[] args) {
        //System.out.println(help(15));
        System.out.println(new Code172_DONE().trailingZeroes2(625));

    }
}
