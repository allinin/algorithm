package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * <p>
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的 商 。
 * <p>
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 */
public class Code29 {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor == 1) {
                return dividend;
            }

        }

        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            } else {
                return 0;
            }
        }
        if (divisor == Integer.MAX_VALUE) {
            if (dividend == Integer.MAX_VALUE) {
                return 1;
            } else if (dividend == Integer.MIN_VALUE) {
                return -1;
            }
            return 0;
        }
        if (divisor == 1 || divisor == -1) {
            return divisor == 1 ? dividend : dividend * (-1);
        }
        //是否是负数,
        boolean flag = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = true;
        }
        //TODO 注意点：为了防止溢出，二者全部转化为负数
        dividend = dividend > 0 ? -dividend  : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int ans = 0;
        while(dividend <= divisor) {
            int tmp1 = dividend;
            int tmp2 = divisor;
            int index = 1;
            while (tmp2 >= (Integer.MIN_VALUE >> 1) && tmp1 <= tmp2 << 1) {
                tmp2 <<= 1;
                index <<= 1;
            }
            ans += index;
            dividend -= tmp2;
        }
        return flag ? -ans : ans;
    }

    public static void main(String[] args) {
        System.out.println(new Code29().divide(Integer.MIN_VALUE,3));
    }
}
