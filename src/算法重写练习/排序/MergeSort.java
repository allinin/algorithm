package 算法重写练习.排序;

import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/6/28 23:34
 */
public class MergeSort {

    public static void mergeSort(int[] nums){
        if(nums==null || nums.length<2)
            return;
        mergeSort(nums,0,nums.length-1);


    }

    private static void mergeSort(int[] nums,int left,int right){
        if(left<right){
            int mid=(left+right)>>>1;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,right);
        }
    }

    private static void merge(int[] nums,int left,int right){
        int len=right-left+1;
        int mid=(left+right)>>>1;
        int [] help=new int[len];
        int l=left,r=mid+1;
        int index=0;
        while(l<=mid && r<=right){
            help[index++]=nums[l]<=nums[r] ? nums[l++] : nums[r++];

        }
        while(l<=mid){
            help[index++]=nums[l++];
        }
        while(r<=right){
            help[index++]=nums[r++];
        }
        index=0;
        for(int i=0;i<len;i++){
            nums[i+left]=help[i];
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
