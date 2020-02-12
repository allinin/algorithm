package 左神算法.高频面试题;

import java.util.Stack;

/**
 * @author zbl
 * @version 1.0
 * @content: 一个栈依次压入1,2,3,4,5，那么从栈顶到栈底分别为5,4,3,2,1.实现栈中元素的逆序，从栈顶到栈底为1,2,3,4,5，但是只能用递归函数实现，不能用其他数据结构
 * @date 2019/12/28 10:14
 */
public class ReverseStackUsingRecursive {


    //实现stack的逆序
    public static void reverse(Stack<Integer> stack){

        if(stack.isEmpty())
        {
            return;
        }
        int value=getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(value);
    }

    //获取栈中最后一个元素
    public static int getAndRemoveLastElement(Stack<Integer>stack)
    {
        int num=stack.pop();
        if(stack.isEmpty())
        {
            return num;
        }else{
            int last=getAndRemoveLastElement(stack);
            stack.push(num);
            return last;
        }
    }
}
