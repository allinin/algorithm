package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-05  13:58
 * 插入
 * <p>
 * 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
 * <p>
 * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。
 * <p>
 * <p>
 * <p>
 * 题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 * 输出：N = 1100(10001001100)
 * 示例2:
 * <p>
 * 输入： N = 0, M = 31(11111), i = 0, j = 4
 * 输出：N = 31(11111)
 */
public class Face0501 {

    public static int insertBits(int N, int M, int i, int j) {

        for (int k = i; k <= j; k++) {
            int targetNum = (M & (1 << (k - i)));
            if (targetNum != 0) {
                N |= (targetNum << i);
            } else {
                N &= ~(1 << k);
            }
        }
        return N;
    }

    public static void main(String[] args) {
        System.out.println(insertBits(1024,19,2,6));
    }
}
