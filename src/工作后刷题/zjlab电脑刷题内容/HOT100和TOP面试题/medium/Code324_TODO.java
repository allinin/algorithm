package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2023-12-29  14:43
 * <p>
 * 摆动序列II
 * <p>
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 * <p>
 * <p>
 * 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 */
public class Code324_TODO {

    public void wiggleSort(int[] nums) {

        int[] help = new int[nums.length];
        for(int i = 0;i < nums.length;i++) {
            help[i] = nums[i];
        }
        Arrays.sort(help);
        int idx = help.length - 1;
        //尽可能分散开
        for(int i = 1;i < nums.length;i+=2) {
            nums[i] = help[idx--];
        }
        for(int i = 0;i < nums.length;i+=2) {
            nums[i] = help[idx--];
        }

    }
    // TODO  进阶实现
    public void wiggleSort2(int[] nums) {

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,5,6};
        new Code324_TODO().wiggleSort(nums);
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }
}
