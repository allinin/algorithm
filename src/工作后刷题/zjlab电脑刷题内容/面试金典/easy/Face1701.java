package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-16  09:56
 * 不用加号的加法
 *
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 */
public class Face1701 {
    public int add(int a, int b) {
        int carry = 0;
        int ans = 0;
        for(int i = 0;i < 32;i++) {
            int a1 = (a >> i) & 1;
            int b1 = (b >> i) & 1;
            int sum = a1 + b1 + carry;
            ans |= (sum % 2) << i;
            carry = sum / 2;
        }
        return ans;
    }
}
