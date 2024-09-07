package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.双指针.medium;

import java.util.Arrays;

/**
 *
 * 611. 有效三角形的个数 medium
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 示例 2:
 *
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * @Author:zbl
 * @Date:2024/9/7 17:37
 */
public class Code611 {

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        if(nums.length < 3) {
            return ans;
        }
        for(int i = 2;i < nums.length;i++) {
            int left = 0,right = i - 1;
            while(left < right) {
                if(nums[left] + nums[right] > nums[i]) {
                    ans += right - left;
                    right--;
                } else if(nums[left] + nums[right] <= nums[i]) {
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,3,4};
        System.out.println(triangleNumber(nums));
    }
}
