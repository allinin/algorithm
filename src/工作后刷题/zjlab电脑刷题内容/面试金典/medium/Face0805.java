package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-09  09:13
 * 递归乘法。
 * 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = 1, B = 10
 * 输出：10
 * 示例2:
 * <p>
 * 输入：A = 3, B = 4
 * 输出：12
 * 提示:
 * <p>
 * 保证乘法范围不会溢出
 */
public class Face0805 {
    public int multiply(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }
        int ans = 0;
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        while (min > 0) {
            if ((min & 1) == 1) {
                ans += max;
                min = min & (min - 1);
            }
            if (min > 0) {
                max = max << 1;
                min = min >> 1;
            }
        }
        return ans;
    }
}
