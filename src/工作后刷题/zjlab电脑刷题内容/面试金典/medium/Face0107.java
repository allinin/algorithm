package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-04  09:10
 * <p>
 * 旋转矩阵
 * <p>
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * 注意：本题与主站 48 题相同：https://leetcode-cn.com/problems/rotate-image/
 */
public class Face0107 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //上下颠倒
        for (int i = 0; i < n / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = tmp;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
