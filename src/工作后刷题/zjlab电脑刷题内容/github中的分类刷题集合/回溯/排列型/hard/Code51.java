package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.回溯.排列型.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后 hard
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 *
 * @author: ZBL
 * @date: 2024-09-11  19:37
 */
public class Code51 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[] colVisited = new boolean[n];
        process(n, 0, colVisited, new ArrayList<>(), new ArrayList<>());
        return res;
    }
    public List<List<String>> solveNQueens2(int n) {
        boolean[] colVisited = new boolean[n];
        boolean[] diagonal1 = new boolean[2 * n];//主对角线
        boolean[] diagonal2 = new boolean[2 * n];//斜对角线
        process2(n, 0, colVisited, diagonal1,diagonal2, new ArrayList<>());
        return res;
    }

    private void process(int n, int rowNum, boolean[] colVisited, List<int[]> visitedPoint, List<String> list) {
        if (rowNum == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        //列
        for (int j = 0; j < n; j++) {
            if (!colVisited[j] && !check(visitedPoint, rowNum, j)) {
                StringBuilder sb = new StringBuilder();
                colVisited[j] = true;
                visitedPoint.add(new int[]{rowNum, j});
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        sb.append('.');
                    } else {
                        sb.append('Q');
                    }
                }
                list.add(sb.toString());
                process(n, rowNum + 1, colVisited, visitedPoint, list);
                colVisited[j] = false;
                visitedPoint.remove(visitedPoint.size() - 1);
                list.remove(list.size() - 1);
            }
        }

    }
    private void process2(int n, int rowNum, boolean[] colVisited,boolean[] diagonal1,boolean[] diagonal2, List<String> list) {
        if (rowNum == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        //列
        for (int j = 0; j < n; j++) {
            //判断公式根据check方法得出
            if (!colVisited[j] && !diagonal1[rowNum - j + n] && !diagonal2[rowNum + j]) {
                StringBuilder sb = new StringBuilder();
                colVisited[j] = true;
                diagonal1[rowNum - j + n] = true;
                diagonal2[rowNum + j] = true;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        sb.append('.');
                    } else {
                        sb.append('Q');
                    }
                }
                list.add(sb.toString());
                process2(n, rowNum + 1, colVisited, diagonal1,diagonal2, list);
                colVisited[j] = false;
                diagonal1[rowNum - j + n] = false;
                diagonal2[rowNum + j] = false;
                list.remove(list.size() - 1);
            }
        }

    }

    //对角线判断，如果是同一对角线则斜率为1或-1;
    private boolean check(List<int[]> points, int row, int col) {
        //存在则说明在同一斜线上，若果斜率为1，则有row - col == p[0] - p[1],如果斜率为-1，则：row + col == p[0] + p[1]
        for (int[] p : points) {
            if (Math.abs(row - p[0]) == Math.abs(col - p[1])) {
                return true;
            }
        }
        return false;
    }
}
