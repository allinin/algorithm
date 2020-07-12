package 算法重写练习.排序;

import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/6/28 19:28
 */
public class HeapSort {

    //从小到大实现堆排序

    public static void heapSort(int[] nums){
        if(nums==null || nums.length<2) return ;

        int n=nums.length;
        for(int i=0;i<n;i++){
            heapInsert(nums,i);
        }
        swap(nums,0,--n);
        while(n>0){
            heapify(nums,0,n);
            swap(nums,0,--n);
        }


    }
    //从小到大实现堆排序的部分一：构建大根堆的过程。在数组中，从后往前
    private static void heapInsert(int[] nums,int index){

        while(nums[(index-1)/2]<nums[index]){
            swap(nums,index,(index-1)/2);
            index=(index-1)/2;
        }
    }

    //从前往后，heapify的过程,size:代表数组参与heapify的长度大小
    private static void heapify(int [] nums,int index,int size){
         int left=index*2+1;//左孩子
         while(left<size){
             int largest=left+1<size && nums[left]<nums[left+1] ? left+1 : left;//largest记录左右孩子最大值的坐标
             largest=nums[largest]<=nums[index] ? index : largest;
             if(largest==index){
                 break;
             }else{
                 swap(nums,largest,index);
                 index=largest;
                 left=index*2+1;
             }

         }
    }

    //通过异或运算实现交换数组中说的两个值
    private static void swap(int[] nums,int i,int j){
//        nums[i]=nums[i]^nums[j];
////        nums[j]=nums[j]^nums[i];
////        nums[i]=nums[i]^nums[j];
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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
        int[]nums={-2,2,1,3,4,-4,5,0};
        swap(nums,0,5);
        System.out.println(nums[0]);

    }


}
