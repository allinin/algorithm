package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.回溯.排列型.hard;

/**
 * n皇后II hard
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 *
 * @author: ZBL
 * @date: 2024-09-14  19:18
 */
public class Code52 {

    //51题的变种，比51题更简单
    int res = 0;

    public int totalNQueens(int n) {
        process(n, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        return res;
    }

    private void process(int n, int rowNum, boolean[] colVisited, boolean[] diagonal1, boolean[] diagonal2) {
        if (rowNum == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!colVisited[i] && !diagonal1[rowNum - i + n] && !diagonal2[rowNum + i]) {
                colVisited[i] = true;
                diagonal1[rowNum - i + n] = true;
                diagonal2[rowNum + i] = true;
                process(n, rowNum + 1, colVisited, diagonal1, diagonal2);
                //回溯
                colVisited[i] = false;
                diagonal1[rowNum - i + n] = false;
                diagonal2[rowNum + i] = false;
            }
        }
    }
}
