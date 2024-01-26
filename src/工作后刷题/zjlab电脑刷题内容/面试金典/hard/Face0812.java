package 工作后刷题.zjlab电脑刷题内容.面试金典.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-09  10:46
 * 八皇后
 * <p>
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 * <p>
 * 注意：本题相对原题做了扩展
 * <p>
 * 示例:
 * <p>
 * 输入：4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class Face0812 {

    List<List<String>> res = new ArrayList<>();

    //方法一：基于集合的回溯
    public List<List<String>> solveNQueens(int n) {
        int[] cols = new int[n];
        int[] visited = new int[n];
        Arrays.fill(visited,-1);
        process(n, cols, visited, new ArrayList<>(), 0);
        return res;
    }

    private void process(int n, int[] cols, int[] visited, List<String> list, int len) {
        if (len == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (cols[j] != 0) {
                continue;
            }
            if (checkIsSameSlop(visited, len, j)) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < n; k++) {
                if (k == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
            cols[j] = 1;
            visited[len] = j;
            process(n, cols, visited, list, len + 1);
            //回溯
            cols[j] = 0;
            visited[len] = -1;
            list.remove(list.size() - 1);
        }
    }


    //判断是否在同一个对角线上，如果在同一个对角线上，则存在斜率为1或者-1的情况
    private boolean checkIsSameSlop(int[] visited, int row, int col) {

        for(int i = 0;i < visited.length;i++) {
            //写作字符串比较斜率耗时很大，直接判断是否是否相等即可，也就达到了是否斜率为1，-1的效果
            if(visited[i] != -1) {
                int diffY = row - i;
                int diffX = col - visited[i];
                if(diffX == diffY || diffX == diffY * (-1)) {
                    return true;
                }
            }
        }

        return false;
    }

    //方法二：基于位运算的回溯(这个写法本质上还是基于集合的回溯，具体写法见leetCode答案)
    public List<List<String>> solveNQueens2(int n) {
        int cols = 0;
        int[] visited = new int[n]; //i代表访问过的行，visited[i]代表访问过的列
        Arrays.fill(visited,-1);
        process2(n, cols, visited, new ArrayList<>(), 0);
        return res;
    }

    private void process2(int n, int cols, int[] visited, List<String> list, int len) {
        if (len == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < n; j++) {
            if ((cols & (1 << j)) != 0) {
                continue;
            }
            if (checkIsSameSlop(visited, len, j)) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < n; k++) {
                if (k == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
            cols |= 1 << j;
            visited[len] = j;
            process2(n, cols, visited, list, len + 1);
            //回溯
            cols ^= 1 << j;
            visited[len] = -1;
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        List<List<String>> lists = new Face0812().solveNQueens(4);
        for (List<String> list : lists) {
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println("________________");
        }
    }


}
