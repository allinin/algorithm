package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * <p>
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * 示例 2：
 * <p>
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * 示例 3：
 * <p>
 * 输入：s = ")("
 * 输出：[""]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 25
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 */
public class Code301 {
    Set<String> res = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int deleteLeftNum = 0,deleteRightNum = 0;
        int num = 0;
        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) == '(') {
                num++;
            } else if(s.charAt(i) == ')') {
                num--;
            }
            if (num < 0) {
                deleteRightNum++;
                num++;
            }
        }
        deleteLeftNum = num;

        process(s,deleteLeftNum,deleteRightNum,new StringBuilder(),0,0);

        return new ArrayList<>(res);
    }

    private void process(String s,int deleteLeftNum,int deleteRightNum,StringBuilder sb,int i,int num) {
        if (deleteLeftNum == 0 && deleteRightNum == 0 && i == s.length() && num == 0) {
            res.add(new String(sb));
            return;
        }
        if(num < 0 || deleteLeftNum < 0 || deleteRightNum < 0 || i >= s.length()) {
            return;
        }

        if(s.charAt(i) == '(') {
            sb.append(s.charAt(i));
            process(s,deleteLeftNum,deleteRightNum,sb,i + 1,num + 1);
            //回溯
            sb.deleteCharAt(sb.length() - 1);

            //删除当前值
            process(s,deleteLeftNum - 1,deleteRightNum,sb,i + 1,num);
        } else if(s.charAt(i) == ')') {

            sb.append(s.charAt(i));
            process(s,deleteLeftNum,deleteRightNum,sb,i + 1,num - 1);
            //回溯
            sb.deleteCharAt(sb.length() - 1);
            //删除当前值
            process(s,deleteLeftNum,deleteRightNum - 1,sb,i + 1,num);

        } else {
            sb.append(s.charAt(i));
            process(s,deleteLeftNum,deleteRightNum,sb,i + 1,num);
            //这里也需要回溯
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new Code301().removeInvalidParentheses(")(f"));
    }

}
