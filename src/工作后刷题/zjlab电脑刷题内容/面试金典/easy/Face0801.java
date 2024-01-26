package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-08  13:43
 * 三步问题。
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * 示例2:
 * <p>
 * 输入：n = 5
 * 输出：13
 * 提示:
 * <p>
 * n范围在[1, 1000000]之间
 */
public class Face0801 {

    private static Integer MOD = 1000000007;

    public static int waysToStep(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int prePrePre = 1, prePre = 2, pre = 4;
        int ans = 0;
        for (int i = 4; i <= n; i++) {
            ans = ((prePrePre + prePre) % MOD + pre) % MOD;
            prePrePre = prePre;
            prePre = pre;
            pre = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(waysToStep(61));
    }
}
