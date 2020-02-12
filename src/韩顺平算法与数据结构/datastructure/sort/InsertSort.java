package 韩顺平算法与数据结构.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("插入排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        insertSort(arr); //调用插入排序算法

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

    }

    public static void insertSort(int[] arr)
    {   int insertValue=0;
        int insertIndex=0;
        for(int i=1;i<arr.length;i++){
            insertValue=arr[i];
            insertIndex=i-1;//插入点的初步位置
            while(insertIndex>=0  &&  insertValue>arr[insertIndex]) ///注意，这两个判断条件不能写反了，
                                                                    // 如果写反了，可能会出现数组越界
            {   arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }//退出while循环说明插入位置找到
            if(insertIndex+1!=i){
                arr[insertIndex+1]=insertValue;
            }

//            System.out.println("第"+i+"轮插入");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
