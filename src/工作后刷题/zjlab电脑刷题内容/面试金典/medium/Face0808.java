package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-09  09:42
 * <p>
 * 有重复字符串的排列组合。
 * 编写一种方法，计算某字符串的所有排列组合。
 * <p>
 * 示例1:
 * <p>
 * 输入：S = "qqe"
 * 输出：["eqq","qeq","qqe"]
 * 示例2:
 * <p>
 * 输入：S = "ab"
 * 输出：["ab", "ba"]
 * 提示:
 * <p>
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 */
public class Face0808 {

    List<String> res = new ArrayList<>();

    public String[] permutation(String S) {
        boolean[] visited = new boolean[S.length()];
        char[] chs = S.toCharArray();
        Arrays.sort(chs);
        process(chs, visited, new StringBuilder());
        return res.toArray(new String[0]);
    }

    private void process(char[] chs, boolean[] visited, StringBuilder sb) {
        if (chs.length == sb.length()) {
            res.add(new String(sb));
            return;
        }
        for (int i = 0; i < chs.length; i++) {
            if (i < chs.length - 1 && chs[i + 1] == chs[i] && visited[i + 1]) {
                continue;
            }
            if(visited[i]) {
                continue;
            }

            visited[i] = true;
            sb.append(chs[i]);

            process(chs, visited, sb);

            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
