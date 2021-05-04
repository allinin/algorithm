package 面试相关.公司笔面试真题.猿辅导;

import java.util.Stack;

/**
 * @author zbl
 * @version 1.0
 * @content:一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，
 * 只许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 * @date 2020/9/2 20:33
 */
public class Solution4 {

    public static  void stackSort(Stack<Integer> stack){
        if(stack.isEmpty() || stack.size()<2) return;
        Stack<Integer> help=new Stack<>();
        while(!stack.isEmpty()){
            int num=stack.pop();
            while(!help.isEmpty() && help.peek()<num){
                stack.push(help.pop());
            }
            help.push(num);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }




}
