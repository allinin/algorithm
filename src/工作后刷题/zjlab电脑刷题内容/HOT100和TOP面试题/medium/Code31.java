package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 下一个排列
 *
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class Code31 {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = n - 1;
        //找到目标位置:即从右往左第一个不再满足升序位置的数
        while(index > 0 && nums[index] <= nums[index - 1] ) {
            index--;
        }
        if(index == 0) {
            swap(nums,index,n - 1);
        } else {
            int targetIndex = index - 1;
            index = n - 1;
            //从末尾开始找，找到第一个大于targeIndex位置的数
            while(nums[index] <= nums[targetIndex]) {
                index--;
            }
            //targetIndex位置的数跟从右边起第一个大于概数的数交换位置
            int tmp = nums[targetIndex];
            nums[targetIndex] = nums[index];
            nums[index] = tmp;
            //交换后建targetIndex + 1位置到末尾位置的数依次交换位置(当前是降序排序，交换后是升序，数字最小)
            swap(nums,targetIndex + 1,n - 1);
        }

    }

    private void swap(int[] nums,int left,int right) {
        while(left < right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,3,2,2};
        new Code31().nextPermutation(test);
        for(int i = 0;i < test.length;i++) {
            System.out.println(test[i]);
        }

    }
}
