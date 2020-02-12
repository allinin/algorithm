package 左神算法.进阶班一.结构设计;

import java.util.LinkedList;

/**
 * @author zbl
 * @version 1.0
 * @content: 给你一个字符串str,str表示一个公式，公式里可能有整数，加减乘除和括号，返回公式的计算结果。可以认为给定的字符串一定是正确的公式。即不需要
 * //对str做公式有效性检查。
 * @date 2020/1/9 13:33
 */
public class ExpressionCompute {

    public static int getValue(String str) {
        return value(str.toCharArray(), 0)[0];
    }
    //返回值为数组，长度为2
    //arr[0]:表示我计算的结果
    //arr[1]：表示我计算到的位置
    public static int[] value(char[] str, int i) { //i表示计算str从i下标处开始的元素，知道遇到“)”或者字符串的末尾
        LinkedList<String> que = new LinkedList<String>();
        int pre = 0;
        int[] bra = null;
        while (i < str.length && str[i] != ')') {
            if (str[i] >= '0' && str[i] <= '9') {
                pre = pre * 10 + str[i++] - '0';
            } else if (str[i] != '(') { //遇到了加减乘除符号
                addNum(que, pre);
                que.addLast(String.valueOf(str[i++]));
                pre = 0;
            } else {//遇到了左括号
                bra = value(str, i + 1);
                pre = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(que, pre);
        return new int[] { getNum(que), i };//返回计算的结果以及，算到哪个位置了
    }

    //不带括号的算术表达式的计算过程。每个加入的数字以某个运算符号结尾在加入一个数字的时候，首先判断顶部的元素是否为乘除，如果是，则先弹出做计算,然后将计算的结果压入。
    public static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    public static int getNum(LinkedList<String> que) { //计算经过上面的方法处理后的表达值，只含有加减运算了
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num); //将加减号作为了运算数的符号
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String exp = "48*((70-65)-43)+8*1";
        System.out.println(getValue(exp));

        exp = "4*(6+78)+53-9/2+45*8";
        System.out.println(getValue(exp));

        exp = "10-5*3";
        System.out.println(getValue(exp));

        exp = "-3*4";
        System.out.println(getValue(exp));

        exp = "3+1*4";
        System.out.println(getValue(exp));

    }

}
