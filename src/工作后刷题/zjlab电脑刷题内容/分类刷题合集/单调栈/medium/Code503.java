package 工作后刷题.zjlab电脑刷题内容.分类刷题合集.单调栈.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author:zbl
 * @Date:2024/2/7 17:55
 * 下一个更大元素II(MEDIUM)
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * <p>
 * 数字 x的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 */
public class Code503 {


    //二刷
    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                Integer pop = stack.pop();
                if (ans[pop] == -1) {
                    ans[pop] = nums[i % n];
                }
            }
            stack.push(i % n);
        }
        return ans;
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                Integer idx = stack.pop() % n;
                if (ans[idx] == -1) {
                    ans[idx] = nums[i % n];
                }
            }
            stack.push(i % n);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 3};
        int[] nums = new Code503().nextGreaterElements2(arr);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
