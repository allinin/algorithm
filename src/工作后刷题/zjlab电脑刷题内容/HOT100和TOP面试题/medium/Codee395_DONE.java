package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * <p>
 * 如果不存在这样的子字符串，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 * <p>
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 */
public class Codee395_DONE {

    //双指针
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        int n = s.length();
        int[] help = new int[26];
        for (char c : s.toCharArray()) {
            help[c - 'a']++;
        }
        //记录可能符合要求的字符
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (help[i] >= k) {
                set.add((char) ('a' + i));
            }
        }
        int ans = 0, left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < n) {
            char c = s.charAt(right++);
            //碰到不符合的字符时，计算当前遍历子串结果
            if (!set.contains(c)) {
                int res = process(map, s, left, right, k);
                left = right;
                map.clear();
                ans = Math.max(ans, res);
            } else {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return Math.max(ans, process(map, s, left, right, k));
    }

    //分治法:如果某个字符c出现次数小于k,那么最终结果值一定是某个不包含c的字串，也就是包含c的
    //子串一定不是最终结果值所对应的子串
    public int longestSubstring2(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        return dfs(s, 0, s.length() - 1, k);

    }

    private int dfs(String s, int start, int end, int k) {
        if (end - start + 1 < k) {
            return 0;
        }
        int[] help = new int[26];
        for (int i = start; i <= end; i++) {
            help[s.charAt(i) - 'a']++;
        }
        char split = 0;
        for (int i = 0; i < 26; i++) {
            //注意这里要>0，保证当前字符出现过
            if (help[i] < k && help[i] > 0) {
                split = (char) ('a' + i);
                break;
            }
        }
        //不存在出现次数小于k的字符
        if (split == 0) {
            return end - start + 1;
        }
        int idx = start;
        int ans = 0;
        while (idx <= end) {
            //如果当前字符时分割字符，则继续遍历
            while (idx <= end && s.charAt(idx) == split) {
                idx++;
            }
            if (idx > end) {
                break;
            }
            int newStart = idx;
            while (idx <= end && s.charAt(idx) != split) {
                idx++;
            }
            int tmp = dfs(s, newStart, idx - 1, k);
            ans = Math.max(ans, tmp);
        }
        return ans;

    }


    public int longestSubstring3(String s, int k) {
        if(s == null || s.length() < k) {
            return 0;
        }
        int len = s.length();
        return dfs2(s,0,len - 1,k);
    }

    private int dfs2(String s,int left,int right,int k) {

        if(left > right || right - left + 1 < k) {
            return 0;
        }

        int[] help = new int[26];
        for(int i = left;i <= right;i++) {
            help[s.charAt(i) - 'a']++;
        }
        char split = 0;
        int idx = left;
        for(int i = left;i <= right;i++) {
            //说明i位置的字符出现的次数小于k,则,则最终结果子串一定不包含i位置的字符
            if (help[s.charAt(i) - 'a'] < k) {
                split = (char)('a' + i);
                idx = i;
                break;
            }
        }
        if(split == 0) {
            return right - left + 1;
        }
        int tmp1 = dfs(s,left,idx - 1,k);
        int tmp2 = dfs(s,idx + 1,right,k);
        return Math.max(tmp1,tmp2);
    }

    public static void main(String[] args) {
        System.out.println(new Codee395_DONE().longestSubstring2("baaabcd",3));
    }

    private int process(Map<Character, Integer> map, String s, int left, int right, int k) {
        int ans = 0;//ans[0]:当前记录结果，ans[1]:计算后left的位置
        //筛选出数量符合要求的字符
        Set<Character> target = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (val >= k) {
                target.add(key);
            }
        }
        //当前子串中存在符合的字符
        if (target.size() != 0) {
            int end = left;
            //记录当前遍历的字符及出现的次数
            Map<Character, Integer> helpMap = new HashMap<>();
            while (end < right) {
                char leftC = s.charAt(end++);
                if (!target.contains(leftC)) {
                    helpMap.clear();
                    left = end;
                } else {
                    helpMap.put(leftC, helpMap.getOrDefault(leftC, 0) + 1);
                    long num = helpMap.values().stream().filter(p -> p < k).count();
                    if (num == 0) {
                        ans = Math.max(ans, end - left);
                    }
                }
            }
        }
        map.clear();
        return ans;
    }

}
