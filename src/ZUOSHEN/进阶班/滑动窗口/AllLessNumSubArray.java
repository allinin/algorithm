package ZUOSHEN.进阶班.滑动窗口;

import java.util.LinkedList;

/**
 * @author zbl
 * @version 1.0
 * @content: 求一个数组中最大值减去最小值小于等于num的子数组的数量。
 * @date 2019/12/30 13:26
 */
public class AllLessNumSubArray {

    //暴力解O(N^3)
    public static int getNum1(int[] arr,int num){
        int res=0;
        for(int start=0;start<arr.length;start++){
            for(int end=start;end<arr.length;end++)
                if(isValid(arr,start,end,num))
                    res++;
        }
        return res;
    }

    private static boolean isValid(int[] arr, int start, int end, int num) {

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            min=Math.min(arr[i],min);
            max=Math.max(arr[i],max);
        }
        return max-min<=num;
    }

    //O(N)
    public static int getNum(int[] arr,int num){
        if(arr==null || arr.length==0)
            return 0;
        LinkedList<Integer>qmin=new LinkedList<>();//存放最小值的双端队列，最小值在队列头，后面依次是出现的比他大额元素
        LinkedList<Integer>qmax=new LinkedList<>();//存放最大值的双端队列，最大值在队列头部，后面依次出现的比他小的元元素
        int start=0;
        int end=0;
        int res=0;
        while(start<arr.length){
            while(end<arr.length){
                //最大值结构更新
                while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[end])
                {
                    qmax.pollLast();
                }
                qmax.addLast(end);
                //最小值结构更新
                while(!qmin.isEmpty() && arr[qmin.peekLast()]>=arr[end])
                {
                    qmin.pollLast();
                }
                qmin.addLast(end);
                if(arr[qmax.getFirst()]-arr[qmin.getFirst()]>num)//不满足条件，则往外扩会继续不达标，所以没有必要继续往外扩了，结算一番
                {
                    break;
                }
                end++;
            }
            //start左移，判断是否过期。start左移后end有可能还可以继续后移
            if(qmin.peekFirst()==start)
            {
                qmin.pollFirst();
            }
            if(qmax.peekFirst()==start)
                qmax.pollFirst();
            res+=end-start;//退出上面的时候，已经end++了。
            start++;
        }


        return res;
    }

// for test
    public static int[] getRandomArray(int len) {
        if (len < 0) {
            return null;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = getRandomArray(30);
        int num = 5;
        printArray(arr);
        System.out.println(getNum(arr, num));
        System.out.println(getNum1(arr, num));


    }

}
