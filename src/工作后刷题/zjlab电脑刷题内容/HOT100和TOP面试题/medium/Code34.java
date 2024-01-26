package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class Code34 {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] {-1,-1};
        if(nums == null || nums.length == 0) {
            return ans;
        }
        int len = nums.length;
        int left = 0,right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if(nums[left] != target) {
            return ans;
        }
        ans[1] = left;
        left = 0;
        right = len;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) {
                right = mid;
            } else {
               left = mid + 1;
            }
        }
        ans[0] = left;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] ints = new Code34().searchRange(nums, 12);
        for(int n :ints) {
            System.out.println(n);
        }
    }
}
