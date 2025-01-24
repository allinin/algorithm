package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.链表;

/**
 * 寻找重复数 medium
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 示例 3 :
 * <p>
 * 输入：nums = [3,3,3,3,3]
 * 输出：3
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如何证明 nums 中至少存在一个重复的数字?
 * 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
 *
 * @Author:zbl
 * @Date:2024/12/8 15:09
 */
public class Code287 {

    // 循环链表类似做法在数组中的使用

    public int findDuplicate(int[] nums) {
        //类似环形链表的做法
        int len = nums.length;
        int slow = 0, fast = 0; // 相当于循环链表中的快慢指针初始化
        do {
            slow = nums[slow]; // 慢指针每次走一步
            fast = nums[nums[fast]]; //快指针每次走两步
        } while (slow != fast);
        fast = 0; //快指针放到开头
        while (fast != slow) { // 快慢指针都每次走1步，重合的时候就既是重复出现的值
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
