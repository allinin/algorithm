package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二分.easy;

/**
 * 正整数和负整数的最大计数 easy
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * <p>
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,-1,-1,1,2,3]
 * 输出：3
 * 解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [-3,-2,-1,0,0,1,2]
 * 输出：3
 * 解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 3：
 * <p>
 * 输入：nums = [5,20,66,1314]
 * 输出：4
 * 解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2000
 * -2000 <= nums[i] <= 2000
 * nums 按 非递减顺序 排列。
 * <p>
 * <p>
 * 进阶：你可以设计并实现时间复杂度为 O(log(n)) 的算法解决此问题吗？
 *
 * @author: ZBL
 * @date: 2024-09-19  20:38
 */
public class Code2529 {

    //相当于找出0第一次出现的位置及最后一次出现的位置
    public int maximumCount(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int negNum = 0, posNum = 0;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                // <= 0
                right = mid;
            }
        }
        if (left == nums.length || nums[left] != 0) {
            return Math.max(left, nums.length - left);
        }
        negNum = left;
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > 0) {
                right = mid - 1;
            } else {
                // <= 0;
                left = mid;
            }
        }
        if (nums[left] == 0) {
            posNum = nums.length - 1 - left;
        } else {
            posNum = nums.length - left;
        }


        return Math.max(negNum, posNum);
    }
}
