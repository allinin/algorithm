package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

/**
 * @Author: ZBL
 * @Date: 2023-12-18  16:22
 * <p>
 * 缺失的第一个正数
 * <p>
 * <p>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 */
public class Code41_DONE {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //缺失的正数的大小一定不会超过n + 1,将出现的负数统一设置为n+1，不会对最终的结果造成影响
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n && nums[num - 1] > 0) {
                //将num - 1位置的值标记为负数，表示num在原数组中出现过
                nums[num - 1] = nums[num - 1] * (-1);
            }
        }
        for (int i = 0; i < n; i++) {
            //nums[i] > 0说明i + 1没有出现过，正是缺失的第一个正数
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;

    }

    public static void main(String[] args) {
        System.out.println(new Code41_DONE().firstMissingPositive(new int[] {7,8,9,11,12}));
    }


}
