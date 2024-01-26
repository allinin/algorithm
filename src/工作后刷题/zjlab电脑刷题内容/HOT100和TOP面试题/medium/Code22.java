package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
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
 */
public class Code22 {

    private String[] help = new String[]{"(",")"};
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        process(n,0,0,new StringBuilder(),ans);
        return ans;
    }

    private void process(int n,int left,int right,StringBuilder sb,List<String> res) {
        if(left == right && left == n) {
            res.add(new String(sb));
            return;
        }
        if(right > left || left > n || right > n) {
            return;
        }
        for(int i = 0;i < 2;i++) {
            sb.append(help[i]);
            if("(".equals(help[i])) {
                process(n,left + 1,right,sb,res);
            } else {
                process(n,left,right + 1,sb,res);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Code22().generateParenthesis(3);
        strings.forEach(p -> System.out.println(p));
    }
}
