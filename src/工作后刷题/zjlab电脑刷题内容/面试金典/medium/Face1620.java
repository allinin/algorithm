package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author: ZBL
 * @Date: 2024-01-15  13:48
 * T9键盘
 * 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。
 * 每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。
 * 你会得到一张含有有效单词的列表。映射如下图所示：
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = "8733", words = ["tree", "used"]
 * 输出: ["tree", "used"]
 * 示例 2:
 * <p>
 * 输入: num = "2", words = ["a", "b", "c", "d"]
 * 输出: ["a", "b", "c"]
 * 提示：
 * <p>
 * num.length <= 1000
 * words.length <= 500
 * words[i].length == num.length
 * num中不会出现 0, 1 这两个数字
 */
public class Face1620 {

    private char[][] help = new char[][]{{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> getValidT9Words(String num, String[] words) {
        List<String> res = new ArrayList<>();
        for(String word : words) {
            if(process(num,word,0)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean process(String num,String word,int idx) {
        if(idx == word.length()){
            return true;
        }
        for(int i = 0;i < help[num.charAt(idx) - '0'].length;i++) {
            if(help[num.charAt(idx) - '0'][i] != word.charAt(idx)) {
                continue;
            }
            if(process(num,word,idx +1)) {
                return true;
            }
        }
        return false;
    }


    //前缀树的方式超出内存限制
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

        public void insert(String num) {
            process(num, 0, root);
        }

        private void process(String num, int idx, Node cur) {
            if (idx == num.length()) {
                cur.end = true;
                return;
            }
            for (int i = 0; i < help[num.charAt(idx) - '0'].length; i++) {
                char c = help[num.charAt(idx) - '0'][i];
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node();
                }

                process(num, idx + 1, cur.children[c - 'a']);
            }
        }

        private boolean find(String str) {
            Node cur = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.end;
        }

    }

}
