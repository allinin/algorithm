package 韩顺平算法与数据结构.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {

        int[] arr=new int[80000];
        for(int i=0;i<80000;i++)
        {
            arr[i]=(int)(Math.random()*80000);
        }
        System.out.println("排序前");
        //System.out.println(Arrays.toString(arr));

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        selectSort(arr);


        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

    }

    public static void selectSort(int[] arr){
        int maxValue=0;
        int maxIndex=0;
        for(int i=0;i<arr.length-1;i++)
        {    maxIndex=i;
             maxValue=arr[i];
            for(int j=i+1;j<arr.length;j++)
            {
                if(maxValue<arr[j])
                {
                    maxValue=arr[j];
                    maxIndex=j;

                }
            }
            if(maxIndex!=i)
            {   arr[maxIndex]=arr[i];
                arr[i]=maxValue;

            }
//            System.out.println("第"+(i+1)+"轮后~~");
//            System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
        }
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minIndex = i;
//            int min = arr[i];
//            for (int j = i + 1; j < arr.length; j++) {
//                if (min > arr[j]) { // 说明假定的最小值，并不是最小
//                    min = arr[j]; // 重置min
//                    minIndex = j; // 重置minIndex
//                }
//            }
//
//            // 将最小值，放在arr[0], 即交换
//            if (minIndex != i) {
//                arr[minIndex] = arr[i];
//                arr[i] = min;
//            }
//
//            System.out.println("第"+(i+1)+"轮后~~");
//            System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
//        }
    }
}
