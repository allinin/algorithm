package 左神算法.进阶班一.滑动窗口;

import java.util.LinkedList;

/**
 * @author zbl
 * @version 1.0
 * @content: 生成窗口最大值
 * @date 2019/12/28 13:52
 */
public class SlidingWindowMaxArray {

    /**
    *@param :arr是输入的数组，w是窗口的大小，
    *@return：窗口在各个位置时的最大值
    */
    public static int[] getMaxWindow(int[] arr,int w)
    {
        if(arr==null || arr.length<w || w<1)
            return null;
        int[] res=new int[arr.length-w+1];
        LinkedList<Integer> list=new LinkedList<>();//使用双端队列来模拟数字进入/出去窗口,队列中存的是数组中对应元素的下标
        int index=0;
        for(int i=0;i<arr.length;i++){
            while(!list.isEmpty() && arr[list.peekLast()]<arr[i])
            {
                list.pollLast();
            }
            list.addLast(i);
            if(list.peekFirst()==i-w) //窗口右移，判断窗口中保存的元素是否过期了
            {
                list.pollFirst();
            }
            if(i>=w-1)
            {
                res[index++]=arr[list.peekFirst()];
            }
        }
        return res;

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int w = 3;
        printArray(getMaxWindow(arr, w));

    }

}
