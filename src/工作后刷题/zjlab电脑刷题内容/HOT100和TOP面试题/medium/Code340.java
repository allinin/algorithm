package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZBL
 * <p>
 * * 至多包含k个不同字符的最长字串
 * * <p>
 * * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 * * 示例 1:
 * * 输入: s = "eceba", k = 2
 * * 输出: 3
 * * 解释: 则 T 为 "ece"，所以长度为 3。
 * * <p>
 * * 示例 2:
 * * 输入: s = "aa", k = 1
 * * 输出: 2
 * * 解释: 则 T 为 "aa"，所以长度为 2。
 * @date: 2025-02-10  18:31
 */
public class Code340 {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int ans = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, right++); //记录字符出现的最右侧位置
            if (map.size() <= k) {
                ans = Math.max(ans, right - left);
            } else {
                int min = Collections.min(map.values());
                map.remove(s.charAt(min));
                left = min + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("aaaaa",2));
    }
}
