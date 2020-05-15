package 公司真题.拼多多;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:链接：https://www.nowcoder.com/questionTerminal/005af31a10834b3688911463065ab47

A 国的手机号码由且仅由 N 位十进制数字(0-9)组成。一个手机号码中有至少 K 位数字相同则被定义为靓号。A 国的手机号可以有前导零，比如 000123456 是一个合法的手机号。
小多想花钱将自己的手机号码修改为一个靓号。修改号码中的一个数字需要花费的金额为新数字与旧数字之间的差值。比如将 1 修改为 6 或 6 修改为 1 都需要花 5 块钱。
给出小多现在的手机号码，问将其修改成一个靓号，最少需要多少钱？
 * @date 2020/5/3 15:59
 */
public class Main1 {
    //最小代价优先的贪心算法，以每个数字为中心，计算需要的花费，从中选择出最小的花费
    //当修改数字比选中中心大的时候从前往后修改，反之，从后往前修改
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        //注意这里如何输入字符数组,题目要求输入的是一个长度为n的字符数组。
        char[] chs = sc.next().toCharArray();
        greedyMinCost(chs,n,k);

    }
     //计算每个字符的重复次数
    private static int[] getRepeatTimes(char[] arrs){
        int[] repeatTimes=new int[10];
        for(int i=0;i<arrs.length;i++){
            repeatTimes[arrs[i]-'0']++;
        }
        return repeatTimes;
    }

    //最小代价优先的贪心算法
    private static void greedyMinCost(char[] arr,int n,int k){
        int minCost=Integer.MAX_VALUE;
        int[] repeatTimes = getRepeatTimes(arr);
        char[] newPhone=new char[n];

        //选择中心点
        for(int i=0;i<10;i++){
             int need=k-repeatTimes[i];
             if(need<=0){
                 minCost=0;
                 newPhone=arr;
                 break;
             }
             int currentCost=0;
             int upper=i+1;
             int lower=i-1;
             char[] alternative=new char[n];
             //alternative每次从arr中复制
            System.arraycopy(arr,0,alternative,0,n);

            while(need>0){
                //如果手机号中的数字比选中的数字大
                if(upper<10){
                    for(int j=0;j<n && need>0;j++){
                        if(arr[j]-'0'==upper){
                            currentCost+=upper-i;
                            alternative[j]=(char)(i+'0');
                            need--;
                        }
                    }
                }
                if(lower>=0){
                    for(int j=n-1;j>=0 && need>0;j--){
                        if(arr[j]-'0'==lower){
                            currentCost+=i-lower;
                            alternative[j]=(char)(i+'0');
                            need--;
                        }
                    }
                }
                //扩大上下限
                lower--;
                upper++;
            }
            if(currentCost<minCost){
                minCost=currentCost;
                newPhone=alternative;
            }
        }
        System.out.println(minCost);
        System.out.println(newPhone);
    }
}
