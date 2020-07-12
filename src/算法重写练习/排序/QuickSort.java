package 算法重写练习.排序;

import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/6/28 23:51
 */
public class QuickSort {


    public static void quickSort(int[] nums){
         if(nums==null || nums.length==0)
             return;
         quickSort(nums,0,nums.length-1);
    }


    private static void quickSort(int[] nums,int left,int right){
        if(left<right){
            swap(nums,left+(int)(Math.random()*(right-left+1)),right);//随机快速排序
            int[] res=partitation(nums,left,right);
            quickSort(nums,left,res[0]-1);
            quickSort(nums,res[1]+1,right);
        }
    }
    //以right位置的值为标准进行大小比较
    private static int[] partitation(int[] nums,int left,int right){
        int l=left-1,r=right;
        while(left<r){
            if(nums[left]<nums[right]){
               swap(nums,left++,++l);
            }else if(nums[left]>nums[right]){
                swap(nums,left,--r);
            }else{
                left++;
            }
        }
        swap(nums,right,r);
        return new int[]{l+1,r};//返回排序后nums中left-right范围中第一个等于最后一个数的索引以及最后一个等于等于最后一个数的索引

    }

    private static void swap(int[] nums,int l,int r){
         int tmp=nums[l];
         nums[l]=nums[r];
         nums[r]=tmp;
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
            quickSort(arr1,0,arr1.length-1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(50, 100);
        printArray(arr);
        quickSort(arr);
        printArray(arr);



    }


}
