package 公司笔试真题.拼多多;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:扔n个骰子，第i个骰子有可能投掷出Xi种等概率的不同的结果，数字从1到Xi。所有骰子的结果的最大值将作为最终结果。求最终结果的期望。

输入描述:
第一行一个整数n，表示有n个骰子。（1 <= n <= 50）
第二行n个整数，表示每个骰子的结果数Xi。(2 <= Xi <= 50)

输出描述:
输出最终结果的期望，保留两位小数。

输入例子1:
2
2 2

输出例子1:
1.75
 * @date 2020/7/30 19:51
 */
public class Solution4 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        System.out.println(process(n,nums));
    }

    private static String process(int n,int[] nums){
        double[] help=new double[n];
        double sum=1;
        for(int i=0;i<n;i++){
            help[i]=nums[i];
            sum*=help[i];
        }
        double p=1/sum;
        Arrays.sort(help);
        double maxsum=0;
        while(help[0]!=0){
            maxsum+=help[n-1]*multi(help,n);
            help[n-1]--;
            Arrays.sort(help);
        }
        return String.format("%.2f",maxsum*p);//保留两位小数

    }

    private static double multi(double[] help,int n){
        double mul=1;
        for(int i=0;i<n-1;i++){
            mul*=help[i];
        }
        return mul;
    }

}
