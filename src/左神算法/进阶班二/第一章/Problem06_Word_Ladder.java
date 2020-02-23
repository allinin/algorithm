package 左神算法.进阶班二.第一章;

import java.util.*;

/**
 * @author zbl
 * @version 1.0
 * @content: 给定两个单词beginWord和endWord，还有一本词典是list类型。
找到所有从beginWord变到endWord的最短转换路径，变动的规则是：
1，一次只能变一个位置的字符
2，每一个转换后的word一定要在list中
3，初始时list中没有beginWord这个词
比如
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
返回：
[
["hit","hot","dot","dog","cog"],
["hit","hot","lot","log","cog"]
]
注意：
1，返回值的类型为List<List<String>>
2，如果不存在转化路径请返回空链表（不是null）
3，所有的词一定都是相同长度的
4，所有词都是小写的a~z
5，在list中没有重复的词
6，beginWord和endWord都不是空字符串或者null
 * @date 2020/2/13 16:43
 */
public class Problem06_Word_Ladder {


    public static List<List<String>> findLadders(String beginWord,
                                                 String endWord, List<String> wordList) {
        wordList.add(beginWord);
        HashMap<String, ArrayList<String>> nexts = getNexts(wordList);
        HashMap<String, Integer> distances = getDistances(beginWord, nexts);
        LinkedList<String> pathList = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        getShortestPaths(beginWord, endWord, nexts, distances, pathList, res);
        return res;
    }
    //返回每个单词的邻居
    public static HashMap<String, ArrayList<String>> getNexts(List<String> words) {
        Set<String> dict = new HashSet<>(words);
        HashMap<String, ArrayList<String>> nexts = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            nexts.put(words.get(i), new ArrayList<>());
        }
        for (int i = 0; i < words.size(); i++) {
            nexts.put(words.get(i), getNext(words.get(i), dict));
        }
        return nexts;
    }
    //dict是将原来的list字典变换成set结构的，HashSet的增删改查都可以看做O(1);
    //返回的是与word差别一个字母的单词的集合
    private static ArrayList<String> getNext(String word, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char[] chs = word.toCharArray();
        for (char cur = 'a'; cur <= 'z'; cur++) {//代价：26*chs.length
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] != cur) {
                    char tmp = chs[i];
                    chs[i] = cur;
                    if (dict.contains(String.valueOf(chs))) {
                        res.add(String.valueOf(chs));
                    }
                    chs[i] = tmp;
                }
            }
        }
        return res;
    }

    public static HashMap<String, Integer> getDistances(String begin,
                                                        HashMap<String, ArrayList<String>> nexts) {
        HashMap<String, Integer> distances = new HashMap<>();
        distances.put(begin, 0);
        Queue<String> queue = new LinkedList<String>();
        queue.add(begin);
        HashSet<String> set = new HashSet<String>();//记录是否已经遍历过
        set.add(begin);
        while (!queue.isEmpty()) {//宽度优先遍历
            String cur = queue.poll();
            for (String str : nexts.get(cur)) {
                if (!set.contains(str)) {
                    distances.put(str, distances.get(cur) + 1);
                    queue.add(str);
                    set.add(str);
                }
            }
        }
        return distances;
    }


    //最终求解的答案在输入参数中的递归
    private static void getShortestPaths(String cur, String end,
                                         HashMap<String, ArrayList<String>> nexts,
                                         HashMap<String, Integer> distances, LinkedList<String> solution,
                                         List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new LinkedList<String>(solution));
        } else {
            for (String next : nexts.get(cur)) {//cur的所有后代，搜索的过程又运用了深度优先遍历dfs
                if (distances.get(next) == distances.get(cur) + 1) {
                    getShortestPaths(next, end, nexts, distances, solution, res);
                }
            }
        }
        solution.pollLast();//弹出solution最后的值，深度优先遍历dfs
    }
}
