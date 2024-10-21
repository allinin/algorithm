package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二分.medium;

/**
 * 在排序数组中查找元素的第一个和最后一个位置 medium
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * @author: ZBL
 * @date: 2024-09-19  20:30
 */
public class Code34_注意 {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};

        if (nums == null || nums.length == 0) {
            return ans;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // >= target
                right = mid;
            }
        }
        if (nums[left] != target) {
            return ans;
        }
        ans[0] = left;
        left = 0;
        right = nums.length - 1;
        //TODO 这种求最后一次出现的位置，当元素不存在时，返回的index不是正确的位置，如数组为1,2,4,6.target = 5的情况下，返回的index = 2,只有先求第一次出现的位置，再求最后一次出现的位置才有意义，结合2476中的注释来看
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // <= target
                left = mid;
            }
        }
        ans[1] = left;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,6};
        int target = 8;
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // >= target
                right = mid;
            }
        }
        System.out.println(left);
    }
}
