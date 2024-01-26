package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2023-12-18  16:26
 * <p>
 * 旋转矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class Code54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int startRow = 0, startCol = 0, endRow = m - 1, endCol = n - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                res.add(matrix[startRow][i]);
            }
            if (++startRow > endRow) {
                break;
            }
            for (int i = startRow; i <= endRow; i++) {
                res.add(matrix[i][endCol]);
            }
            if(--endCol < startCol)  {
                break;
            }
            for(int i = endCol;i >= startCol;i--) {
                res.add(matrix[endRow][i]);
            }
            if(--endRow < startRow) {
                break;
            }
            for(int i = endRow;i >= startRow;i--) {
                res.add(matrix[i][startCol]);
            }
            if(++startCol > endCol) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> list = new Code54().spiralOrder(matrix);
        for(Integer num : list) {
            System.out.print(num + " ");
        }
    }

}
