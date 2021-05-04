package 面试相关.公司笔面试真题.猿辅导.二一_1;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:小明选了 n 门在线课程，每门课程的开始和结束时间为 (s[i], e[i])，小明可以一心多用，
 * 问小明最多需要同时打开多少个播放器窗口才能顺利地上完这些课程。

这个问题的本质是：给定了 n 个区间，问重合的区间的最大数量是多少。
 * @date 2020/8/1 22:32
 */
public class Solution1{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }

        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else{
                return b[1]-a[1];
            }
        });

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        int max=0;
        for(int i=0;i<n;i++){
            while(!priorityQueue.isEmpty() && priorityQueue.peek()<=arr[i][0]){
                priorityQueue.peek();
            }
            priorityQueue.add(arr[i][1]);
            max=Math.max(max,priorityQueue.size());
        }
        System.out.println(max);

    }
}
