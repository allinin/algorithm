package Leetcode;

import java.util.*;

/**
 * @author zbl
 * @version 1.0
 * @content:给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。

编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。

示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出:
["hit","hot","dot","lot","log","cog"]

示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: []

解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-transformer-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/10 18:55
 */
public class Solutionmain1722 {

    public List<String> res=new ArrayList<>();
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return new ArrayList<>();
        }
        wordList.add(beginWord);
        HashMap<String,List<String>> map=getNexts(wordList);
        HashMap<String,Integer> distances=getDistances(beginWord,map);
        getShortestPaths(beginWord,endWord,map,distances,new LinkedList<>());
        return res;


    }

    //返回每个单词的邻居
    public  HashMap<String, List<String>> getNexts(List<String> words) {
        Set<String> dict = new HashSet<>(words);
        HashMap<String, List<String>> nexts = new HashMap<>();
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
    private  ArrayList<String> getNext(String word, Set<String> dict) {
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

    public  HashMap<String, Integer> getDistances(String begin,
                                                  HashMap<String, List<String>> nexts) {
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
    private  boolean getShortestPaths(String cur, String end,
                                      HashMap<String, List<String>> nexts,
                                      HashMap<String, Integer> distances, LinkedList<String> solution
    ) {
        solution.add(cur);
        if (end.equals(cur)) {
            res=new LinkedList<String>(solution);
            return true;
        } else {
            for (String next : nexts.get(cur)) {//cur的所有后代，搜索的过程又运用了深度优先遍历dfs
                if (distances.get(next) == distances.get(cur) + 1) {
                    if(getShortestPaths(next, end, nexts, distances, solution))
                        return true;
                    solution.pollLast();//弹出solution最后的值，深度优先遍历dfs
                }
            }
        }
        return false;

    }
}
