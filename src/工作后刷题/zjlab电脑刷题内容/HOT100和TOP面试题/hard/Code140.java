package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

import java.util.*;

/**
 * @Author: ZBL
 * @Date: 2023-12-22  14:34
 * <p>
 * 单词拆分II
 * <p>
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 * <p>
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * 输出:["cats and dog","cat sand dog"]
 * 示例 2：
 * <p>
 * 输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * 输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * 输出:[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中所有字符串都 不同
 */
public class Code140 {

    List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        //先判断s能否拆分
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];//表示从i——末尾的子串能否拆分
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (set.contains(s.substring(i, j)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if(dp[0]) {
            process(s, 0, wordDict, new ArrayList<>(),dp);
        }
        return res;
    }

    private void process(String s, int start, List<String> wordDict, List<String> list,boolean[] dp) {
        if (start == s.length()) {
            res.add(String.join(" ", list));
            return;
        }
        for (String word : wordDict) {
            int len = word.length();
            if (start + len > s.length()) {
                continue;
            }
            if (s.substring(start, start + len).equals(word) && dp[start]) {
                list.add(word);
                process(s, start + len, wordDict, list,dp);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> list = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> list1 = new Code140().wordBreak(s, list);
        for (String str : list1) {
            System.out.println(str);
        }
    }
}
