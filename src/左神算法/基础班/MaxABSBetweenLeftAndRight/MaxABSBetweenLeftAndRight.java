package 左神算法.基础班.MaxABSBetweenLeftAndRight;

import java.util.Random;

/**
 * 已知一个整型数组arr，数组长度为size且size大于2，arr有size-1种 可以划分成左右两部分的方案。
 * 比如： arr = {3, 2, 3, 4, 1, 2} 第1种划分左部分为[3]，右部分为[2, 3, 4, 1, 2] 第2种划分左部分为[3, 2]，
 * 右部分为[3, 4, 1, 2] 第3种划分左部分为[3, 2, 3]，右部分为[4, 1, 2] 第4种划分左部分为[3, 2, 3, 4]，
 * 右部分为[1, 2] 第5种划分左部分为[3, 2, 3, 4, 1]，右部分为[2] 每一种划分下，左部分都有最大值记为max_left，
 * 右部分都有最大值记 为max_right。 求|max_left-max_right|(左部分最大值与左部分最大值之差的绝对值)，
 * 最大是多少？ 要求：时间复杂度为O(N)，额外空间复杂度O(1)。
 */

public class MaxABSBetweenLeftAndRight {

    public static int maxABS1(int[] array)
    {
        int res = Integer.MIN_VALUE;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i != array.length - 1; i++) {
            maxLeft = Integer.MIN_VALUE;
            for (int j = 0; j != i + 1; j++) {
                maxLeft = Math.max(array[j], maxLeft);
            }
            maxRight = Integer.MIN_VALUE;
            for (int j = i + 1; j != array.length; j++) {
                maxRight = Math.max(array[j], maxRight);
            }
            res = Math.max(Math.abs(maxLeft - maxRight), res);
        }
        return res;
    }

    public static int ABS2(int[] array){
       int res=Integer.MIN_VALUE;
       int n=array.length;
       int[] leftmax=new int[n];//i以左部分的最大值
       int[] rightmax=new int[n];//i以后的部分的最大值
       leftmax[0]=array[0];
       rightmax[n-1]=array[n-1];
       for(int i=1;i<n;i++){
           leftmax[i]=Math.max(array[i],leftmax[i-1]);
       }
       for(int i=array.length-2;i>=0;i--){
           rightmax[i]=Math.max(array[i],rightmax[i+1]);
       }
       for(int i=0;i<n-1;i++){
           res=Math.max(res,Math.abs(leftmax[i]-rightmax[i+1]));
       }
       return res;

    }

    //全局最大值一定在左半部分或者右半部分，左半部分的最大值一定>=arr[0],右半部分的最大值一定>=arr[n-1]
    public static int ABS3(int[] arr)
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
        }

        return arr[0]>arr[arr.length-1] ? (max-arr[arr.length-1]):(max-arr[0]);
    }

    public static int[] generateArray(int length)
    {
        int[] array=new int[length];
        for(int i=0;i<length;i++)
            array[i]=new Random().nextInt(100);
        return array;
    }
    public static void main(String[] args){
        int[] arr = generateArray(200);
        System.out.println(maxABS1(arr));
        System.out.println(ABS2(arr));
        System.out.println(ABS3(arr));


    }
}
