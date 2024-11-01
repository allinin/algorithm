package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.回溯.子集型;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串 medium
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
 * 回文串
 * 。返回 s 所有可能的分割方案。
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
 *
 * @author: ZBL
 * @date: 2024-11-01  19:37
 */
public class Code131 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        process(s,0,new ArrayList<>());
        return res;
    }

    private void process(String s, int start, List<String> list) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isHuiWen(s, start, i)) {
                list.add(s.substring(start, i + 1));
                process(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    boolean isHuiWen(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
