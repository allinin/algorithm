package 韩顺平算法与数据结构.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
//int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 }; //

        //测试快排的执行速度
        // 创建要给80000个的随机的数组
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        int temp[] = new int[arr.length]; //归并排序需要一个额外空间
        mergeSort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
      System.out.println("排序前的时间是=" + date2Str);

       // System.out.println("归并排序后=" + Arrays.toString(arr));

    }

    /**
     *
     * @param arr:排序的原始数组
     * @param left：左边有序序列的初始索引
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr,int left,int right,int[] temp)
    {
        if(left<right)
        {
            int mid=(left+right)/2;//中间索引
            //向左递归分解
            mergeSort(arr,left,mid,temp);
            //向右递归进行分解
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);

        }
    }
    /**
     *
     * @param arr:排序的原始数组
     * @param left：左边有序序列的初始索引
     * @param mid：中间索引
     *
     * @param right 右边有序序列的最后索引
     * @param temp:做中转的临时数组
     */
    public static void merge(int []arr,int left,int mid,int right,int[] temp)
    {
        int l=left;
        int j=mid+1;
        int t=0;
        //把左右两边的数据按照规则填充到temp数组，直到左右两边的有序序列，有一边处理完毕为止
        while(l<=mid && j<=right) {
            if (arr[l] < arr[j]) {
                temp[t] = arr[l];
                t++;
                l++;

            } else {
                temp[t] = arr[j];
                t++;
                j++;

            }
        }

        //把后续的数据添加到数组后
        while(l<=mid)
        {
            temp[t]=arr[l];
            l++;
            t++;
        }
        while(j<=right)
        {
            temp[t]=arr[j];
            t++;
            j++;
        }
        //将临时数组的内容拷贝到原来的数组中
        t=0;
        int tempLeft=left;
        while(tempLeft<=right)
        {
            arr[tempLeft]=temp[t];
            tempLeft++;
            t++;
        }

    }
}
