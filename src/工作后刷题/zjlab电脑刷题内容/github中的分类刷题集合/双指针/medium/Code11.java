package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.双指针.medium;

/**
 * 盛最多水的容器(medium)
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 *
 * @author: ZBL
 * @date: 2024-09-06  19:28
 */
public class Code11 {
    public int maxArea(int[] height) {
        int len = height.length;
        int ans = 0, left = 0, right = len - 1;
        while (left < right) {
            int value = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans, value);
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                //相等
                left++;
                right--;
            }
        }
        return ans;
    }
}
