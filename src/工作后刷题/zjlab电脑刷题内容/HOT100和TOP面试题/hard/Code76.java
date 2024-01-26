package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;


/**
 * 最小覆盖字串
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 * <p>
 * <p>
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 */
public class Code76 {

    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return "";
        }
        int[] helpT = new int[52];//盛放t中不同字符出现的次数,0-25存放A-Z,26-51存放a-z
        int charNum = 0;//t中不同字符的数量
        int index = 0;
        for (char c : t.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                index = c - 'A';
            } else {
                index = c - 'a' + 26;
            }
            if (helpT[index] == 0) {
                charNum++;
            }
            helpT[index]++;
        }
        //双指针遍历s,确定区间
        int left = 0, right = 0, validNum = 0,start = 0,len = Integer.MAX_VALUE;
        int[] helpS = new int[52];
        while (right < m) {
            char c = s.charAt(right++);
            if ('A' <= c && c <= 'Z') {
                index = c - 'A';
            } else {
                index = c - 'a' + 26;
            }
            helpS[index]++;
            if (helpS[index] == helpT[index] && helpT[index] != 0) {
                validNum++;
            }

            while (validNum == charNum) {
                if (len > right - left) {
                    len = right - left;
                    start = left;
                }
                char leftC = s.charAt(left++);
                if ('A' <= leftC && leftC <= 'Z') {
                    index = leftC - 'A';
                } else {
                    index = leftC - 'a' + 26;
                }
                if (--helpS[index] < helpT[index]) {
                    validNum--;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
    }

    public static void main(String[] args) {
        System.out.println(new Code76().minWindow("a","a"));
    }
}
