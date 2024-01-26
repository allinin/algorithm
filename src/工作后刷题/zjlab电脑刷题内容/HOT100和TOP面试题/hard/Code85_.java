package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：matrix = [["1"]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * rows == matrix.length
 * cols == matrix[0].length
 * 1 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 */
public class Code85_ {

    //o(m*m*n)
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int ans = 0;
        //起始行
        for (int i = 0; i < row; i++) {
            int[] arr = new int[col];
            Arrays.fill(arr, -1);
            for (int j = i; j < row; j++) {
                for (int m = 0; m < col; m++) {
                    if (matrix[j][m] == '0' || arr[m] == 0) {
                        arr[m] = 0;
                    } else {
                        arr[m] = arr[m] == -1 ? 1 : ++arr[m];
                    }
                }
                //计算当前面积
                ans = Math.max(ans, getMax(arr));
            }
        }
        return ans;
    }

    private int getMax(int[] arr) {
        int ans = 0;
        if (arr == null || arr.length == 0) {
            return ans;
        }
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                ans = Math.max(tmp, ans);
                tmp = 0;
            } else {
                tmp += arr[i];
            }
        }
        return Math.max(ans, tmp);
    }

    //单调栈的方式，先对输入进行处理
    public int maximalRectangle2(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int ans = 0;
        int[] dp = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            //计算面积，此时跟84题是相同的问题
            ans = Math.max(ans, process(dp));
        }

        return ans;
    }

    private int process(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!leftStack.isEmpty() && arr[leftStack.peek()] > arr[n - i - 1]) {
                Integer top = leftStack.pop();
                left[top] = n - i -1;
            }
            leftStack.push(n - i - 1);
            while (!rightStack.isEmpty() && arr[rightStack.peek()] > arr[i]) {
                Integer top = rightStack.pop();
                right[top] = i;
            }
            rightStack.push(i);
        }
        int ans = 0;
        for(int i = 0; i < n;i++) {
            ans = Math.max(ans,arr[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}};
        System.out.println(new Code85_().maximalRectangle2(matrix));
        int[] arr = new int[] {1,0,2,2,2};
        System.out.println(new Code85_().process(arr));
    }


}
