package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.单调队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值 hard
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * @author: ZBL
 * @date: 2024-10-25  19:47
 */
public class Code239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int idx = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);

            if(i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            //i在第k -1及之后开始计算最大值
            if (i >= k - 1) {
                ans[idx++] = nums[deque.peekFirst()];
            }

        }
        return ans;
    }
}
