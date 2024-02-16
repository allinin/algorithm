package 工作后刷题.zjlab电脑刷题内容.分类刷题合集.单调栈.medium;

import java.util.Stack;

/**
 * @Author:zbl
 * @Date:2024/2/7 18:02
 * 最大宽度坡(medium)
 * 给定一个整数数组A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * <p>
 * 找出A中的坡的最大宽度，如果不存在，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 示例 2：
 * <p>
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 */
public class Code962_DONE {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length, ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        for (int i = n - 1; i >=0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                Integer top = stack.pop();
                ans = Math.max(ans, i - top);
            }
        }
        return ans;
    }
}
