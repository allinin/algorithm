package ZUOSHEN.高频面试题.数组问题;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content: 给定一个数组，值可以是正数，负数，和0.请返回累加和为给定值k的最长子数组的长度
 * @date 2019/12/26 14:18
 */
public class LongestSubarray2 {


    public static int maxLength(int[] arr,int k){
        if(arr==null || arr.length==0)
            return 0;
        HashMap<Integer,Integer>map=new HashMap<>();//记录前n个数的和，
        map.put(0,-1);
        int sum=0;
        int len=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(map.containsKey(sum-k))
            {
                len=Math.max(len,i-map.get(sum-k));
            }
            if(!map.containsKey(sum))
                map.put(sum,i+1);
        }
        return len;

    }

    public static int[] generateArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 11) - 5;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = generateArray(20);
        printArray(arr);
        System.out.println(maxLength(arr, 10));

    }

}
