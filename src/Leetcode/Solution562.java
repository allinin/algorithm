package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.

Example:

Input:
[[0,1,1,0],
[0,1,1,0],
[0,0,0,1]]
Output: 3
Hint: The number of elements in the given matrix will not exceed 10,000.
 * @date 2020/7/22 22:16
 */
public class Solution562 {


    public static int longestLine(int[][] matrix){
        if(matrix==null || matrix.length==0) return 0;
        int row=matrix.length;
        int col=matrix[0].length;
        int[][][] dp=new int[row][col][4];//表示从00-ij位置的元素在每个方向上最大的连续的1个数
        int res=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                if(matrix[i][j]==0)
                    continue;//skip 0
                for(int k=0;i<4;k++) dp[i][j][k]=1;//当i,j位置为1时，每个方向上至少结果值为1
                if(i-1>=0) dp[i][j][0]+=dp[i-1][j][0];//垂直方向
                res=Math.max(res,dp[i][j][0]);
                if(j-1>=0) dp[i][j][1]+=dp[i][j-1][1];//水平方向
                res=Math.max(res,dp[i][j][1]);
                if(i-1>=0 && j-1>=0) dp[i][j][2]+=dp[i-1][j-1][2];// 对角线方向
                res=Math.max(res,dp[i][j][2]);
                if(i-1>=0 && j+1<col) dp[i][j][3]+=dp[i-1][j+1][3];//反对角线
                res=Math.max(res,dp[i][j][3]);
            }
        }
        return res;
    }

}
