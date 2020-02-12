package 左神算法.高频面试题.五;

/**
 * @author zbl
 * @version 1.0
 * @content: 机器人走路问题。一排有N个位置，一个机器人在最开始停留在P位置上，如果p==0位置，下一分钟机器人一定向左移动到1位置，如果p==N-1,
 * 下一分钟，机器人一定向左移动到p=N-2位置。如果p在0和N-1之间，下一分钟机器人一定会向左或者右移动。求k分钟的时候，机器人到达T位置有多少种走法。
 *
 * @date 2020/1/6 12:32
 */
public class Problem5 {

    public static int f1(int N, int p, int k, int t) {
        if (N < 2 || k < 1 || p < 0 || t >= N || t < 0 || p >= N) {
            return 0;
        }
        if (k == 1)
            return p == t ? 1 : 0;
        if (t == 0)

            return f1(N, p, k - 1, 1);
        if (t == N - 1)
            return f1(N, p, k - 1, t - 1);

        return f1(N, p, k - 1, t - 1) + f1(N, p, k - 1, t + 1);
    }

    //使用二维数组的动态规划
    public static int f2(int N, int p, int k, int t) {
        if (N < 2 || k < 1 || p < 0 || t >= N || t < 0 || p >= N) {
            return 0;
        }
        int[][] dp = new int[k][N];
        dp[0][p] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][N - 1] = dp[i - 1][N - 2];
            for (int j = 1; j < dp[0].length - 1; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
            }
        }
        return dp[k - 1][t];
    }

    //使用一个以为数组实现动态规化
    public static int f3(int n, int p, int k, int t) {
        if (n < 2 || k < 1 || p < 0 || t >= n || t < 0 || p >= n) {
            return 0;
        }
        int[] dp = new int[n];
        dp[p] = 1;
        int temp = 0;
        int pre = 0;
        for (int i = 1; i < k; i++) {
            pre = dp[0];
            dp[0] = dp[1];
            for (int j = 1; j < n - 1; j++) {
                temp = dp[j];
                dp[j] = pre + dp[j + 1];
                pre = temp;
            }
            dp[n - 1] = pre;
        }
        return dp[t];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3000000; i++) {
            int N = (int) (Math.random() * 5) + 5;
            int P = (int) (Math.random() * N);
            int K = (int) (Math.random() * 10) + 2;
            int T = (int) (Math.random() * N);
            int res1 = f1(N, P, K, T);
            int res2 = f2(N, P, K, T);
            int res3 = f3(N, P, K, T);
            if (res1 != res2 || res1 != res3) {
                System.out.println("Fuck man!");
                break;
            }
        }

    }
}
