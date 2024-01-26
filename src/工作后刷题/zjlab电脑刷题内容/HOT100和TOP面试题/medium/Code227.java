package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.Stack;

/**
 * @Author: ZBL
 * @Date: 2023-12-28  14:24
 * 基本计算器II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * <p>
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 */
public class Code227 {

    //即772题基本计算器III的简单实现，代码参考224中的calculateIII
    public int calculate(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        char preAction = ' ';
        int num = 0, sum = 0;
        while (idx < n) {
            char c = s.charAt(idx++);
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                if (preAction== ' ') {
                    stack.push(num);
                } else {
                    if (preAction == '-') {
                        stack.push(num * (-1));
                    } else if (preAction == '+') {
                        stack.push(num);
                    } else if (preAction == '*') {
                        Integer preNum = stack.pop();
                        stack.push(preNum * num);
                    } else if (preAction == '/') {
                        Integer preNum = stack.pop();
                        stack.push(preNum / num);
                    }
                }
                preAction = c;
                num = 0;
            }
        }
        if (preAction != ' ') {
            if (preAction == '-') {
                stack.push(num * (-1));
            } else if (preAction == '+') {
                stack.push(num);
            } else if (preAction == '*') {
                Integer preNum = stack.pop();
                stack.push(preNum * num);
            } else if (preAction == '/') {
                Integer preNum = stack.pop();
                stack.push(preNum / num);
            }
        }else {
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }



    public static void main(String[] args) {
        System.out.println(new Code227().calculate(" 3+5/2 "));
    }
}
