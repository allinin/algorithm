package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.滑动窗口;

import 左神算法.进阶班一.前缀树应用.Max_EOR好题;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串 hard
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
 *
 * @author: ZBL
 * @date: 2024-09-09  09:19
 */
public class Code76 {
    public static String minWindow(String s, String t) {
        if (s == null || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tStatisticMap = new HashMap<>();
        String ans = "";
        int minLen = Integer.MAX_VALUE;
        for (char c : t.toCharArray()) {
            tStatisticMap.put(c, tStatisticMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> map = new HashMap<>();
        int validCount = 0, left = 0, right = 0, len = s.length();
        while (right < len) {
            char c = s.charAt(right++);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c).equals(tStatisticMap.getOrDefault(c, 0))) {
                validCount++;
            }
            while (validCount == tStatisticMap.size()) {
                if (minLen > right - left) {
                    minLen = right - left;
                    ans = s.substring(left, right);
                }
                char r = s.charAt(left++);
                map.put(r, map.get(r) - 1);
                if (tStatisticMap.getOrDefault(r,0) > map.get(r)) {
                    validCount--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
