package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.easy;

/**
 * 移动零
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
 */
public class Code283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int left = 0, right = 0; //left记录非零部分的下一个索引,right记录当前的遍历位置
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums,left,right);
                left++;
            }
            right++;

        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,12};
        new Code283().moveZeroes(nums);
        for(int num : nums) {
            System.out.print(num + " ");
        }

    }

}
