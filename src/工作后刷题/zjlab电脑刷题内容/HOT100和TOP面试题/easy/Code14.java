package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class Code14 {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        char now = ' ';
        int idx = 0;
        while (true) {
            for (String str : strs) {
                if (str.length() < idx + 1) {
                    return res.toString();
                } else {
                    char c = str.charAt(idx);
                    if (now == ' ') {
                        now = c;
                    } else {
                        if (c != now) {
                            return res.toString();
                        }
                    }
                }
            }
            res.append(now);
            idx++;
            now = ' ';
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code14().longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
