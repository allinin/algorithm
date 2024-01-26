package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2024-01-02  10:15
 * <p>
 * 递增的三元子序列
 * <p>
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * 示例 2：
 * <p>
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * 示例 3：
 * <p>
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
 */
public class Code334 {

    //O(nlogn)
    public boolean increasingTriplet(int[] nums) {
        int[] help = new int[4];
        Arrays.fill(help, Integer.MAX_VALUE);
        help[1] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            int left = 1, right = len + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (help[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == len + 1) {
                help[left] = nums[i];
                len++;
                if (len == 3) {
                    return true;
                }
            } else {
                if (help[left] > nums[i]) {
                    help[left] = nums[i];
                }
            }
        }
        return false;
    }


    //O(n)实现
    public boolean increasingTriplet2(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int min1 = nums[0], min2 = Integer.MAX_VALUE;//分别代表长度为1的子序列的最小结尾，长度为2的子序列的最小结尾
        int idx = 1;
        while (idx < n) {
             if(nums[idx] > min2) {
                 return true;
             } else if(min1 < nums[idx] && nums[idx] < min2) {
                 min2 = nums[idx];
             } else if(min1 > nums[idx]){
                 min1 = nums[idx];
             }
             idx++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{20, 100, 10, 12, 5, 13};
        System.out.println(new Code334().increasingTriplet2(arr));
    }
}
