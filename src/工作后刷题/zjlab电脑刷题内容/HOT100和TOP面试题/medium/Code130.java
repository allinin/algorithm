package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * @Author: ZBL
 * @Date: 2023-12-21  10:57
 * <p>
 * 被围绕的区域
 * <p>
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O'
 * 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 * <p>
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 */
public class Code130 {
    public void solve(char[][] board) {
        //找出所有不能被同化的0标记,从边界开始找
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                process(i, 0, board);
            }
            if (board[i][n - 1] == 'O') {
                process(i, n - 1, board);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                process(0, i, board);
            }
            if (board[m - 1][i] == 'O') {
                process(m - 1, i, board);
            }
        }
        //剩下的0是可以被置为X的
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        //剩下的#是原本不可以被置为X的0
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void process(int row, int col, char[][] board) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') {
            return;
        }
        board[row][col] = '#';
        process(row + 1, col, board);
        process(row - 1, col, board);
        process(row, col + 1, board);
        process(row, col - 1, board);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new Code130().solve(board);
        for(char[] chs : board) {
            for(char c : chs) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

    }
}
