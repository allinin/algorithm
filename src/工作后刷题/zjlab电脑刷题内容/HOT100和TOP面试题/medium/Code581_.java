package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 最短无序连续子数组
 *
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，
 * 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 */
public class Code581_ {

    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }
        //正常的有序非递减数组一定是从左到右非递减，从右往左非非递增的
        int start = -1,end = -1,min = Integer.MAX_VALUE,max = Integer.MIN_VALUE,n = nums.length;
        for(int i = 0;i < nums.length;i++) {
            //从前往后遍历，记录当前最大的数，如果后面的数小于当前最大数，移动end到当前位置
            if(nums[i] >= max) {
                max = nums[i];
            } else {
                end = i;
            }
            //从后向前遍历，记录当前最小的数，如果前面的数大于当前最小值，移动start到当前位置
            if(nums[n - 1 - i]  <= min) {
                min = nums[n - i - 1];
            } else {
                start = n - 1 -i;
            }
        }
        return start == -1 ? 0 : (end - start + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]  {2,6,4,8,10,9,15};
        System.out.println(new Code581_().findUnsortedSubarray(arr));
    }
}
