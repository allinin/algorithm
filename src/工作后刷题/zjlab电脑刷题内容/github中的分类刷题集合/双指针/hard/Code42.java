package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.双指针.hard;

/**
 * 接雨水（hard)
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 * 提示：
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 * @author: ZBL
 * @date: 2024-09-06  20:10
 */
public class Code42 {

    //方法一前后缀数组的方式
    public int trap(int[] height) {
        int len = height.length,ans = 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];
        for(int i = 1;i < len;i++) {
            leftMax[i] = Math.max(leftMax[i - 1],height[i]);
        }
        for(int i = len - 2;i >= 0;i--) {
            rightMax[i] = Math.max(rightMax[i + 1],height[i]);
        }
        for(int i = 1;i < len - 1;i++) {
            ans += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return ans;
    }
    //方法二:双指针
    public int trap2(int[] height) {
        int ans = 0,left = 0,right = height.length - 1;
        //分别表示left及以作的最大值，right及以右的最大值
        int leftMax = 0,rightMax = 0;
        while(left < right) {
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            //如果leftMax < rightMax，则计算 left位置能够盛放的水，同时移动left,反之亦然
            ans += leftMax < rightMax ? leftMax - height[left++] : rightMax - height[right--];
        }
        return ans;
    }
}
