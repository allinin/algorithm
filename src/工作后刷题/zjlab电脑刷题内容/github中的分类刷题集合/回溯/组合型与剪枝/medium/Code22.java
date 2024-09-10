package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.回溯.组合型与剪枝.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成 medium
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 * 提示：
 *
 * 1 <= n <= 8
 * @author: ZBL
 * @date: 2024-09-09  19:23
 */
public class Code22 {

    char[] help = new char[]{'(',')'};

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        process(n,new StringBuffer(),0,0);
        return res;
    }

    private void process(int targetNum,StringBuffer sb,int leftNum,int rightNum) {
        if(leftNum == targetNum && rightNum == targetNum) {
            res.add(new String(sb));
            return;
        }

        for(char c : help) {
            if(c == '(' && leftNum < targetNum) {
                sb.append(c);
                process(targetNum,sb,leftNum + 1,rightNum);
                sb.deleteCharAt(sb.length() - 1);
            } else if(c == ')' && rightNum < leftNum) {
                sb.append(c);
                process(targetNum,sb,leftNum,rightNum + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
