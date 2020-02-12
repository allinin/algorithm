package 韩顺平算法与数据结构.datastructure.tree.heapTree;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSortDemo{
    public static void main(String[] args) {
      int[] arr={ 4, 9, 8, 5, 6};
      heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[]arr)
    {
        int temp=0;
        System.out.println("堆排序");
        for(int i=arr.length/2-1;i>=0;i--)
        {
            adjustHeap(arr,i,arr.length);
        }

        for(int j=arr.length-1;j>0;j--)
        {
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);//因为数组中arr[0]-arr[j]这些元素构成的新数组所对应的的二叉树，
                                   // 除了根节点外，剩余的子树均已经调整好，符合大顶堆，所以可以直接令i=0
        }
    }

    /**
     *
     * @param arr:待调整的数组
     * @param i：表示非叶子结点在数组中的索引
     * @param length：每次对多少个元素进行调整，length是逐渐缩短的
     */
    public static void adjustHeap(int[] arr,int i,int length)
    {
        int temp=arr[i];//先取出当前值，保存在一个临时变量中

        for(int k=i*2+1;k<length;k=k*2+1)
        {
            if(k+1<length && arr[k]<arr[k+1])//说明左子树的值小于右子树的值
            {
                k++;
            }
            if(arr[k]>temp)
            {
                arr[i]=arr[k];
                i=k;//i指向k,继续循环比较
            }else {
                break;//因为是从左往右，从下往上，依次构建大顶堆
            }
        }

        //当for循环结束后，我们已经将以i为父结点的树的最大值放在了最顶部（局部）
        arr[i]=temp;
    }
}
