package ZUOSHEN.进阶班.单调栈;

import ZUOSHEN.第四课.MadianQuick;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 * @author zbl
 * @version 1.0
 * @content: 求最大子矩阵的大小
 * 给定一个整型矩阵map,其中的值只有0和1两种，求其中全是1的所有矩形区域中，最大的矩形区域为1的数量
 * 例如：1 0 1 1
 *       1 1 1 1
 *       1 1 1 0
 *       其中最大的矩形区域有6个1，返回6
 * @date 2019/12/31 11:21
 */
public class MaximalRectange {


    public static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    //如果一个数组代表直方图，利用单调栈找到其中最大的矩形的过程
    public static int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <=height[stack.peek()]) {
                int j = stack.pop();//j位置的矩形
                int k = stack.isEmpty() ? -1 : stack.peek();//弹出来的数的左边界
                int curArea = (i - k - 1) * height[j];//一个数从栈中弹出，计算能组成的相应的矩形
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {//栈中剩余的元素结算
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();//左边界;
            int curArea = (height.length - k - 1) * height[j];//栈中剩余元素的右边界，统一为数组的边界
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] map = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 }, };
        System.out.println(maxRecSize(map));
    }
}
