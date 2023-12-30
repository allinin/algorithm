package Leetcode;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zbl
 * @Date:2023/12/24 18:58
 * <p>
 * 至多包含k个不同字符的最长字串
 * <p>
 * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 * 示例 1:
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 则 T 为 "ece"，所以长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 则 T 为 "aa"，所以长度为 2。
 */
public class Solution340 {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() <= k) {
            return s.length();
        }
        int left = 0, right = 0, n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int num = 0;
        while (right < n) {
            char c = s.charAt(right++);
            if (!map.containsKey(c)) {
                num++;
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (num > k) {
                char sc = s.charAt(left++);
                map.put(sc, map.get(sc) - 1);
                if (map.get(sc) == 0) {
                    map.remove(sc);
                    num--;
                }
            }

            if (num <= k) {
                ans = Math.max(ans, right - left);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(lengthOfLongestSubstringKDistinct("aa",2));
    }
}
