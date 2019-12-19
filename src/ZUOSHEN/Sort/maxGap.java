package ZUOSHEN.Sort;

import java.util.Arrays;
import java.util.Map;

public class maxGap {

    public static int maxGap(int[] arr)
    {
        if(arr==null || arr.length<2)
            return 0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int len=arr.length;
        for(int i=0;i<arr.length;i++)
        {
            max= Math.max(max,arr[i]);
            min= Math.min(min,arr[i]);
        }
        if(max==min)
            return 0;
        boolean[] hasNum=new boolean[len+1];
        int[] maxes=new int[len+1];//记录每一桶的最大值
        int[] mins=new int[len+1];//记录每一个桶中的最小值
        int bid=0;
        for(int i=0;i<len;i++)
        {
          bid=bucket(arr[i],len,min,max);
          maxes[bid]=hasNum[bid]?Math.max(arr[i],maxes[bid]):arr[i];
          mins[bid]=hasNum[bid]?Math.min(arr[i],mins[bid]):arr[i];
          hasNum[bid]=true;
        }
        int res=0;
        int lastMax=maxes[0];//上一个桶的最大值，初始化为第一桶的最大值
        int i=1;
        for(;i<=len;i++)
        {
            if(hasNum[i])
            {
                res=Math.max(res,mins[i]-lastMax);
                lastMax=maxes[i];
            }
        }
        return res;
    }

    public static int  bucket(long num,long len,long min,long max)
    {
        return (int)((num-min)*len/(max-min));
    }
    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
