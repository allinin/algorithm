package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-16  10:01
 * 消失的数字
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 *
 * 注意：本题相对书上原题稍作改动
 *
 * 示例 1：
 *
 * 输入：[3,0,1]
 * 输出：2
 *
 *
 * 示例 2：
 *
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 */
public class Face1704 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        //如果不消失数字，0-n的和
        int sum = n * (n + 1) / 2;
        for(int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
