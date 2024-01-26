package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-11  14:45
 * 阶乘位数
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class Face1605 {

    //末尾0由2*5得来，其中1-n中2的数量是多余5的数量，所以查看可以拆分为5的数量即可
    public int trailingZeroes(int n) {
        int ans = 0;
        while(n != 0) {
            ans += n / 5;
            n = n / 5;
        }
        return ans;
    }
}
