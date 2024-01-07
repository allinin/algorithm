package 工作后刷题.bfs;

import java.util.*;

/**
 * @Author:zbl
 * @Date:2024/1/7 17:18
 * <p>
 * 单词接龙II的简化版 (medium)
 * <p>
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。
 * <p>
 * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * ["hit","hot","dot","lot","log","cog"]
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: []
 * <p>
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 */
public class Face1722 {


    //bfs+dfs
    public static List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> res = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return res;
        }
        set.remove(beginWord);
        Map<String, List<String>> fromMap = new HashMap<>();
        Map<String, Integer> levelMap = new HashMap<>();
        Deque<String> deque = new LinkedList<>();
        deque.add(beginWord);
        int level = 2;
        boolean match = false;
        levelMap.put(beginWord, 1);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String word = deque.poll();
                char[] chs = word.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    char orgin = chs[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[j] = c;
                        String next = new String(chs);

                        if (levelMap.containsKey(next) && levelMap.get(next) == level) {
                            fromMap.get(next).add(word);
                        }

                        if (!set.contains(next)) {
                            continue;
                        }

                        set.remove(next);
                        fromMap.putIfAbsent(next, new ArrayList<>());
                        fromMap.get(next).add(word);
                        deque.add(next);
                        levelMap.put(next, level);
                        if (next.equals(endWord)) {
                            match = true;
                        }
                    }
                    chs[j] = orgin;
                }
            }
            if (match) {
                break;
            }
            level++;
        }
        if(!match) {
            return res;
        }

        String now = endWord;
        while(!now.equals(beginWord)) {
            res.addFirst(now);
            now = fromMap.get(now).get(0);
        }
        res.addFirst(beginWord);

        return res;

    }

    public static void main(String[] args) {
        String begin = "hit",end = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        findLadders(begin,end,wordList);
    }


}
