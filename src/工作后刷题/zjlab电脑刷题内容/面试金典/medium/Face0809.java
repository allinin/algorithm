package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-09  10:10
 * <p>
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Face0809 {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        process(0,0,new StringBuilder(),n);
        return res;
    }

    private void process(int left, int right, StringBuilder sb, int n) {
        if (left == n && right == n) {
            res.add(new String(sb));
            return;
        }
        if (right > left) {
            return;
        }
        char[] chs = {'(', ')'};
        for (char c : chs) {
            if (c == '(' && left < n) {
                sb.append(c);
                process(left + 1, right, sb, n);
                sb.deleteCharAt(sb.length() - 1);
            } else if (c == ')' && right < n) {
                sb.append(c);
                process(left, right + 1, sb, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
