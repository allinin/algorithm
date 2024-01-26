package 工作后刷题.zjlab电脑刷题内容.二分查找.二分答案.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-19  08:57
 * 丑数III
 * 给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。
 *
 * 丑数是可以被 a 或 b 或 c 整除的 正整数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, a = 2, b = 3, c = 5
 * 输出：4
 * 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
 * 示例 2：
 *
 * 输入：n = 4, a = 2, b = 3, c = 4
 * 输出：6
 * 解释：丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
 * 示例 3：
 *
 * 输入：n = 5, a = 2, b = 11, c = 13
 * 输出：10
 * 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
 * 示例 4：
 *
 * 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
 * 输出：1999999984
 *
 *
 * 提示：
 *
 * 1 <= n, a, b, c <= 10^9
 * 1 <= a * b * c <= 10^18
 * 本题结果在 [1, 2 * 10^9] 的范围内
 */
public class Code1201 {

    //二分查找，注意最小公倍数存在可能超过int范围的情况
    public int nthUglyNumber(int n, int a, int b, int c) {
        int left = 1,right = 2000000000;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(check(mid,n,a,b,c)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int target,int num,int a,int b,int c) {
        long sum = 1l * target / a + 1l * target / b +
                1l * target / c - 1l * target / lcm(a,b) - 1l * target / lcm(b,c) - 1l * target / lcm(a,c) +
                1l * target / lcm(a,lcm(b,c));
        return sum >= num;
    }

    //求最大公约数
    private long gcm(long a,long b) {
        return b == 0 ? a : gcm(b,a%b);
    }

    //最小公倍数(有可能超过int的范围）
    private long lcm(long a,long b) {
        return 1l * a * b / gcm(a,b);
    }
}
