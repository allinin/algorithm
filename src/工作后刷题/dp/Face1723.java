package 工作后刷题.dp;

import 左神算法.进阶班一.单调栈.MaxTree;

/**
 * @Author:zbl
 * @Date:2024/1/7 15:59
 * 最大黑方阵 (medium)
 * <p>
 * 给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。
 * <p>
 * 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,0,1],
 * [0,0,1],
 * [0,0,1]
 * ]
 * 输出: [1,0,2]
 * 解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [0,1,1],
 * [1,0,1],
 * [1,1,0]
 * ]
 * 输出: [0,0,1]
 * 提示：
 * <p>
 * matrix.length == matrix[0].length <= 200
 */
public class Face1723 {

    //注意这个题目与全是0的最大矩形的区别，全是0的最大矩形需要矩形内部也是0，而本题只需要四条边全是0，内部可以是1.
    public static int[] findSquare(int[][] matrix) {
        int m = matrix.length;
        int[][][] dp = new int[m][m][2];//以i，j为左上点，向右/向下是0的最长边
        int max = 0, row = -1, col = -1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    dp[i][j][0] = j + 1 < m ? dp[i][j + 1][0] + 1 : 1;//向右
                    dp[i][j][1] = i + 1 < m ? dp[i + 1][j][1] + 1 : 1; //向下
                    //判断两另外的两个点的有效边长是否符合
                    for (int k = Math.min(dp[i][j][0], dp[i][j][1]); k >= max; k--) {
                        if (dp[i + k - 1][j][0] >= k && dp[i][j + k - 1][1] >= k) {
                            row = i;
                            col = j;
                            max = k;
                            break;
                        }
                    }

                }
            }
        }
        if (max > 0) {
            return new int[]{row, col, max};
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 0, 1}, {0, 0, 1}, {0, 0, 1}};
        int[] ans = findSquare(matrix);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
