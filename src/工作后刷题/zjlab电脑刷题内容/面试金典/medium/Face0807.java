package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-09  09:35
 * <p>
 * 无重复字符串的排列组合。
 * 编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * <p>
 * 示例1:
 * <p>
 * 输入：S = "qwe"
 * 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 示例2:
 * <p>
 * 输入：S = "ab"
 * 输出：["ab", "ba"]
 * 提示:
 * <p>
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 */
public class Face0807 {
    List<String> res = new ArrayList<>();

    public String[] permutation(String S) {
        boolean[] visited = new boolean[S.length()];
        process(S,visited,new StringBuilder());
        return res.toArray(new String[0]);
    }

    private void process(String s, boolean[] visited, StringBuilder sb) {
        if (sb.length() == s.length()) {
            res.add(new String(sb));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited[i]) {
                continue;
            }
            sb.append(c);
            visited[i] = true;

            process(s, visited, sb);

            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
