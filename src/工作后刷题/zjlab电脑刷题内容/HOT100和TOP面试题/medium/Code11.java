package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 乘最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 *
 * 提示：
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class Code11 {
    public int maxArea(int[] height) {
        int len = height.length,ans = 0;
        int left = 0,right = len - 1;
        while (left < right) {
            //选取左右区间端点中的较小值进行计算，同时移动选取的小端点
            ans = Math.max(ans,(right - left)
                    * (height[left] < height[right]
                    ? height[left++] : height[right--]));
        }
        return ans;
    }
}
