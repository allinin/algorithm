package 面试相关.公司笔面试真题.猿辅导;

import java.util.Stack;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个二叉搜索树，并给出他的前序序列，输出中序序列，时间复杂度O(n)
 * @date 2020/8/24 20:49
 */
public class Solution1 {

    //利用单调栈，栈中元素从大到小排列

    public static int[] process(int[] arr){
        if(arr==null || arr.length==0)
            return new int[0];
        if(arr.length==1) return arr;
        int n=arr.length;
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();
        int index=0;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek()<arr[i]){
                res[index++]=stack.pop();
            }
            stack.push(arr[i]);
        }

        while(!stack.isEmpty()){
            res[index++]=stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={5,2,1,3,7,6,8};
        int[] res=process(arr);
        for(int num :res){
            System.out.println(num);
        }
    }

}
