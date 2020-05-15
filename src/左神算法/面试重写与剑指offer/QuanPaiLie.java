package 左神算法.面试重写与剑指offer;

import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @content: 写个算法题，给一个数组输出它的全排列    (美团面试)
 * @date 2020/4/15 16:29
 */
public class QuanPaiLie {

    public static void main(String[] args) {
       int[] arr={1,2,3};
       dfs(arr);
    }
    public static void dfs(int[] arr){
        if(arr==null)
            return;
        if(arr.length==1)
        {
            System.out.println();
            return;
        }
        dfs(arr,0);
    }

    private static void dfs(int[] arr,int k){
       if(k==arr.length-1){

           System.out.println(Arrays.toString(arr));
           return;
       }
       for(int i=k;i<arr.length;i++)
       {
           swap(arr,k,i);
           dfs(arr,k+1);
           swap(arr,k,i);
       }

    }

    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
