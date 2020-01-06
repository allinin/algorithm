package ZUOSHEN.高频面试题;

/**
 * @author zbl
 * @version 1.0
 * @content: 给定一个数组arr,返回子数组的最大累加和。例如：arr={1,-2,,3,5,-2,6,-1},所有子数组中，{3,5，-2.6}可以累积出最大的和12，所以返回12
 * @date 2019/12/28 11:16
 */
public class MaxSum {

    public static int getMaxSum(int[] arr)
    {
        if(arr==null || arr.length==0)
            return 0;
        int cur=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            cur+=arr[i];
            max=Math.max(cur,max);
            cur=cur>0?cur:0;
        }
        return max;
    }
}
