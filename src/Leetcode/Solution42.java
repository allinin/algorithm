package Leetcode;

import java.util.Stack;

/**
 * @author zbl
 * @version 1.0
 * @content:给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/14 21:38
 */
public class Solution42 {
    //单调栈解法
    public static int trap(int[] height) {
        if(height==null || height.length==0)
            return 0;
        int len=height.length;
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> help=new Stack<>();
        int count=0;
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && height[i]>=height[stack.peek()]){
                int d=height[stack.pop()];
                if(!stack.isEmpty()){
                    int left=stack.peek();
                    int l=i-left-1;
                    int h=Math.min(height[left],height[i])-d;
                    count+=h*l;
                }

            }
            stack.push(i);
        }
        return count;
    }

    public static void main(String[] args) {
        int [] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
