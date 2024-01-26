package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * 柱状图中的最大矩形
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入： heights = [2,4]
 * 输出： 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 */
public class Code84 {

    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        if (heights == null || heights.length == 0) {
            return ans;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];//记录i位置左边第一个比i小的元素的位置
        int[] right = new int[n];//记录i位置右边第一个比i小的元素的位置
        Arrays.fill(right, n - 1);
        Arrays.fill(left, 0);
        for (int i = 0; i < n; i++) {
            while (!stack1.isEmpty() && heights[stack1.peek()] > heights[i]) {
                Integer pop = stack1.pop();
                right[pop] = i - 1;
            }
            stack1.push(i);
            while (!stack2.isEmpty() && heights[stack2.peek()] > heights[n - i - 1]) {
                Integer pop = stack2.pop();
                left[pop] = n - i;
            }
            stack2.push(n - i - 1);
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] + 1));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(new Code84().largestRectangleArea(height));
    }
}
