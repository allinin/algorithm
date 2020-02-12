package 左神算法.高频面试题.十二十三;

import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @content: 在两个长度相等的排序数组中找到上中位数。
 * 给定两个有序数组arr1和arr2，已知两个数组的长度都为N，求两个数组中所有数的上中位数。
 * 要求时间复杂度为O（logN),额外空间复杂度为O（1）
 * @date 2020/2/9 16:24
 */
public class Problem09_FindUpMedian {

    public static int getUpMedian(int[] arr1,int[] arr2){
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            throw new RuntimeException("Your arr is invalid!");
        }
        int start1=0;
        int end1=arr1.length-1;
        int start2=0;
        int end2=arr2.length-1;
        int mid1=0;
        int mid2=0;
        int offset=0;
        while(start1<end1){
            mid1=(end1+start1)/2;
            mid2=(end2+start2)/2;
            //偶数长度的数组offset=1,奇数长度的数组为0
            offset=((end1-start1+1)&1)^1;
            if(arr1[mid1]==arr2[mid2])
                return arr1[mid1];
            else if(arr1[mid1]>arr2[mid2])
            {
                end1=mid1;
                start2=mid2+offset;
            }
            else{
                start1=mid1+offset;
                end2=mid2;
            }
        }
        return Math.min(arr1[start1],arr2[start2]);
    }

    //for test
    public static int findForTest(int[] arr1,int[] arr2){
        if(arr1==null || arr2==null || arr1.length!=arr2.length){
            return -1;
        }
        int[] all=new int[2*arr1.length];
        for(int i=0;i!=arr1.length;i++){
            all[2*i]=arr1[i];
            all[2*i+1]=arr2[i];
        }
        Arrays.sort(all);
        return all[all.length/2-1];
    }

    public static int[] generateSortedArray(int len,int maxValue){
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=(int)(Math.random()*(maxValue+1));
        }
        Arrays.sort(arr);
        return arr;
    }


    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int len = 10;
        int maxValue1 = 20;
        int maxValue2 = 50;
        int[] arr1 = generateSortedArray(len, maxValue1);
        int[] arr2 = generateSortedArray(len, maxValue2);
        printArray(arr1);
        printArray(arr2);
        System.out.println(getUpMedian(arr1, arr2));
        System.out.println(findForTest(arr1, arr2));

    }


}
