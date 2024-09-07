package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二分.寻找峰值;

/**
 * @Author: ZBL
 * @Date: 2024-01-30  09:12
 * 寻找峰值II(medium)
 * 一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
 * <p>
 * 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。
 * 找出 任意一个 峰值 mat[i][j] 并 返回其位置 [i,j] 。
 * <p>
 * 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
 * <p>
 * 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: mat = [[1,4],[3,2]]
 * 输出: [0,1]
 * 解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
 * 输出: [1,1]
 * 解释: 30 和 32 都是峰值，所以[1,1]和[2,2]都是可接受的答案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 500
 * 1 <= mat[i][j] <= 105
 * 任意两个相邻元素均不相等.
 */
public class Code1901_DONE {
    public int[] findPeakGrid(int[][] mat) {
       int left = 0,right = mat.length - 1;
       while(left < right) {
           int midRow = left +(right - left) / 2;
           int col = findMaxIndex(mat[midRow]);
           if(mat[midRow][col] > (midRow + 1 >= mat.length ? -1 : mat[midRow + 1][col])){
               right = midRow;
           } else {
               left = midRow + 1;
           }
       }
       return new int[]{left,findMaxIndex(mat[left])};
    }

    private int findMaxIndex(int[] arr) {
        int idx = 0;
        for(int i = 1;i < arr.length;i++) {
            if(arr[i] > arr[idx]) {
                idx = i;
            }
        }
        return idx;
    }




    public static void main(String[] args) {
        int[][] arr = new int[][]{{10, 20, 15}, {21, 30, 14}, {7, 16, 32}};
        int[] ans = new Code1901_DONE().findPeakGrid(arr);
        System.out.println(ans[0] + " " + ans[1]);
    }

}
