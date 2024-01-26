package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2023-12-21  10:57
 * <p>
 * 分割回文串
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class Code131 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        process(s,0,new ArrayList<>());
        return res;
    }

    private void process(String s, int start, List<String> list) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(match(s,start,i)) {
                list.add(s.substring(start,i + 1));
                process(s,i + 1,list);
                list.remove(list.size() - 1);
            }
        }
    }
    //match方法的作用可以提前预处理，即dp[i][j]记录i - j的子串是否是回文串
    private boolean match(String s,int start,int end) {
        while (start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = new Code131().partition("adfefeab");
        for(List<String> list : res) {
            for(String str : list) {
                System.out.print(str +" ");
            }
            System.out.println();
        }
    }

}
