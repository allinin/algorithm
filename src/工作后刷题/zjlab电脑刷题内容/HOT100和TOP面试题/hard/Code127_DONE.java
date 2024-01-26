package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

import java.util.*;

/**
 * @Author: ZBL
 * @Date: 2023-12-21  10:56
 * <p>
 * 单词接龙
 * <p>
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * <p>
 * 每一对相邻的单词只差一个字母。
 * 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 示例 2：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 */
public class Code127_DONE {


    //TODO 类似的最少问题考虑广度优先遍历：用来查找无权图的最短路径(一个数值，即路径长度)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }
        set.remove(beginWord);
        visited.add(beginWord);
        LinkedList<String> deque = new LinkedList<>();
        deque.add(beginWord);
        int step = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            boolean add = false;
            for (int i = 0; i < size; i++) {
                String word = deque.poll();
                char[] chs = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    for (int j = 0; j < chs.length; j++) {
                        char tmp = chs[j];
                        chs[j] = c;
                        String next = new String(chs);
                        if (next.equals(endWord)) {
                            return step + 1;
                        }
                        if (!visited.contains(next) && set.contains(next)) {
                            visited.add(next);
                            deque.add(next);
                            add = true;
                        }
                        chs[j] = tmp;
                    }
                }
            }
            if (add) {
                step++;
            }
        }
        return 0;
    }
    //自己实现双向bfs
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }
        set.remove(beginWord);
        visited.add(beginWord);
        //因为仅仅是求数量，不需要保证变换的顺序，所以用set即可，速度会比list快很多！！！！
        Set<String> beginDeque = new HashSet<>();
        Set<String> endDeque = new HashSet<>();

        beginDeque.add(beginWord);
        endDeque.add(endWord);
        int step = 1;
        while (!beginDeque.isEmpty()) {
            //每次遍历的都是数量少的队列
            if(beginDeque.size() > endDeque.size()) {
                Set<String> tmp = beginDeque;
                beginDeque = endDeque;
                endDeque = tmp;
            }
            boolean add = false;
            Set<String> nextLevel = new HashSet<>();
            for (String word : beginDeque) {
                char[] chs = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    for (int j = 0; j < chs.length; j++) {
                        char tmp = chs[j];
                        chs[j] = c;
                        String next = new String(chs);
                        if (endDeque.contains(next)) {
                            return step + 1;
                        }
                        if (!visited.contains(next) && set.contains(next)) {
                            visited.add(next);
                            nextLevel.add(next);
                            add = true;
                        }
                        chs[j] = tmp;
                    }
                }
            }
            if (add) {
                step++;
            }
            beginDeque = nextLevel;
        }
        return 0;
    }

    //TODO 双向广度优先遍历(double egde bfs)
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<String>(wordList);
        if(set.size()==0 || !set.contains(endWord)){
            return 0;
        }
        Set<String>visited=new HashSet<>();//记录全部的已经访问的单词
        visited.add(beginWord);
        Set<String>beginVisited=new HashSet<>();//记录从前往后将要访问的单词
        beginVisited.add(beginWord);
        Set<String>endVisited=new HashSet<>();//记录从后往前将要访问的单词
        endVisited.add(endWord);
        int step=1;//代表当前的beginWord单词

        //我们一直保证从当前单词较小的set开始遍历判断，在这里保证beginVisited中的单词较少
        while(!beginVisited.isEmpty()){
            Set<String>nextLevel=new HashSet<>();//记录下一层将要访问的单词
            if(beginVisited.size()>endVisited.size()){//保证beginVisited中的单词数量较少的，可以提高速度
                Set<String> tmp=beginVisited;
                beginVisited=endVisited;
                endVisited=tmp;
            }
            for(String str : beginVisited){
                char[] chs=str.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    for(int i=0;i<chs.length;i++){
                        char tmp=chs[i];//保存当前i位置的字符，便于后面复原
                        chs[i]=ch;
                        String s=String.valueOf(chs);
                        if(set.contains(s)){
                            if(endVisited.contains(s)){
                                return step+1;
                            }
                            if(!visited.contains(s)){
                                nextLevel.add(s);
                                visited.add(s);
                            }
                        }
                        chs[i]=tmp;//还原单词
                    }
                }
            }

            beginVisited=nextLevel;//进入广度优先遍历的下一层
            step++;
        }
        return 0;

    }

    public static void main(String[] args) {
        String begin = "hit", end = "cog";
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(new Code127_DONE().ladderLength3(begin, end, list));
    }
}
