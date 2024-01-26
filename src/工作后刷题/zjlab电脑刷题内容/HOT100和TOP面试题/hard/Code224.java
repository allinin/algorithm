package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;


import java.util.Stack;

/**
 * @Author: ZBL
 * @Date: 2023-12-28  15:40
 * <p>
 * 基本计算器 (772基本计算器III,即在该题的基础上变为了+-* /并且数值都是非负整数)
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * 输入中不存在两个连续的操作符
 * 每个数字和运行的计算将适合于一个有符号的 32位 整数
 */
public class Code224 {

    //基本计算器
    public int calculate(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int ans = 0, idx = 0;
        char preAction = ' ';
        while (idx < n) {
            char c = s.charAt(idx++);
            if (c == ' ') {
                continue;
            }
            if (c == '-' || c == '+') {
                preAction = c;
            } else if (Character.isDigit(c)) {
                int num = c - '0';
                while (idx < n && Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + s.charAt(idx++) - '0';
                }

                if (preAction == '-') {
                    ans -= num;
                } else {
                    ans += num;
                }
            } else {
                //遇到(
                int[] tmpAns = process(s, idx);
                if (preAction != '-') {
                    ans += tmpAns[0];
                } else {
                    ans -= tmpAns[0];
                }

                idx = tmpAns[1];
            }
        }
        return ans;
    }

    //返回当前括号中的计算结果及下一个位置
    private int[] process(String s, int idx) {
        int[] ans = new int[2];
        char preAction = ' ';
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (c == ' ') {
                continue;
            }
            if (c == '-' || c == '+') {
                preAction = c;
            } else if (Character.isDigit(c)) {
                int num = c - '0';
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + s.charAt(idx++) - '0';
                }

                if (preAction == '-') {
                    ans[0] -= num;
                } else {
                    ans[0] += num;
                }
            } else if (c == '(') {
                //遇到(
                int[] tmpAns = process(s, idx);
                if (preAction != '-') {
                    ans[0] += tmpAns[0];
                } else {
                    ans[0] -= tmpAns[0];
                }
                idx = tmpAns[1];
            } else {
                //遇到了)
                ans[1] = idx;
                break;
            }
        }
        return ans;
    }

    //基本计算器III,在基本计算器的基础上变为了+-*/并且数值都是非负整数
    public int calculateIII(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int ans = 0, idx = 0;
        Stack<Integer> stack = new Stack<>(); //因为*/需要用到前面的值，所以需要用stack保存之前出现的值
        char preAction = ' ';
        while (idx < n) {
            char c = s.charAt(idx++);
            if (c == ' ') {
                continue;
            }
            if (c == '-' || c == '+' || c == '*' || c == '/') {
                preAction = c;
            } else if (Character.isDigit(c)) {
                int num = c - '0';
                while (idx < n && Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + s.charAt(idx++) - '0';
                }

                if (preAction == ' ' || preAction == '+') {
                    stack.push(num);
                } else if (preAction == '-') {
                    stack.push(num * (-1));
                } else if (preAction == '*') {
                    stack.push(stack.pop() * num);
                } else if (preAction == '/') {
                    stack.push(stack.pop() / num);
                }
            } else {
                //遇到(
                int[] tmpAns = processIII(s, idx);
                if (preAction == ' ' || preAction == '+') {
                    stack.push(tmpAns[0]);
                } else if (preAction == '-') {
                    stack.push(tmpAns[0] * (-1));
                } else if (preAction == '*') {
                    stack.push(stack.pop() * tmpAns[0]);
                } else if (preAction == '/') {
                    stack.push(stack.pop() / tmpAns[0]);
                }
                idx = tmpAns[1];
            }
        }
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    //返回当前括号中的计算结果及下一个位置
    private int[] processIII(String s, int idx) {
        int[] ans = new int[2];
        Stack<Integer> stack = new Stack<>();
        char preAction = ' ';
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (c == ' ') {
                continue;
            }
            if (c == '-' || c == '+' || c == '*' || c == '/') {
                preAction = c;
            } else if (Character.isDigit(c)) {
                int num = c - '0';
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + s.charAt(idx++) - '0';
                }

                if (preAction == ' ' || preAction == '+') {
                    stack.push(num);
                } else if (preAction == '-') {
                    stack.push(num * (-1));
                } else if (preAction == '*') {
                    stack.push(stack.pop() * num);
                } else if (preAction == '/') {
                    stack.push(stack.pop() / num);
                }
            } else if (c == '(') {
                //遇到(
                int[] tmpAns = processIII(s, idx);
                if (preAction == ' ' || preAction == '+') {
                    stack.push(tmpAns[0]);
                } else if (preAction == '-') {
                    stack.push(tmpAns[0] * (-1));
                } else if (preAction == '*') {
                    stack.push(stack.pop() * tmpAns[0]);
                } else if (preAction == '/') {
                    stack.push(stack.pop() / tmpAns[0]);
                }
                idx = tmpAns[1];
            } else {
                //遇到了)
                ans[1] = idx;
                break;
            }
        }
        while (!stack.isEmpty()) {
            ans[0] += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Code224().calculate(" 1-(     -2) "));
        System.out.println(2147483647 == Integer.MAX_VALUE);
        System.out.println(new Code224().calculateIII(" (2+6* 3+5- (3*14/7+2)*5)+3 "));


    }
}
