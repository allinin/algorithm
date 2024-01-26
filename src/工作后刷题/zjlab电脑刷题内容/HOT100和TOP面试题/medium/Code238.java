package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * <p>
 * <p>
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 */
public class Code238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                left[0] = 1;
                right[n - 1] = 1;
            } else if (i == n - 1) {
                right[0] = nums[1] * right[1];
                left[i] = nums[i - 1] * left[i - 1];
            } else {
                left[i] = nums[i - 1] * left[i - 1];
                right[n - i - 1] = nums[n - i] * right[n - i];
            }
        }
        int[] ans = new int[n];
        for(int i = 0;i < n;i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1,1,0,-3,3};
        int[] ints = new Code238().productExceptSelf(nums);
        for(int i : ints) {
            System.out.print(i + " ");
        }
    }
}
