package 面试相关.公司笔面试真题.猿辅导.二零_1;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:有一个N*M大小的迷宫矩阵，迷宫的每一个格子有一个数值（a[i][j] <10^9）。小猿在迷宫中发现，它只能朝着上下左右四个方向的相邻格子前进，并且只能进入比当前位置数值更大的格子。但是小猿有个紧急呼救按钮，他可以通过按下按钮，强行进入到不满足数值大小要求的相邻格子，可惜这个按钮只能按K次。请问小猿从这个迷宫任选一个格子出发，在紧急呼救按钮的帮助下，最多能走多少步（开始位置计入步数，即站在起点是步数为1）。

输入描述:
第一行输入三个数N, M, K。接下来N行，每行M个数，表示迷宫中每个格子的值。
1 ≤ N ≤ 500
1 ≤ M ≤ 500
0 ≤ K ≤ 10

输出描述:
输出小猿在迷宫中能走的最大步数

输入例子1:
3 3 1
1 3 3
2 4 9
8 9 2

输出例子1:
6

例子说明1:
其中一种行走方案： (0, 0) -> (0, 1) -> (0, 0) -> (1, 0) -> (2, 0) -> (2, 1)
 * @date 2020/7/26 14:38
 */
public class Solution2 {

    public static int max=1;
    public static int[] dr={1,0,-1,0};
    public static int[] dc={0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int[][] matrix=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                matrix[i][j]=sc.nextInt();
        }

        int[][][] dp=new int[n][m][k+1];//从i,j位置出发，有k次机会最多能走的步数
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max=Math.max(max,process(i,j,matrix,k,dp));
            }
        }

        System.out.println(max);

    }

    public static int process(int i,int j,int[][] matrix,int k,int[][][] dp){

        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length)
            return 0;
        if(k>=0 && dp[i][j][k]!=0)
            return dp[i][j][k];
        int ans=0;
        for(int m=0;m<4;m++){
            int newr=i+dr[m];
            int newc=j+dc[m];
            if(newr>=0 && newr<matrix.length
            && newc>=0 && newc<matrix[0].length && matrix[newr][newc]>matrix[i][j]){
                ans=Math.max(ans,process(newr,newc,matrix,k,dp));
            }else{
                if(k>0)
                ans=Math.max(ans,process(newr,newc,matrix,k-1,dp));
            }
        }
        ans+=1;
        dp[i][j][k]=ans;
        return ans;
    }
}
