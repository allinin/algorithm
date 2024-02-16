package 工作后刷题.zjlab电脑刷题内容.分类刷题合集.单调栈.medium;

import java.util.Stack;

/**
 * @Author:zbl
 * @Date:2024/2/7 17:57
 * 132模式(medium)
 * 给你一个整数数组nums，数组中共有n个整数。132模式的子序列由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
 * 并同时满足：i<j<k和nums[i]<nums[k]<nums[j]。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 2 * 105
 * -109 <= nums[i] <= 109
 */
public class Code456_DONE {

    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                min = Math.max(min, stack.pop());
            }

            stack.push(nums[i]);
        }
        return false;
    }
}
