package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-02  09:19
 * <p>
 * 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：n = 45
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= n <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能不使用循环或者递归来完成本题吗？
 */
public class Code326 {

    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
