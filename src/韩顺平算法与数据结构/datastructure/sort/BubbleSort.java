package 韩顺平算法与数据结构.datastructure.sort;

import java.awt.*;
import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr=new int[]{3, 9, -1, 10, -2 };
        BubbleSort bubbleSort=new BubbleSort();
        bubbleSort.bubbleSort(arr);
    }

    public boolean flag=false;
    public int temp;

    public void bubbleSort(int[] arr)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            {
                for(int j=0;j<arr.length-1-i;j++)
                {
                    if(arr[j]<arr[j+1])
                    {
                       flag=true;
                        temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
                }
                if(!flag)
                {
                    break;
                }else{
                    flag=false;
                }
                System.out.println(Arrays.toString(arr));

            }
        }
    }
}
