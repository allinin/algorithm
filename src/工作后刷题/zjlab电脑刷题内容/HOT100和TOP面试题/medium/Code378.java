package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;


/**
 * TODO 有序矩阵中第k小的元素(请数组中第k的元素比较一下)
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * <p>
 * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * 示例 2：
 * <p>
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
 * 1 <= k <= n2
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能否用一个恒定的内存(即 O(1) 内存复杂度)来解决这个问题?
 * 你能在 O(n) 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（ this paper ）很有趣。
 */
public class Code378 {

    /**
     * TODO 二分查找在有序二维数组中的应用
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        //矩阵最小值与最大值
        int min = matrix[0][0], max = matrix[n - 1][n - 1];
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (check(mid, matrix, k)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    /**
     * 判断num在matrix中的最右边的位置是否是 >= k;
     *
     * @param num
     * @param matrix
     * @param k
     * @return
     */
    private boolean check(int num, int[][] matrix, int k) {
        int total = 0;//统计小于等于num的元素的数量
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                if (matrix[i][j] > num) {
                    continue;
                } else if (matrix[i][j] <= num) {
                    //matrix[i][0] —— matrix[i][j]位置的j+1个元素都小于等于num
                    total += (j + 1);
                    break;
                }
            }
        }
        return total >= k;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2}, {1,3}};
        System.out.println(new Code378().kthSmallest(matrix, 2));
    }
}
