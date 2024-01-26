package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-08  10:53
 *
 * 整数转换。
 * 编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 *
 * 示例1:
 *
 *  输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 *  输出：2
 * 示例2:
 *
 *  输入：A = 1，B = 2
 *  输出：2
 * 提示:
 *
 * A，B范围在[-2147483648, 2147483647]之间
 */
public class Face0506 {

    public int convertInteger(int A, int B) {
        int ans = 0;
        for(int i = 0;i < 32;i++) {
            int tmp1 = A & (1 << i);
            int tmp2 = B & (1 << i);
            if(tmp2 != tmp1) {
                ans++;
            }
        }
        return ans;
    }
}
