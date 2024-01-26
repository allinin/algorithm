package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中的字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
public class Code438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] help = new int[26];
        int valid = 0;
        for (char c : p.toCharArray()) {
            if (help[c - 'a'] == 0) {
                valid++;
            }
            help[c - 'a']++;
        }
        int left = 0, right = 0, m = s.length(), num = 0;
        int[] help2 = new int[26];
        while (right < m) {
            char c = s.charAt(right++);
            if (++help2[c - 'a'] == help[c - 'a']) {
                num++;
            }
            while (num == valid) {
                if (right - left == p.length()) {
                    res.add(left);
                }
                if (left < right) {
                    char tmp = s.charAt(left++);
                    help2[tmp - 'a']--;
                    if (help2[tmp - 'a'] < help[tmp - 'a']) {
                        num--;
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Code438().findAnagrams("abab", "ab"));
    }
}
