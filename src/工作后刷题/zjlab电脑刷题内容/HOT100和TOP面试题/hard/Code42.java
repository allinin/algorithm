package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * =================
 * 注意与Code11比较，两者题干具有类似性
 */
public class Code42 {
    public int trap(int[] height) {
        int ans = 0;
        if(height == null || height.length < 3) {
            return ans;
        }
        int len = height.length;
        //i及i以左的最大值
        int[] left = new int[len];
        //i及i以右的最大值
        int[] right = new int[len];
        left[0] = height[0];
        right[len - 1] = height[len - 1];
        for(int i = 1;i < len;i++) {
            left[i] = Math.max(left[i - 1],height[i]);
        }
        for(int i = len - 2;i >= 0;i--) {
            right[i] = Math.max(right[i + 1],height[i]);
        }
        for(int i = 0;i < len;i++) {
            ans += (Math.min(left[i],right[i]) - height[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Code42().trap(height));
    }
}
