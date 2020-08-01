package 公司笔试真题.猿辅导.二零_1;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:K(K>=3)个猿辅导的老师们在玩一个击鼓传花的小游戏。每击一次鼓，拿着花的老师要将花交给别人，不能留在自己手中。游戏开始前花在小猿手中，求击了N次鼓后，这朵花又回到小猿手中的方案数，请输出这个数模1000000007后的结果。

输入描述:
输入两个数N，K。

20%的数据：(3<=K<=10, 1<= N<=10)

70%的数据：(3<=K<=1000, 1<= N<=1000)

100%的数据：(3<=K<=10^9, 1<= N<=10^9)

输出描述:
输出方案数模1000000007后的结果

输入例子1:
3 3

输出例子1:
2
 * @date 2020/7/26 11:15
 */
public class Solution1 {



    private static final int M=1000000007;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(process(k,n));
    }

    /**
     * 以下做法超时，应该使用矩阵快速幂来解决
     * @param k
     * @param n
     * @return
     */
    public static long  process(int k,int n){
        if(k<3) return 0;
        long[][] dp=new long[n+1][2];//dp[i][1]:表示传了i次在小猿手里，dp[i][0]：表示不在小猿手里
        dp[0][1]=1;
        dp[0][0]=0;
        for(int i=1;i<=n;i++){
            dp[i][1]=dp[i-1][0]%M;
            dp[i][0]=(((k-1)*dp[i-1][1]) %M+(dp[i-1][0]*(k-2))%M)%M;
        }
        return dp[n][1];

    }
}
