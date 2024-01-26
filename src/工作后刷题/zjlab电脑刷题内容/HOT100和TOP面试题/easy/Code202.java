package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ZBL
 * @Date: 2023-12-26  13:49
 * <p>
 * 快乐数
 * <p>
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 */
public class Code202 {

    //如果不能转化成1，则一定会出现环的情况，此时可以考虑快慢指针
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                int tmp = n % 10;
                sum += tmp * tmp;
                n /= 10;
            }
            n = sum;
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    //TODO 针对可能存在的环：使用快慢指针
    public boolean isHappy2(int n) {
        int slow = n,fast = n;
        do{
            slow = process(slow);//慢指针走一步
            fast = process(fast);//快指针走两步
            fast = process(fast);
        } while(slow != fast);
        return fast == 1;
    }

    private int process(int n) {
        int sum = 0;
        while (n != 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new Code202().isHappy2(2));
    }
}
