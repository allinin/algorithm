package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.easy;

/**
 * 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= x, y <= 231 - 1
 */
public class Code461 {

    public int hammingDistance(int x, int y) {
        int ans = 0;
        if (x == y) {
            return ans;
        }
        for (int i = 0; i < 32; i++) {
            int help = 1 << i;
            if ((x & help) != (y & help)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Code461().hammingDistance(1,4));
    }
}
