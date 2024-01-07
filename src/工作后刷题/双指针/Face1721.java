package 工作后刷题.双指针;

/**
 * @Author:zbl
 * @Date:2024/1/7 18:24
 * <p>
 * 接雨水题目的双指针实现 (hard)
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Face1721 {

    //接雨水双指针做法
    public int trap(int[] height) {
        int ans = 0, left = 0, right = height.length - 1, leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            //left位置右边的最大值一定会大于等于当前rightMax，所以left位置左边右边的最大值中的较小者即为当前的leftMax
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                //同理right位置左边的最大值一定会大于等于当前leftMax，所以left位置左边右边的最大值中的较小者即为当前的rightMax
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
