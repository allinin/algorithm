package 左神算法.面试重写与剑指offer;

import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 再次实现归并排序
 * @date 2020/3/19 20:44
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        if(arr==null || arr.length<2)
            return;
        mergeSort(arr,0,arr.length-1);
    }
    private static void mergeSort(int[] arr,int start,int end){
        if(start==end)
            return;
        int mid=start+((end-start)>>1); //注意这里运算符的优先级
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start,end,mid);
    }
    private static void merge(int[]arr,int start,int end,int mid){
        int[]help=new int[end-start+1];
        int p1=start;
        int p2=mid+1;
        int index=0;
        while(p1<=mid && p2<=end){
            help[index++]=arr[p1]<=arr[p2] ? arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[index++]=arr[p1++];
        }
        while(p2<=end){
            help[index++]=arr[p2++];
        }
        for(int i=0;i<help.length;i++){
            arr[start+i]=help[i];
        }
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);

    }

}
