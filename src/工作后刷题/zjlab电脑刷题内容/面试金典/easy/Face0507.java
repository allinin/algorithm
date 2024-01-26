package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-08  10:56
 *
 * 配对交换。
 * 编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 *
 * 示例1:
 *
 *  输入：num = 2（或者0b10）
 *  输出 1 (或者 0b01)
 * 示例2:
 *
 *  输入：num = 3
 *  输出：3
 * 提示:
 *
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 */
public class Face0507 {

    public int exchangeBits(int num) {
        int ans = 0;
        for(int i = 0;i < 32;i += 2) {
            int tmp1 = num & (1 << i);
            int tmp2 = num &(1 << (i + 1));
            ans |= (tmp1 << 1);
            ans |= (tmp2 >> 1);
        }
        return ans;
    }
}
