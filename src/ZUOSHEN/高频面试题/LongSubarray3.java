package ZUOSHEN.高频面试题;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个数组，值可以是正数，负数，和0.请返回累加和为给定值k的最长子数组的长度
 * @date 2019/12/26 14:46
 */
public class LongSubarray3 {

    //时间复杂度O（N）
    public static int maxLengthAwesome(int[] arr,int k)
    {
       if(arr==null || arr.length==0)
           return 0;
       int[] sums=new int[arr.length];
        HashMap<Integer,Integer>ends=new HashMap<>();
       sums[arr.length-1]=arr[arr.length-1];
       ends.put(arr.length-1,arr.length-1);
       for(int i=arr.length-2;i>=0;i--)
       {
           if(sums[i+1]<0)
           {
               sums[i]=arr[i]+sums[i+1];
               ends.put(i,ends.get(i+1));
           }else{
               sums[i]=arr[i];
               ends.put(i,i);
           }
       }
       int sum=0;
       int end=0;
       int res=0;
       for(int i=0;i<arr.length;i++)
       {
           while(end<arr.length && sum+sums[end]<=k)
           {
               sum+=sums[end];
               end=ends.get(end)+1;
           }
           sum-=end>i?arr[i]:0;
           res=Math.max(res,end-1);
           end=Math.max(i+1,end);
       }
       return res;
    }


}
