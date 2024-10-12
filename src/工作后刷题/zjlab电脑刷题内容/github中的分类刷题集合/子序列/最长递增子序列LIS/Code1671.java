package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.子序列.最长递增子序列LIS;

/**
 *
 * 得到山形数组的最少删除次数 hard
 * 我们定义 arr 是 山形数组 当且仅当它满足：
 *
 * arr.length >= 3
 * 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且：
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 给你整数数组 nums​ ，请你返回将 nums 变成 山形状数组 的​ 最少 删除次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,1]
 * 输出：0
 * 解释：数组本身就是山形数组，所以我们不需要删除任何元素。
 * 示例 2：
 *
 * 输入：nums = [2,1,1,5,6,2,3,1]
 * 输出：3
 * 解释：一种方法是将下标为 0，1 和 5 的元素删除，剩余元素为 [1,5,6,3,1] ，是山形数组。
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * 1 <= nums[i] <= 109
 * 题目保证 nums 删除一些元素后一定能得到山形数组。
 * @Author:zbl
 * @Date:2024/10/7 7:40
 */
public class Code1671 {
    public int minimumMountainRemovals(int[] nums) {
        int ans = Integer.MAX_VALUE;
        return ans;
    }
}
