package 公司真题;

import java.util.Stack;

/**
 * @author zbl
 * @version 1.0
 * @content:
 *

给出一个布尔表达式的字符串，比如：true or false and false，表达式只包含true，false，and和or，现在要对这个表达式进行布尔求值，计算结果为真时输出true、为假时输出false，不合法的表达时输出error（比如：true true）。表达式求值是注意and 的优先级比 or 要高，比如：true or false and false，等价于 true or (false and false)，计算结果是 true。

输入描述:

输入第一行包含布尔表达式字符串s，s只包含true、false、and、or几个单词（不会出现其它的任何单词），且单词之间用空格分隔。 (1 ≤ |s| ≤ 103).


输出描述:

输出true、false或error，true表示布尔表达式计算为真，false表示布尔表达式计算为假，error表示一个不合法的表达式。


输入例子1:

and


输出例子1:

error


输入例子2:

true and false


输出例子2:

false


输入例子3:

true or false and false


输出例子3:

true


 * @date 2020/3/27 18:27
 */
public class Exercise {

    public static String process(String str){
        if(str==null)
            return "error";
        if("true".equals(str)) return "true";
        if("false".equals(str)) return "false";
        if("and".equals(str) || "or".equals(str))
            return "error";
        String[] chs=str.split(" ");
        int len=chs.length;
        if((len &1)==0)
            return "error";

        Stack<String>stack1=new Stack<>();
        Stack<String>stack2=new Stack<>();
        for(int i=0;i<len;i++){
            if((i&1)==0)
                if(chs[i].equals("and") || chs[i].equals("or"))
                    return "error";
            if((i&1)==1){
                if(chs[i-1].equals("and") || chs[i-1].equals("or")|| chs[i+1].equals("and") || chs[i+1].equals("or"))
                    return "error";
            }
        }
        stack1.push(chs[0]);
        for(int i=1;i<len;i+=2){

            if(chs[i].equals("and")){
                String temp=(stack1.pop().equals("true") && chs[i+1].equals("true"))?"true":"false";
                stack1.push(temp);
            }else{
                stack2.push(chs[i]);
                stack1.push(chs[i+1]);
            }
        }
        while(!stack1.isEmpty()){
            String temp1=stack1.pop();
            String temp2=!stack1.isEmpty() ? stack1.pop():null;
            if(temp2!=null){
                if(temp1.equals("true") || temp2.equals("true"))
                    return "true";
            }else{
                return temp1;
            }
        }
        return "false";
    }

    public static void main(String[] args) {
        String str="true and true or false or false";
        System.out.println(process(str));
    }

}
