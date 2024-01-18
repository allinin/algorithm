package 工作后刷题.dfs回溯;

import java.util.Arrays;

/**
 * @Author:zbl
 * @Date:2024/1/12 22:29
 * <p>
 * 最长单词
 * 给定一组单词words，编写一个程序，找出其中的最长单词，
 * 且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
 * <p>
 * 示例：
 * <p>
 * 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
 * 输出： "dogwalker"
 * 解释： "dogwalker"可由"dog"和"walker"组成。
 * 提示：
 * <p>
 * 0 <= len(words) <= 200
 * 1 <= len(words[i]) <= 100
 */
public class Face1715 {

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        //按照长度从小到达排序,长度相等则按照字典序倒排
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b) * (-1);
        });
        for (int i = words.length - 1; i >= 0; i--) {
            if(process(words,0,i - 1,words[i],0)) {
                return words[i];
            }
        }
        return "";


    }

    private boolean process(String[] words, int start, int end, String target, int idx) {
        if (idx == target.length()) {
            return true;
        }
        for (int i = start; i <= end; i++) {
            if (words[i].length() > target.length() - idx) {
                break;
            }
            if (words[i].equals(target.substring(idx, idx + words[i].length()))) {
                if (process(words, start, end, target, idx + words[i].length())) {
                    return true;
                }
            }
        }
        return false;
    }
}
