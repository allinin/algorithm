package 左神算法.进阶班二.第五章;

import java.util.Stack;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 爱编程的小易发现，当自己代码中的括号较多时，如果括号未
成对出现，或者出现的顺序错误，他的编辑器 总是能立马给出
错误提示。好奇的小易决定自己尝试实现该功能。 对于一行代
码(字符串)，里面可能出现大括号"{}"、中括号"[]"和小括号
"()"，请编程判断该行代码的括号嵌 套是否正确。
"()","({})","print ('Hello Netease')"等都是括号的正确使
用方法，"(]","print (Hello Netease]"则是错误的范例
 * @date 2020/2/24 16:02
 */
public class Code_01_Valid_Expression {

    public static boolean isValid(String str){
        char[] chs=str.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<chs.length;i++){
            if(chs[i]=='(' || chs[i]=='[' || chs[i]=='{')
                stack.push(chs[i]);
            if(chs[i]==')' || chs[i]==']' || chs[i]=='}'){
                char match=chs[i]=='}'?'{':(chs[i]==']' ? '[':'(');
                if(stack.isEmpty() || !stack.pop().equals(match)){
                    return false;
                }

            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test = "{1+(2+3)+[(1+3)+(4*5)]}";
        System.out.println(isValid(test));
    }
}
