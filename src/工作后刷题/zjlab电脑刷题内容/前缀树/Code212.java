package 工作后刷题.zjlab电脑刷题内容.前缀树;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: ZBL
 * @Date: 2023-12-27  14:08
 * 单词搜索II
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 */
public class Code212 {

    //TODO 超时了
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        int m = board.length, n = board[0].length;
        //普通的方式只能依次进行一个单词的检索查找。
        for (String word : words) {
            boolean[][] visited = new boolean[m][n];
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        if (process(i, j, board, visited, word, 0)) {
                            res.add(word);
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        return res;
    }

    private boolean process(int startRow, int startCol, char[][] board, boolean[][] visited, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (startRow >= board.length || startRow < 0 || startCol >= board[0].length || startCol < 0 ||
                visited[startRow][startCol] || board[startRow][startCol] != word.charAt(index)) {
            return false;
        }
        visited[startRow][startCol] = true;
        if (process(startRow + 1, startCol, board, visited, word, index + 1)) {
            return true;
        }
        if (process(startRow - 1, startCol, board, visited, word, index + 1)) {
            return true;
        }
        if (process(startRow, startCol + 1, board, visited, word, index + 1)) {
            return true;
        }
        if (process(startRow, startCol - 1, board, visited, word, index + 1)) {
            return true;
        }
        visited[startRow][startCol] = false;
        return false;
    }

    //TODO 前缀树的方式
    private Set<String> set = new HashSet<>();

    public List<String> findWords2(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        TrieTree trieTree = new TrieTree();
        //构建前缀树,将所有可能的单词加入
        for (String word : words) {
            trieTree.insert(word);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                process2(i, j, board, visited, trieTree.root, new StringBuilder());
            }
        }

        return new ArrayList<>(set);
    }

    private void process2(int startRow, int startCol, char[][] board, boolean[][] visited, Node cur, StringBuilder sb) {

        if (startRow >= board.length || startRow < 0 || startCol >= board[0].length || startCol < 0 ||
                visited[startRow][startCol]) {
            return;
        }
        char c = board[startRow][startCol];
        if (cur.children[c - 'a'] == null) {
            return;
        }
        visited[startRow][startCol] = true;
        sb.append(c);
        //查找到某个单词，加入结果集，可以继续进行，如果存在多个具有相同前缀的单词，相当于同时进行多个单词的查找，可以明显加快速度
        if(cur.children[c - 'a'].end) {
            set.add(new String(sb));
        }
        process2(startRow + 1,startCol,board,visited,cur.children[c - 'a'],sb);
        process2(startRow - 1,startCol,board,visited,cur.children[c - 'a'],sb);
        process2(startRow ,startCol + 1,board,visited,cur.children[c - 'a'],sb);
        process2(startRow ,startCol - 1,board,visited,cur.children[c - 'a'],sb);
        //回溯
        visited[startRow][startCol] = false;
        sb.deleteCharAt(sb.length() - 1);


    }

    class Node {
        Node[] children;
        boolean end;

        public Node() {
            this.children = new Node[26];
            this.end = false;
        }
    }

    class TrieTree {
        Node root;

        public TrieTree() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node();
                }
                cur = cur.children[c - 'a'];
            }
            cur.end = true;
        }

    }

    public static void main(String[] args) {

    }
}
