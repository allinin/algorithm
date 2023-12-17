package Leetcode;

import java.util.*;

public class Solution395 {

    public static int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        int n = s.length();
        int[] help = new int[26];
        for (char c : s.toCharArray()) {
            help[c - 'a']++;
        }
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
            if (!set.contains(c)) {
                Set<Character> target = new HashSet<>();
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    Character key = entry.getKey();
                    Integer val = entry.getValue();
                    if (val >= k) {
                        target.add(key);
                    }
                }
                if (target.size() != 0){
                    int end = left;
                    Map<Character,Integer> helpMap = new HashMap<>();
                    while (end < right) {
                        char leftC = s.charAt(end++);
                        if(!target.contains(leftC)) {
                            helpMap.clear();
                            left = end;
                        } else {
                            helpMap.put(leftC,helpMap.getOrDefault(leftC,0) + 1);
                            long num = helpMap.values().stream().filter(p -> p < k).count();
                            if(num == 0) {
                                ans = Math.max(ans,end - left);
                            }
                        }
                    }
                }
                left = right;
                map.clear();
            } else {
                map.put(c, map.getOrDefault(c, 0) + 1);
                long num = map.values().stream().filter(p -> p < k).count();
                if (num == 0) {
                    ans = Math.max(ans, right - left);
                }
            }
        }

        Set<Character> target = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (val >= k) {
                target.add(key);
            }
        }
        if (target.size() != 0){
            int end = left;
            Map<Character,Integer> helpMap = new HashMap<>();
            while (end < right) {
                char leftC = s.charAt(end++);
                if(!target.contains(leftC)) {
                    helpMap.clear();
                    left = end;
                } else {
                    helpMap.put(leftC,helpMap.getOrDefault(leftC,0) + 1);
                    long num = helpMap.values().stream().filter(p -> p < k).count();
                    if(num == 0) {
                        ans = Math.max(ans,end - left);
                    }
                }
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        System.out.println(longestSubstring("cbcbbaaa",3));
    }
}
