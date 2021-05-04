package 面试相关.公司笔面试真题.猿辅导.二零_3;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:辅导课堂在推进质量建设，需要分析每堂直播课的用户报障数量。
当连续多个课程的报障数量之和大于一个数s的时候，系统会发出报警。小猿想知道最长连续的没有触发报警的课程数量。

输入描述:
第一行两个整数 n，s

第二行 n 个整数，每个整数表示一次课程报障数量ai

对于 10% 的数据，满足 1 ≤ n ≤ 2 * 10^3

对于 100% 的数据，满足 1 ≤ n ≤ 2 * 10^6，0 ≤ ai ≤ 10^2

输出描述:
最长连续的没有触发报警的课程数量

输入例子1:
3 2
1 1 3

输出例子1:
2

例子说明1:
前面两次课程分别为1，1 没有触发报警 所以答案是2

输入例子2:
6 5
5 1 1 1 2 3

输出例子2:
4

例子说明2:
中间的课程打分 1 1 1 2之和等于5 没有触发报警
 * @date 2020/7/25 22:11
 */
public class Solution3 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(process(arr,s));
    }

    public static int process(int[]arr,int s){
        int n=arr.length;
        int max=0;
        int left=0,right=0;
        int sum=0;
        while(right<n){

            if(sum<=s){
                sum+=arr[right++];
            }
            //每次加完arr[right]后判断是否存在sun>s的情况
            while(left<right && sum>s){
                sum-=arr[left++];
            }
            max=Math.max(right-left,max);

        }
        return max;
    }

}
