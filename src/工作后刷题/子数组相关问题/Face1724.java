package 工作后刷题.子数组相关问题;

/**
 * @Author:zbl
 * @Date:2024/1/7 15:29
 * 面试题17.24最大子矩阵(hard)
 * <p>
 * 给定一个正整数、负整数和 0 组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。
 * <p>
 * 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。若有多个满足条件的子矩阵，返回任意一个均可。
 * <p>
 * 注意：本题相对书上原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 * [-1,0],
 * [0,-1]
 * ]
 * 输出：[0,1,0,1]
 * 解释：输入中标粗的元素即为输出所表示的矩阵
 * <p>
 * <p>
 * 说明：
 * <p>
 * 1 <= matrix.length, matrix[0].length <= 200
 */
public class Face1724 {


    public int[] getMaxMatrix(int[][] matrix) {
        int[] ans = new int[4];
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            int[] tmp = new int[n];
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    tmp[k] += matrix[j][k];
                }
                int[] tmpAns = getMaxSumAndEdge(tmp);
                if (tmpAns[0] > max) {
                    max = tmpAns[0];
                    ans[0] = i;
                    ans[1] = tmpAns[1];
                    ans[2] = j;
                    ans[3] = tmpAns[2];
                }
            }
        }
        return ans;
    }

    private int[] getMaxSumAndEdge(int[] tmp) {
        int[] ans = new int[3];
        int now = 0, start = 0, end = 0;
        ans[0] = Integer.MIN_VALUE;
        for (int i = 0; i < tmp.length; i++) {
            now += tmp[i];
            //当前和大于最终结果值，更新最终结果值及坐标，否则不变
            if (now > ans[0]) {
                ans[0] = now;
                end = i;
                ans[1] = start;
                ans[2] = end;
            }
            //当前和小于0，则置零
            if (now < 0) {
                start = i + 1;
                now = 0;
            }
        }
        return ans;
    }
}
