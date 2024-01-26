package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

import java.util.*;

/**
 * @Author: ZBL
 * @Date: 2023-12-22  15:38
 * <p>
 * 单词接龙II
 * <p>
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 * <p>
 * 每对相邻的单词之间仅有单个字母不同。
 * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * 解释：存在 2 种最短的转换序列：
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * 示例 2：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：[]
 * 解释：endWord "cog" 不在字典 wordList 中，所以不存在符合要求的转换序列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= beginWord.length <= 5
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 500
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有单词 互不相同
 */
public class Code126_DONE {

    List<List<String>> res = new ArrayList<>();

    // BFS + DFS
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        if (!set.contains(endWord)) {
            return res;
        }
        Map<String, Set<String>> fromMap = new HashMap<>();//记录key可以由哪些单词变化而来
        Map<String, Integer> levelMap = new HashMap<>();//记录每个单词所处的层级
        levelMap.put(beginWord, 0);
        boolean canReach = canReach(beginWord, endWord, set, levelMap, fromMap);
        if (canReach) {
            LinkedList<String> list = new LinkedList<>();
            list.add(endWord);
            dfs(beginWord, endWord, fromMap, list);
        }
        return res;
    }

    private void dfs(String beginWord, String nowWord, Map<String, Set<String>> fromMap, LinkedList<String> list) {
        if (nowWord.equals(beginWord)) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (String pre : fromMap.get(nowWord)) {
            list.addFirst(pre);
            dfs(beginWord, pre, fromMap, list);
            list.pollFirst();
        }
    }


    private boolean canReach(String beginWord, String endWord, Set<String> dict, Map<String, Integer> steps, Map<String, Set<String>> from) {
        int wordLen = beginWord.length();
        int step = 0;
        boolean found = false;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                char[] charArray = currWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char origin = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        String nextWord = String.valueOf(charArray);
                        if (steps.containsKey(nextWord) && steps.get(nextWord) == step) {
                            from.get(nextWord).add(currWord);
                        }

                        if (!dict.contains(nextWord)) {
                            continue;
                        }
                        dict.remove(nextWord);
                        queue.offer(nextWord);
                        from.putIfAbsent(nextWord, new HashSet<>());
                        from.get(nextWord).add(currWord);
                        steps.put(nextWord, step);
                        if (nextWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    charArray[j] = origin;
                }
            }
            if (found) {
                break;
            }
        }
        return found;
    }


    public static void main(String[] args) {
        String begin = "hit", end = "cog";
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> ladders = new Code126_DONE().findLadders(begin, end, list);
        for (List<String> tmp : ladders) {
            for (String str : tmp) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
        String begin1 = "red", end1 = "tax";
        List<String> list1 = Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee");
        List<List<String>> ladders1 = new Code126_DONE().findLadders(begin1, end1, list1);
        for (List<String> tmp : ladders1) {
            for (String str : tmp) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
        String begin2 = "a", end2 = "c";
        List<String> list2 = Arrays.asList("a", "b", "c", "d");
        List<List<String>> ladders2 = new Code126_DONE().findLadders(begin2, end2, list2);
        for (List<String> tmp : ladders2) {
            for (String str : tmp) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }


}
