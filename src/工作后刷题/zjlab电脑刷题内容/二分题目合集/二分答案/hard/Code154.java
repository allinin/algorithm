package 工作后刷题.zjlab电脑刷题内容.二分题目合集.二分答案.hard;

/**
 * 寻找旋转排序数组中的最小值II(HARD)
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * 你必须尽可能减少整个过程的操作步骤。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,5]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 * <p>
 * <p>
 * 进阶：这道题与 寻找旋转排序数组中的最小值 类似，但 nums 可能包含重复元素。允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 *
 * @author: ZBL
 * @date: 2024-07-17  19:37
 */
public class Code154 {

    //求最大值
    public static int findMax(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //[left,mid]有序,最大值不会出现在mid及以左
            if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else if (nums[left] > nums[mid]) {
                //这种情况下最大值一定在[left,mid]范围
                right = mid;
            } else {
                //相等的情况下，缩减范围，保留mid即可
                left++;

            }
        }
        return nums[left];
    }

    /**
     * 求最小值
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //(mid,right]有序,且最小值不会出现在mid右边
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                //这种情况最小值一定在[mid + 1,right]的范围
                left = mid + 1;
            } else {
                //相等的情况下，缩减范围，保留mid即可
                right--;
            }
        }
        return nums[left];
    }

}
