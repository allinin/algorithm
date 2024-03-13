package 工作后刷题.zjlab电脑刷题内容.二分题目合集.二分答案.medium;

/**
 * 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 *
 *
 * 进阶：
 *
 * 如何证明 nums 中至少存在一个重复的数字?
 * 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
 */
public class Code287_DONE {

    public int findDuplicate(int[] nums) {
        int left = 1,right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            //统计小于中点的元素数量
            for(int num : nums) {
                if(num <= mid) {
                    count++;
                }
            }
            //如果小于等于中点元素的数量大于中点元素，说明重复数组出现在中点及以左
            if(count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    // floyd圈，类似找循环链表的入口节点
    public int findDuplicate2(int[] nums) {
        int slow = 0,fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,4,4,3};

        System.out.println(new Code287_DONE().findDuplicate(arr));
    }
}
