package 工作后刷题.zjlab电脑刷题内容.二分题目合集.第k大小.medium;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2023-12-28  09:30
 * <p>
 * 找出第k小的数对距离(hard)
 * <p>
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1], k = 1
 * 输出：0
 * 解释：数对和对应的距离如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 距离第 1 小的数对是 (1,1) ，距离为 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1,6,1], k = 3
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 2 <= n <= 104
 * 0 <= nums[i] <= 106
 * 1 <= k <= n * (n - 1) / 2
 */
public class Code719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check1(mid, k, nums)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    //方法一：二分判断
    private boolean check1(int target, int k, int[] nums) {
        int sum = 0;
        int left = 0;
        while (left < nums.length) {
            int tmp = left;
            int right = nums.length - 1;

//            while (right > left) {
//                if (nums[right] - nums[left] > target) {
//                    right--;
//                } else {
//                    sum += (right - left);
//                    break;
//                }
//            }
            //再次二分,找出符合要求的最右端点
            while(tmp < right) {
                int mid = tmp + (right - tmp + 1) / 2;
                if(nums[mid] - nums[left] > target) {
                    right = mid - 1;
                } else {
                    tmp = mid;
                }
            }
            sum +=(right - left);
            left++;
        }
        return sum >= k;
    }
    //方法二：双指针判断
    private boolean check2(int target, int k, int[] nums) {
        int sum = 0;
        for(int i = 0,j = 0;j < nums.length;j++) {
            while(nums[j] - nums[i] > target) {
                i++;
            }
            sum += j - i;
        }
        return sum >= k;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,6,1};
        System.out.println(new Code719().smallestDistancePair(arr,3));
    }

}
