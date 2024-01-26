package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2023-12-26  13:50
 * <p>
 * 计数质数
 * <p>
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 5 * 106
 */
public class Code204_DONE {

    public int countPrimes(int n) {
        int ans = 0;
        boolean[] dp = new boolean[n];
        Arrays.fill(dp,true);
        //如果i为质数，则i的整数倍一定不再是质数
        for(int i = 2;i < n;i++) {
            if(dp[i]) {
                ans++;
            }
            if((long)i * (long)i < n) {
                //这里不需要从j = i*2开始，因为之前已经处理了
                for(int j = i * i;j < n;j += i) {
                    dp[j] = false;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Code204_DONE().countPrimes(10000));
    }
}
