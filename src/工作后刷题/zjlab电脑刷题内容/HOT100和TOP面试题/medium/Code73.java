package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * @Author: ZBL
 * @Date: 2023-12-19  17:26
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 */
public class Code73 {

    //空间复杂度o(m+n)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        //行置0
        for (int i = 0; i < m; i++) {
            if (rows[i] == 1) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //列置0
        for (int i = 0; i < n; i++) {
            if (cols[i] == 1) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    //o(1)的空间复杂度，用第一行，第一列记录置为列与行
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int zeroEdges = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                zeroEdges = 1;//表示第一行为0
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                if (zeroEdges == 0) {
                    zeroEdges = 2;//表示第一列为0
                } else {
                    zeroEdges = 3;//表示第一行第一列均为0
                }
                break;
            }
        }
        //用第一行，第一列分别来记录要置为0的行与列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //TODO 行为0,这里要从1开始，否则如果matrix[0][0] == 0的话会造成全部0的情况
        for (int i = 1; i < m; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 0;j < n;j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //列为0，这里要从1开始，
        for (int i = 1; i < n; i++) {
            if(matrix[0][i] == 0) {
                for(int j = 0;j < m;j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if(zeroEdges == 1) {
            for(int i = 0;i < n;i++) {
                matrix[0][i] = 0;
            }
        }
        if(zeroEdges == 2) {
            for(int i = 0;i < m;i++) {
                matrix[i][0] = 0;
            }
        }
        if(zeroEdges == 3) {
            for(int i = 0;i < m;i++) {
                matrix[i][0] = 0;
            }
            for(int i = 0;i < n;i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new Code73().setZeroes2(matrix);

    }
}
