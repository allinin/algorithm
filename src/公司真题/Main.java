package 公司真题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/4/6 19:56
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int limit=sc.nextInt();
        int num=sc.nextInt();
        int[][] arr=new int[num][3];
        for(int i=0;i<num;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]= sc.nextInt();
            arr[i][2]=sc.nextInt();
        }
        //分组
        int[][]goods=new int[num][3]; //goods[i][0]表示主件，goods[i][1]为附件1，goods[i][2]为附件2
        for(int i=0; i<goods.length;i++)
        {
            Arrays.fill(goods[i],-1);
        }
         int count=0;
         for(int i=0;i<num;i++){
            if(arr[i][2]==0){
                goods[i][0]=i;//记录是第几件主物品
                count++;
            }

            else {
                if(goods[arr[i][2]-1][1]==-1){
                    goods[arr[i][2]-1][1]=i;//第一附件
                }else{
                    goods[arr[i][2]-1][2]=i;//第二附件
                }
            }
        }
         int[] first=new int[count];
         int pr=0;
         for(int i=0;i<goods.length;i++){
             if(goods[i][0]!=-1){
                 first[pr++]=goods[i][0];
             }
         }


        int[][]dp=new int[pr+1][limit+1];
        for(int i=0;i<pr;i++)
            for(int j=arr[first[i]][0];j<=limit;j++){
                //从分组中选择商品

                int index=first[i];

                if(arr[index][0]<=j) {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - arr[index][0]] + arr[index][0] * arr[index][1]);
                    int index1 = goods[index][1];
                    int index2 = goods[index][2];
                    if (index1 != -1) {
                        if (arr[index][0] + arr[index1][0] <= j) {
                            dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - arr[index][0] - arr[index1][0]] + arr[index][0] * arr[index][1]
                                    + arr[index1][0] * arr[index1][1]);
                        }
                    }
                    if (index2 != -1) {
                        if (arr[index][0] + arr[index2][0] <= j) {
                            dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - arr[index][0] - arr[index2][0]] + arr[index][0] * arr[index][1]
                                    + arr[index2][0] * arr[index2][1]);
                        }
                    }
                    if (index1 != -1 && index2 != -1) {
                        if (arr[index][0] + arr[index2][0] + arr[index1][0] <= j) {
                            dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - arr[index][0] - arr[index2][0] - arr[index1][0]] + arr[index][0] * arr[index][1]
                                    + arr[index2][0] * arr[index2][1] + arr[index1][0] * arr[index1][1]);
                        }
                    }
                }


        }
        System.out.println(dp[pr][limit]);



    }


}
