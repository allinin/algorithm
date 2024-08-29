package 工作后刷题.zjlab电脑刷题内容.背包问题;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分(medium)
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅由小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 *
 * @author: ZBL
 * @date: 2024-08-29  19:42
 */
public class Code139 {

    //需要考虑元素的顺序：即组合背包问题,同时是true or false问题
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[][] dp = new boolean[wordDict.size() + 1][s.length() + 1];
        for (int i = 0; i <= wordDict.size(); i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= wordDict.size(); j++) {
                dp[j][i] |= dp[j - 1][i];
                if (wordDict.get(j - 1).length() <= i) {
                    if (s.substring(i - wordDict.get(j - 1).length(), i).equals(wordDict.get(j - 1))) {
                        dp[j][i] |= dp[j - 1][i] | dp[wordDict.size()][i - wordDict.get(j - 1).length()];
                    }
                }
            }
        }
        return dp[wordDict.size()][s.length()];
    }

    //一维的解法
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
               if(set.contains(s.substring(j,i))) {
                   dp[i] |= dp[j];
               }
            }
        }
        return dp[s.length()];
    }
}
