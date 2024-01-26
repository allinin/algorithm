package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-11  10:01
 * 井字游戏
 * <p>
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，
 * 其中字符" "代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；
 * 如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * <p>
 * 示例 1：
 * <p>
 * 输入： board = ["O X"," XO","X O"]
 * 输出： "X"
 * 示例 2：
 * <p>
 * 输入： board = ["OOX","XXO","OXO"]
 * 输出： "Draw"
 * 解释： 没有玩家获胜且不存在空位
 * 示例 3：
 * <p>
 * 输入： board = ["OOX","XXO","OX "]
 * 输出： "Pending"
 * 解释： 没有玩家获胜且仍存在空位
 * 提示：
 * <p>
 * 1 <= board.length == board[i].length <= 100
 * 输入一定遵循井字棋规则
 */
public class Face1604 {

    public String tictactoe(String[] board) {
        int n = board.length;
        int[][] rows = new int[n][2];//0代表x,1代表O
        int[][] cols = new int[n][2];
        boolean flag = false;
        boolean kAllX = true,kAllO = true,k1AllX = true,k1AllO = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                if (c == ' ') {
                    flag = true;
                } else if (c == 'X') {
                    rows[i][0]++;
                    cols[j][0]++;
                    if (rows[i][0] == n || cols[j][0] == n) {
                        return "X";
                    }
                } else {
                    rows[i][1]++;
                    cols[j][1]++;
                    if (rows[i][1] == n || cols[j][1] == n) {
                        return "O";
                    }
                }

                if(i == j) {
                    if(c == ' ') {
                        kAllX = false;
                        kAllO = false;
                    } else if(c == 'X') {
                        kAllO = false;
                    } else {
                        kAllX = false;
                    }
                }
                if(i + j == n - 1) {
                    if(c == ' ') {
                        k1AllX = false;
                        k1AllO = false;
                    } else if(c == 'X') {
                        k1AllO = false;
                    } else {
                        k1AllX = false;
                    }
                }

            }
        }
        if(kAllO || k1AllO) {
            return "O";
        }
        if(k1AllX || kAllX) {
            return "X";
        }
        return flag ? "Pending" : "Draw";
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"OOXXOXXX","XXXOXOXO","OXOXXXOO","XOXOXXXX","OXOOXOOO","XOOOOOOO","OXXXOOOX","XOXOOXXX"};
        System.out.println(new Face1604().tictactoe(strs));
    }
}
