package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 *
 * 提示：
 *
 * 1 <= n <= 45
 */
public class Code70 {

    public int climbStairs(int n) {
        if(n <= 3) {
            return n;
        }
        int pre = 3,prepre = 2,now = 0;
        for(int i = 4;i <= n;i++) {
            now = pre + prepre;
            prepre = pre;
            pre = now;
        }
        return now;
    }

    public static void main(String[] args) {
        System.out.println(new Code70().climbStairs(10));
    }
}
