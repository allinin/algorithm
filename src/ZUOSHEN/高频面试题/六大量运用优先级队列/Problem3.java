package ZUOSHEN.高频面试题.六大量运用优先级队列;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content: 定义疯狂队列为每对相邻元素差的绝对值总和。给出n个元素，请你排序求出他们最大疯狂队列。
 * @date 2020/1/9 10:05
 */
public class Problem3 {


    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int [] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            System.out.println(maxMad(arr));
        }
        in.close();
    }

    public static int maxMad(int[] arr){

        //先将数组进行从大到小的顺序排序
        Arrays.sort(arr);
        int res=arr[arr.length-1]-arr[0];
        int maxI=arr.length-2;
        int minI=1;
        while(minI<maxI){
            res+=arr[maxI+1]-arr[minI];
            res+=arr[maxI]-arr[minI-1];
            minI++;
            maxI--;
        }
        //一共有奇数个元素的时候会发生以下过程
        if(maxI==minI){
            res+=Math.max(arr[maxI]-arr[maxI-1],arr[maxI+1]-arr[maxI]);
        }

        return res;

    }
}
