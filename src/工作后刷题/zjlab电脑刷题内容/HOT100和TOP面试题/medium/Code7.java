package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 */
public class Code7 {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int ans = 0;
        boolean flag = x >= 0;//是否是否正数
        x = Math.abs(x);
        while (x != 0) {
            int last = x % 10;
            x /= 10;
            if (flag && (ans > Integer.MAX_VALUE / 10
                    || (ans == Integer.MAX_VALUE / 10 && last >= Integer.MAX_VALUE % 10))) {
                return 0;
            } else if (!flag && (ans > Integer.MAX_VALUE / 10
                    || (ans == Integer.MAX_VALUE / 10 && last > Integer.MAX_VALUE % 10))) {
                return 0;
            } else {
                ans = ans * 10 + last;
            }
        }
        return flag ? ans : ans * (-1);
    }

    public static void main(String[] args) {
        System.out.println(new Code7().reverse(-333333345));
    }
}
