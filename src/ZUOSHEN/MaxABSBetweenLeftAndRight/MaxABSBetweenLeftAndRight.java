package ZUOSHEN.MaxABSBetweenLeftAndRight;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

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
        int[]larr=new int[array.length];
        larr[0]=array[0];
        int[]rarr=new int[array.length];
        rarr[array.length-1]=array[array.length-1];
        for(int i=1;i<array.length;i++)
        {
            larr[i]=Math.max(array[i],larr[i-1]);
        }
        for(int i=array.length-2;i>=0;i--)
        {
            rarr[i]=Math.max(rarr[i+1],array[i]);
        }
        for(int i=0;i<array.length-1;i++)
        {
            res=Math.max(res,Math.abs(larr[i]-rarr[i+1]));
        }
        return res;

    }

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
