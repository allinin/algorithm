package 左神算法.进阶班二.第二章;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个整数矩阵matrix，每个位置你可以向左、右、下、上移动，找到其中最长的递增路径。
例如：
matrix = [
[9,9,4],
[6,6,8],
[2,1,1]
]
返回4
最长路径是[1, 2, 6, 9].
matrix = [
[3,4,5],
[3,2,6],
[2,2,1]
]
返回4
最长路径是[1, 2, 6, 9].
 * @date 2020/2/15 18:37
 */
public class Problem05_Longest_Increasing_Path_in_a_Matrix {

    //递归的方式
    public static int longest(int[][] matrix){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
                max=Math.max(max,process(matrix,i,j));
        }
        return max;
    }
    //i,j表示从matrix的i，j位置出发，返回从i,j位置出发的最长路径长度
    private static int process(int[][] matrix, int i, int j) {
        int path=1;//原地不动的长度
        //判断是否可以往左走
        if(j>0 && matrix[i][j-1]>matrix[i][j]){
            path=Math.max(path,process(matrix,i,j-1)+1);
        }
        //判断是否可以往右走
        if(j<matrix[0].length-1 && matrix[i][j]<matrix[i][j+1]){
            path=Math.max(path,process(matrix,i,j+1)+1);
        }

        //判断是否可以往上走
        if(i>0 && matrix[i-1][j]>matrix[i][j]){
            path=Math.max(path,process(matrix,i-1,j)+1);
        }

        //判断是否可以往下走
        if(i<matrix.length-1 && matrix[i+1][j]>matrix[i][j]){
            path=Math.max(path,process(matrix,i+1,j)+1);
        }
        return path;

    }

    //改动态规划
    public static int longestDP(int[][] matrix){
        int max=Integer.MIN_VALUE;
        int[][]dp=new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
                max=Math.max(max,processDP(matrix,dp,i,j));
        }
        return max;
    }

    //i,j表示从matrix的i，j位置出发，返回从i,j位置出发的最长路径长度
    private static int processDP(int[][] matrix, int[][] dp,int i, int j) {

        if(dp[i][j]==0) { //表示从来没有得到过该位置的值，需要进行计算，如果！=0说明前面已经计算过了，直接赋值即可，相当于加了个缓存。
            dp[i][j] = 1;//原地不动的长度
            //判断是否可以往左走
            if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], processDP(matrix, dp, i, j - 1) + 1);
            }
            //判断是否可以往右走
            if (j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1]) {
                dp[i][j] = Math.max(dp[i][j], processDP(matrix, dp, i, j +1) + 1);
            }

            //判断是否可以往上走
            if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], processDP(matrix, dp, i-1, j ) + 1);
            }

            //判断是否可以往下走
            if (i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], processDP(matrix, dp, i+1, j ) + 1);
            }
        }
        return dp[i][j];

    }

    public static void main(String[] args) {
        int[][]arr=new int[][]{
                {3,4,5},{3,2,6},{2,2,1}
        };
        System.out.println(longestDP(arr));
        System.out.println(longestDP(arr));
    }

}
