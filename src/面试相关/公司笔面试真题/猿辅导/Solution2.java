package 面试相关.公司笔面试真题.猿辅导;

import java.util.Stack;

/**
 * @author zbl
 * @version 1.0
 * @content:2.给定一个数组，求另一个数组是否为该数组的栈输出序列。

 * @date 2020/8/26 21:53
 */
public class Solution2 {

    public static boolean process(int[] arr1,int[] arr2){
        if(arr1.length!=arr2.length)
            return false;
        Stack<Integer> stack=new Stack<>();
        int index=0;
        for(int i=0;i<arr1.length;i++){
            stack.push(arr1[i]);
            while(!stack.isEmpty() && stack.peek()==arr2[index]){
                stack.pop();
                index++;
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }

}
