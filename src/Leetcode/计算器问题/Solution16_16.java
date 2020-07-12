package Leetcode.计算器问题;

import java.util.Stack;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。

表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:

输入: "3+2*2"
输出: 7
示例 2:

输入: " 3/2 "
输出: 1
示例 3:

输入: " 3+5 / 2 "
输出: 5
说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/calculator-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/7/10 22:50
 */
public class Solution16_16 {

    public static int calculate(String s) {
        if(s==null || s.trim().length()==0)
            return 0;
        char[] chs=s.toCharArray();
        int index=0;
        Stack<Integer> stack=new Stack<>();
        int n=chs.length;
        while(index<n){
            if(chs[index]==' '){
                index++;
                continue;
            }
            char tmp=chs[index];
            if(tmp=='+' || tmp=='-' || tmp=='/' || tmp=='*'){
                index++;
                while(index<n && chs[index]==' ') index++;
            }
            int num=0;
            while(index<n && Character.isDigit(chs[index])){
                num=num*10+chs[index]-'0';
                index++;
            }
            if(tmp=='+'){
                stack.push(num);
            }else if(tmp=='-'){
                stack.push(-num);
            }else if(tmp=='/'){
                stack.push(stack.pop()/num);
            }else if(tmp=='*'){
                stack.push(stack.pop()*num);
            }else{
                stack.push(num);//当tmp不是运算符的时候
            }
        }
        int res=0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String s="1-1+1";
        System.out.println(calculate(s));
    }
}
