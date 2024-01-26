package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * @Author: ZBL
 * @Date: 2023-12-29  13:57
 * <p>
 * 生命游戏
 * <p>
 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * 输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [[1,1],[1,0]]
 * 输出：[[1,1],[1,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] 为 0 或 1
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 */
public class Code289 {

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int tag = 2;//使用额外的状态来标记状态变更的细胞，活细胞成为死细胞-tag,死细胞成为活细胞+tag
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                check(board, i, j, board[i][j] == 0 || board[i][j] == tag, tag);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 1) {
                    board[i][j] = 1;
                }
                if (board[i][j] < 0) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private void check(int[][] borad, int i, int j, boolean dead, int tag) {
        int deadNum = 0, liveNum = 0;
        if (i + 1 < borad.length) {
            if (borad[i + 1][j] == 0 || borad[i + 1][j] > 1) {
                deadNum++;
            } else if (borad[i + 1][j] == 1 || borad[i + 1][j] < 0) {
                liveNum++;
            }
        }

        if (i - 1 >= 0) {
            if (borad[i - 1][j] == 0 || borad[i - 1][j] > 1) {
                deadNum++;
            } else if (borad[i - 1][j] == 1 || borad[i - 1][j] < 0) {
                liveNum++;
            }
        }

        if (j - 1 >= 0) {
            if (borad[i][j - 1] == 0 || borad[i][j - 1] > 1) {
                deadNum++;
            } else if (borad[i][j - 1] == 1 || borad[i][j - 1] < 0) {
                liveNum++;
            }
        }

        if (j + 1 < borad[0].length) {
            if (borad[i][j + 1] == 0 || borad[i][j + 1] > 1) {
                deadNum++;
            } else if (borad[i][j + 1] == 1 || borad[i][j + 1] < 0) {
                liveNum++;
            }
        }
        if (j + 1 < borad[0].length && i + 1 < borad.length) {
            if (borad[i + 1][j + 1] == 0 || borad[i + 1][j + 1] > 1) {
                deadNum++;
            } else if (borad[i + 1][j + 1] == 1 || borad[i + 1][j + 1] < 0) {
                liveNum++;
            }
        }
        if (j - 1 >= 0 && i - 1 >= 0) {
            if (borad[i - 1][j - 1] == 0 || borad[i - 1][j - 1] > 1) {
                deadNum++;
            } else if (borad[i - 1][j - 1] == 1 || borad[i - 1][j - 1] < 0) {
                liveNum++;
            }
        }
        if (j - 1 >= 0 && i + 1 < borad.length) {
            if (borad[i + 1][j - 1] == 0 || borad[i + 1][j - 1] > 1) {
                deadNum++;
            } else if (borad[i + 1][j - 1] == 1 || borad[i + 1][j - 1] < 0) {
                liveNum++;
            }
        }
        if (i - 1 >= 0 && j + 1 < borad[0].length) {
            if (borad[i - 1][j + 1] == 0 || borad[i - 1][j + 1] > 1) {
                deadNum++;
            } else if (borad[i - 1][j + 1] == 1 || borad[i - 1][j + 1] < 0) {
                liveNum++;
            }
        }
        if (dead && liveNum == 3) {
            borad[i][j] = tag;
        }
        if (!dead && (liveNum < 2 || liveNum > 3)) {
            borad[i][j] -= tag;
        }
    }
}
