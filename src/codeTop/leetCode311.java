package codeTop;

/**
 * 给你两个 稀疏矩阵 A 和 B，请你返回 AB 的结果。
 * 你可以默认 A 的列数等于 B 的行数。
 *
 * 请仔细阅读下面的示例。
 *
 * 复制代码
 * 示例：
 * 输入：
 * A = [
 *   [ 1, 0, 0],
 *   [-1, 0, 3]
 * ]
 * B = [
 *   [ 7, 0, 0 ],
 *   [ 0, 0, 0 ],
 *   [ 0, 0, 1 ]
 * ]
 * 输出：
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                   | 0 0 1 |
 * 复制代码
 */
public class leetCode311 {

    public static int[][] multiply(int[][] A,int[][] B){
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;
        int[][] ans = new int[m][p];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(A[i][j] == 0){
                    continue;
                }
                for(int h = 0; h < p;h++){
                    ans[i][h] += A[i][j] * B[j][h]; // 只要A的纵坐标跟B的横坐标相等即可
                }
            }
        }
        return  ans;
    }
}
