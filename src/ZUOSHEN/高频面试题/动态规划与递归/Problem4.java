package ZUOSHEN.高频面试题.动态规划与递归;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:小易非常喜欢拥有以下性质的数列：
 * 1.数列的长度为n,2.数列中每个元素的值在1到K之间（包括1和k)3.对于相邻的两个数A和B（A在B的前边），都满足A<=B,或者A mod B!=0，满足其一即可。
 * 给出n和K，求出有多少个他喜欢的队列。
 * @date 2020/1/9 10:18
 */
public class Problem4 {

    public static long number1(int n,int k){
        return process(1,n,k);
    }
    //pre表示当前要放的元素的前一个元素是啥,n表示还有多少个元素要放，k,表示放得元素的最大值可以是啥
    public static long process(int pre,int n,int k){
        if(n==0){ //n=0说明没有需要填的数了，也就是已经得出答案了，所以返回1
            return 1L;
        }
        long sum=0;
        for(int cur=pre;cur<=k;cur++){
            sum+=process(cur,n-1,k);
        }
        for(int cur=1;cur<pre;cur++){
            sum+=(pre%cur)!=0 ? process(cur,n-1,k):0;
        }

        return sum;
    }

    public static long number2(int n,int k){
        long[][]dp=new long[k+1][n];
        for(int i=0;i<k+1;i++){
            dp[i][0]=1L;
        }
        for(int col=1;col<n;col++){
            for(int row= 1;row<k+1;row++){
                long sum=0L;
                for( int cur=row;cur<=k;cur++){
                    sum+=dp[cur][col-1];
                }
                for(int cur=1;cur<row;cur++){
                    sum+=(row%cur)!=0 ? dp[cur][col-1]:0;
                }
                dp[row][col] = sum % 1000000007L;
            }
        }
        long res=0L;
        for(int i=1;i<=k;i++){
            res+=dp[i][n-1];//res即是dp[1][n]，而上面的循环仅仅求出到dp[i][n-1]
            res %= 1000000007L; //为了防止越界
        }
        return res;

    }


    public static long number3(int n,int k){
        long[][]dp=new long[k+1][n];
        for(int i=0;i<k+1;i++){
            dp[i][0]=1L;
        }
        for(int col=1;col<n;col++){
            Long sum=0L;
            for(int row=1;row<=k;row++)
                sum+=dp[row][col-1];//求出上一列的总和
                sum %= 1000000007L;
            for(int row=1;row<=k;row++){
                long noInclude=0L;
                for(int cur=1;cur<row;cur++){//row之前不满足条件的总和
                    if(row%cur==0){
                    noInclude+=dp[cur][col-1];
                    noInclude %= 1000000007L;
                    }

                }
                dp[row][col] = (sum - noInclude) % 1000000007L;//用上一列的总和减去row之前不满足条件的。

            }


        }
        long res=0L;
        for(int i=1;i<=k;i++){
            res+=dp[i][n-1];
            res %= 1000000007L;

        }
        return res;

    }
    //用一维数组来实现
    public static long number4(int n,int k){
         long[] dp=new long[k+1];
         for(int i=0;i<dp.length;i++){
             dp[i]=1;
         }
         for(int col=1;col<n;col++){
             long sum=0;
             for(int row=1;row<=k;row++){
                sum+=dp[row];//求出上一列的总和
                sum %= 1000000007L;

             }
            for(int cur=k;cur>=1;cur--){ //从高的到低的倒着来计算，-
                 long noInclude=0;
                 for(int i=1;i<cur;i++){
                     if(cur%i==0) {//cur之前不满足不满足条件的
                     noInclude+=dp[i];
                      noInclude %= 1000000007L;
                     }
                 }
                dp[cur] = (sum - noInclude) % 1000000007L;
            }

         }

         long res=0L;
         for(int i=1;i<=k;i++){
             res+=dp[i];
             res %= 1000000007L;

         }
         return res;
    }


    public static void main(String[] args) {
        System.out.println(number1(10, 9));
        System.out.println(number2(10, 9));
        System.out.println(number3(10, 9));
        System.out.println(number4(10, 9));

        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println(number2(n, k));
        }
        in.close();
    }
}
