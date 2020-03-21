package 左神算法.面试重写与剑指offer;

import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/3/20 8:05
 */
public class HeapSort {

    public static void heapSort(int[] arr){
        if(arr==null || arr.length<2)
            return;
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int len=arr.length-1;
        swap(arr,0,len--);
        while(len>0){
            heapify(arr,0,len);
            swap(arr,0,len--);
        }
    }

    private static void heapInsert(int[] arr,int index){

        while(arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }

    private static void heapify(int[] arr,int start,int len){
        int left=start*2+1;
        int maxIndex=0;
        while(left<=len){
            maxIndex=(left+1)<=len && (arr[left]<arr[left+1]) ? left+1:left;
            if(arr[maxIndex]<=arr[start]){
                break;
            }else{
                swap(arr,start,maxIndex);
                start=maxIndex;
                left=2*start+1;
            }
        }

    }

    private static void swap(int[] arr, int l, int r) {
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
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
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);


    }
}
