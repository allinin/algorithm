package ZUOSHEN.基础班.Sort;

public class SelectSort {

    public static void selectSort(int[] arr)
    {
        if(arr==null || arr.length==0)
            return;
        for(int i=0;i<arr.length-1;i++)
        {
             int minIndex=i;
            for(int j=i;j<arr.length;j++)
            {
                minIndex=arr[j]<arr[minIndex]?j:minIndex;
            }
            swap(arr,minIndex,i);
        }
    }

    //异或的方式实现两个变量值交换
    public static void swap(int[]array,int i,int j)
    {
        array[i]=array[i]^array[j];
        array[j]=array[i]^array[j];
        array[i]=array[i]^array[j];
    }
}
