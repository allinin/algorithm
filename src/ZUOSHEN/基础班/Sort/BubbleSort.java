package ZUOSHEN.基础班.Sort;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] array)
    {
        if(array==null || array.length<2)
            return;
        for(int i=array.length-1;i>=0;i--)
        {
            for(int j=0;j<i;j++)
            {
                if(array[j]>array[j+1])
                    swap(array,j,j+1);
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

    public static int[] genearateRandomArray(int maxSize,int maxValue){
        int[]array=new int[maxSize];
        for(int i=0;i<maxSize;i++)
        {
            array[i]=(int)((maxValue+1)*Math.random())-(int)(maxValue*Math.random());
        }
        return array;
    }

    public static void comparator(int[] arr)
    {
        Arrays.sort(arr);
    }

    public static int[] arrayCopy(int[] array)
    {
        if(array==null)
            return null;
        int[]res=new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            res[i]=array[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1,int[]arr2)
    {
        if((arr1==null && arr2!=null)||(arr1!=null && arr2==null))
            return false;
        if(arr1.length!=arr2.length)
            return false;
        if(arr1==null && arr2==null)
            return true;
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]!=arr2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[]arr=new int[]{-2,-3};
        swap(arr,1,0);
        System.out.println(arr[0]+"\t"+arr[1]);
    }
}
