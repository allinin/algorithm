package 工作后刷题.dfs回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:zbl
 * @Date:2024/1/18 19:28
 * 单词矩阵(hard)
 * 给定一份单词的清单，设计一个算法，创建由字母组成的面积最大的矩形，其中每一行组成一个单词(自左向右)，每一列也组成一个单词(自上而下)。不要求这些单词在清单里连续出现，但要求所有行等长，所有列等高。
 *
 * 如果有多个面积最大的矩形，输出任意一个均可。一个单词可以重复使用。
 *
 * 示例 1:
 *
 * 输入: ["this", "real", "hard", "trh", "hea", "iar", "sld"]
 * 输出:
 * [
 *    "this",
 *    "real",
 *    "hard"
 * ]
 * 示例 2:
 *
 * 输入: ["aa"]
 * 输出: ["aa","aa"]
 * 说明：
 *
 * words.length <= 1000
 * words[i].length <= 100
 * 数据保证单词足够随机
 */
public class Face1725 {

    //dfs回溯 + 前缀树
    int maxArea = 0;
    int maxLen = 0;

    List<String> ans = new ArrayList<>();

    //单词长度：单词集合
    Map<Integer,List<String>> map = new HashMap<>();
    public String[] maxRectangle(String[] words) {
        Trie trie = new Trie();
        for(String word : words) {
            maxLen = Math.max(maxLen,word.length());
            List<String> list = map.getOrDefault(word.length(),new ArrayList<>());
            list.add(word);
            map.put(word.length(),list);
            trie.insert(word);
        }
        for(Map.Entry<Integer,List<String>> entry : map.entrySet()) {
            dfs(new ArrayList<>(),entry.getValue(),trie.root);
        }

        return ans.toArray(new String[0]);
    }

    private void dfs(List<String> path,List<String> wordList,Node root) {
        //当前相同长度的单词集合wordList中的所有单词构成的矩形都小于最大面积，则不再需要计算
        if(wordList.size() * wordList.get(0).length() < maxArea) {
            return;
        }
        //如果当前计算路径中单词的数量，也就是未来矩形的高度大于所有单词的最大长度，则一定不会存在符合要求的单词，直接返回
        if(path.size() > maxLen) {
            return;
        }

        for(String str : wordList) {
            path.add(str);
            boolean[] tmp = isValid(path,root);
            if(tmp[0]) {

               if( maxArea < path.size() * path.get(0).length()) {
                   maxArea = path.size() * path.get(0).length();
                   ans = new ArrayList<>(path);
               }
            }

            if(tmp[1]) {
                dfs(path,wordList,root);
            }
            //回溯
            path.remove(path.size() - 1);
        }

    }

    private boolean[] isValid(List<String> path,Node root) {
        boolean[] ans = new boolean[2];
        ans[0] = true; // 表示当前path中的单词的列组成的单词是否已经全部都是单词列表中的单词
        ans[1] = true; // 表示当前path中的单词列组成的单词是否都是已有单词列表中单词的前缀

        for(int i = 0;i < path.get(0).length();i++) {
            Node cur = root;
            for(String str : path) {
                char c = str.charAt(i);
                if(cur.children[c - 'a'] == null) {
                    ans[1] = false;
                    ans[0] = false;
                    return ans;
                }
                cur = cur.children[c - 'a'];
            }
            if(!cur.end) {
                ans[0] = false;
            }
        }
        return ans;
    }



    class Node {
        boolean end;
        Node[] children;

        public Node() {
            this.end = false;
            this.children = new Node[26];
        }

    }

    class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        //
        public void insert(String str) {
            Node cur = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node();
                }
                cur = cur.children[c - 'a'];
            }
            cur.end = true;
        }

    }
}
