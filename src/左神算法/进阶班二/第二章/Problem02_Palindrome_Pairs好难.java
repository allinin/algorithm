package 左神算法.进阶班二.第二章;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 链表words中都是不同的词，如果其中str1加str2之后是回文串，
则str1的位置和str2的位置我们需要收集。
比如
words = ["bat", "tab", "cat"]
返回[[0, 1], [1, 0]]
words = ["abcd", "dcba", "lls", "s", "sssll"]
返回[[0, 1], [1, 0], [3, 2], [2, 4]]
 * @date 2020/2/17 15:21
 */
public class Problem02_Palindrome_Pairs好难 {

    public static List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> wordset = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordset.put(words[i], i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            res.addAll(findAll(words[i], i, wordset));
        }
        return res;
    }

    public static List<List<Integer>> findAll(String word, int index, HashMap<String, Integer> words) {
        List<List<Integer>> res = new ArrayList<>();
        int[] rs = manacherrs(word);
        String reverse = reverse(word);
        Integer rest = words.get("");
        if (rest != null && rest != index && word.equals(reverse)) {
            addRecord(res, rest, index);
            addRecord(res, index, rest);
        }
        int mid = rs.length >> 1;
        for (int i = 1; i < mid; i++) {
            if (i - rs[i] == -1) {
                rest = words.get(reverse.substring(0, mid - i));
                if (rest != null && rest != index) {
                    addRecord(res, rest, index);
                }
            }
        }
        for (int i = mid + 1; i < rs.length; i++) {
            if (i + rs[i] == rs.length) {
                rest = words.get(reverse.substring((mid << 1) - i));
                if (rest != null && rest != index) {
                    addRecord(res, index, rest);
                }
            }
        }
        return res;
    }

    public static void addRecord(List<List<Integer>> res, int left, int right) {
        List<Integer> newr = new ArrayList<>();
        newr.add(left);
        newr.add(right);
        res.add(newr);
    }

    public static int[] manacherrs(String word) {
        char[] mchs = manachercs(word);
        int[] rs = new int[mchs.length];
        int center = -1;
        int pr = -1;
        for (int i = 0; i != mchs.length; i++) {
            rs[i] = pr > i ? Math.min(rs[(center << 1) - i], pr - i) : 1;
            while (i + rs[i] < mchs.length && i - rs[i] > -1) {
                if (mchs[i + rs[i]] != mchs[i - rs[i]]) {
                    break;
                }
                rs[i]++;
            }
            if (i + rs[i] > pr) {
                pr = i + rs[i];
                center = i;
            }
        }
        return rs;
    }

    public static char[] manachercs(String word) {
        char[] chs = word.toCharArray();
        char[] mchs = new char[chs.length * 2 + 1];
        int index = 0;
        for (int i = 0; i != mchs.length; i++) {
            mchs[i] = (i & 1) == 0 ? '#' : chs[index++];
        }
        return mchs;
    }

    public static String reverse(String str) {
        char[] chs = str.toCharArray();
        int l = 0;
        int r = chs.length - 1;
        while (l < r) {
            chs[l] ^= chs[r];
            chs[r] ^= chs[l];
            chs[l++] ^= chs[r--];
        }
        return String.valueOf(chs);
    }

    public static void main(String[] args) {
        String [] strs=new String[]{"bat", "tab", "cat"};
        List<List<Integer>> lists = palindromePairs(strs);
        System.out.println(lists.size());
    }
}
