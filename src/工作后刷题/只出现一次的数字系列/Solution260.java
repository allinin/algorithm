package 工作后刷题.只出现一次的数字系列;

/**
 * @Author:zbl
 * @Date:2024/1/8 20:53
 *
 * 只出现一次的数字III (medium)
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 *
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 示例 3：
 *
 * 输入：nums = [0,1]
 * 输出：[1,0]
 */
public class Solution260 {

    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int help = 0;
        for(int num : nums) {
            help ^= num;
        }

        //当前help = 缺失的两个数字的异或和
        int help2 = help & (-help); // 获得help二进制表示中的最后一位1，缺失的两个数字在这个1对应的位上一定是一个是0，一个是1
        //可以根据这个二进制1的位置将上述中的2n-2个数分成两组
        for(int num : nums) {
            if((num & help2) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}
