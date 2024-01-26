package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-08  14:47
 * 魔术索引。
 * 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * 给定一个有序整数数组，编写一种方法找出魔术索引，
 * 若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * 示例2:
 * <p>
 * 输入：nums = [1, 1, 1]
 * 输出：1
 * 说明:
 * <p>
 * nums长度在[1, 1000000]之间
 * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
 */
public class Face0803 {
    public int findMagicIndex(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    private int process(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            if (nums[left] == left) {
                return left;
            }
            return -1;
        }
        int mid = left + (right - left) / 2;
        int leftAns = process(nums, left, mid);
        if (leftAns == -1) {
            return process(nums, mid + 1, right);
        }
        return leftAns;
    }
}
