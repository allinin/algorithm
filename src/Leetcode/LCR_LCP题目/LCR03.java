package Leetcode.LCR_LCP题目;

/**
 * @Author:zbl
 * @Date:2023/12/30 19:34
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 *
 *
 *
 * 示例 1:
 *
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2:
 *
 * 输入: n = 5
 * 输出: [0,1,1,2,1,2]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 *
 * 说明 :
 *
 * 0 <= n <= 105
 *
 *
 * 进阶:
 *
 * 给出时间复杂度为 O(n*sizeof(integer)) 的解答非常容易。但你可以在线性时间 O(n) 内用一趟扫描做到吗？
 * 要求算法的空间复杂度为 O(n) 。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount ）来执行此操作。
 */
public class LCR03 {

    //最低有效位，即num中1的数量 = num去除最低有效位后的数字中的1的数量+1
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 1;i <= n;i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }
    //最高有效位，即num中1的数量 = num去除最高有效位后的数字中的1的数量+1
    public int[] countBits2(int n) {
        int[] ans = new int[n + 1];
        int hightBit = 0;
        for(int i = 1;i <= n;i++) {
            //成立则说明此时i的二进制中只有一个1
            if( (i & (i - 1)) == 0) {
                hightBit = i;
            }
            ans[i] = ans[i - hightBit] + 1;
        }
        return ans;
    }
}
