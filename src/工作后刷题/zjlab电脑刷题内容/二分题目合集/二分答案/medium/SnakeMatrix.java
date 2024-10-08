package 工作后刷题.zjlab电脑刷题内容.二分题目合集.二分答案.medium;

/**
 * @Author: ZBL
 * @Date: 2023-12-28  09:27
 * 蛇形矩阵中查找某个数字是否存在
 * [[1,2,3][6,5,4],[7,8,9],[12,11,10]],target = 8;
 */
public class SnakeMatrix {


    //重新温故
    public boolean canFind(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 1, right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int[] idxArr = process(matrix, mid);
            if (matrix[idxArr[0]][idxArr[1]] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int[] indexes = process(matrix, left);

        return matrix[indexes[0]][indexes[1]] == target;
    }

    private int[] process(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[] ans = new int[2];
        ans[0] = target / n;
        ans[1] = target % n;
        if (ans[0] % 2 == 1) {
            ans[1] = n - ans[1] - 1;
        }
        return ans;
    }

    public boolean snakeMatrixSearch(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 1;
        int right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //查找mid在matrix中的位置
            int[] indexes = getIndexes(mid, m, n);
            if (matrix[indexes[0]][indexes[1]] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int[] indexes = getIndexes(left, m, n);

        return matrix[indexes[0]][indexes[1]] == target;
    }

    //这种求法默认了matrix所有的数值依次相差1！！！！
    private int[] getIndexes(int num, int m, int n) {
        int[] res = new int[2];
        res[0] = num / n;
        res[1] = num % n;
        if (res[0] % 2 == 1) {
            res[1] = n - res[1] - 1;
        }
        return res;
    }
}
