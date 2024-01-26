package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-08  13:49
 * 迷路的机器人
 * <p>
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，
 * 但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 * 说明：r 和 c 的值均不超过 100。
 */
public class Face0802 {
    List<List<Integer>> res = new ArrayList<>();

    //直接dfs的方式会超时
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return res;
        }
        process(0, 0, obstacleGrid, new ArrayList<>());
        return res;
    }

    private boolean process(int row, int col, int[][] obstacleGrid, List<List<Integer>> help) {
        if (row < 0 || row >= obstacleGrid.length
                || col < 0 || col >= obstacleGrid[0].length || obstacleGrid[row][col] == 1) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        list.add(row);
        list.add(col);
        help.add(list);
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
            res.addAll(help);
            return true;
        }
        obstacleGrid[row][col] = 1;
        if (process(row + 1, col, obstacleGrid, help)) {
            return true;
        }
        if (process(row, col + 1, obstacleGrid, help)) {
            return true;
        }
        obstacleGrid[row][col] = 0;
        help.remove(help.size() - 1);
        return false;
    }
    //dp的方式通过
    public List<List<Integer>> pathWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return res;
        }
        boolean[][] dp = new boolean[m][n];
        dp[m - 1][n - 1] = true;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                if (obstacleGrid[i][j] == 0) {
                    if (i + 1 < m) {
                        dp[i][j] |= dp[i + 1][j];
                    }
                    if (j + 1 < n) {
                        dp[i][j] |= dp[i][j + 1];
                    }
                }
            }
        }
        if(dp[0][0]) {
            process2(0,0,dp);
        }

        return res;
    }

    private void process2(int row,int col,boolean[][] dp) {
            List<Integer> list = new ArrayList<>();
            list.add(row);
            list.add(col);
            res.add(list);

        if(row == dp.length - 1 && col == dp[0].length - 1) {
            return;
        }
        if(row + 1 < dp.length && dp[row + 1][col]) {
            process2(row + 1,col,dp);
        } else if(col + 1 < dp[0].length && dp[row][col + 1]) {
            process2(row,col + 1,dp);
        }
    }


    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        new Face0802().pathWithObstacles(arr);
    }
}
