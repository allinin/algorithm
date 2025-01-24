package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.双指针;

/**
 * 移动零 easy
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能尽量减少完成的操作次数吗？
 *
 * @Author:zbl
 * @Date:2024/12/8 15:05
 */
public class Code283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = -1, right = 0; // right 表示当前遍历的位置，left表示当前不是0的最后位置
        while (right < len) {
            if (nums[right] == 0) {
                right++;
            } else {
                swap(nums, ++left, right++);
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
