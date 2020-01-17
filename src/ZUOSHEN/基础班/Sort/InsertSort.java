package ZUOSHEN.基础班.Sort;

public class InsertSort {

    public static void insertSort(int[] arr)
    {
        if(arr==null || arr.length<2)
            return;
        for(int i=1;i<arr.length;i++)
        {
            for(int j=i-1;j>=0 && arr[j]>arr[j+1];j--)//注意这里的写法
            {

                    swap(arr,j+1,j);
            }
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
