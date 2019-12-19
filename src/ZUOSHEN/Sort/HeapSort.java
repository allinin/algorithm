package ZUOSHEN.Sort;

import java.util.Arrays;

public class HeapSort {


    public static void heapSort(int[] arr)
    {
        if(arr==null || arr.length<2)
            return ;
        //模拟构建大顶堆的过程，对数组中每一个元素进行处理
        for(int i=0;i<arr.length;i++)
        {
            heapInsert(arr,i);
        }
        int size=arr.length;
        swap(arr,0,--size);//将大根堆顶头顶的元素与最后一个元素互换，即实现将最大的元素放在数组的最后一个位置
        while(size>0)
        {
            heapify(arr,0,size);
            swap(arr,0,--size);
        }

    }

    //仅仅是完成了数组中一个结点的位置构建
    public static void heapInsert(int[] arr,int index)
    {
        while (arr[index] > arr[(index-1)/2]) {// i=-1;i/2的结果是0
            swap(arr,index,(index-1)/2);//和父位置交换
            index=(index-1)/2;//当前位置到父位置，继续判断
        }
    }

    public static void heapify(int[] arr,int index,int size)
    {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left; //运算符的优先级注意
            largest = arr[largest] > arr[index] ? largest : index;  //可能存在重复的元素
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
