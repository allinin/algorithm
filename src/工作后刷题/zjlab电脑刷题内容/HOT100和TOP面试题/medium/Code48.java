package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 */
public class Code48 {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }
        //上下颠倒
        for(int i = 0;i < matrix.length / 2;i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[matrix.length - 1 - i];
            matrix[matrix.length - 1 - i] = tmp;
        }
        //对角线翻转
        for(int i = 0;i < matrix.length;i++) {
            for(int j = 0;j < i;j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new Code48().rotate(matrix);
        for(int i = 0;i < matrix.length;i++) {
            for(int num : matrix[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
