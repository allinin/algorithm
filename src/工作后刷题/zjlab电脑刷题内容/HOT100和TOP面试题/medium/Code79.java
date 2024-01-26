package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 */
public class Code79 {

    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        //记录字符是否被使用
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //找到第一个匹配的字符
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] visited = new boolean[m][n];
                    if (process(board,i, j, 0, word, visited, m, n)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 从word的index，board的[row,col]开始匹配能否匹配剩余子串
     * @param board
     * @param row
     * @param col
     * @param index
     * @param word
     * @param visited
     * @param m
     * @param n
     * @return
     */
    private boolean process(char[][] board,int row, int col, int index, String word, boolean[][] visited, int m, int n) {
        if (index == word.length()) {
            return true;
        }
        if (row >= m || row < 0 || col >= n || col < 0 || visited[row][col]
                || board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(process(board,newRow,newCol,index + 1,word,visited,m,n)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board1 = new char[][] {{'A'}};
        char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new Code79().exist(board1,"A"));
    }


}
