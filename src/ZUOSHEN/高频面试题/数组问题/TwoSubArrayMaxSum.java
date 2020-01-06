package ZUOSHEN.高频面试题.数组问题;

import java.io.InputStream;
import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 给定一个数组，长度大于2，找出不想交的两个子数组，情况有很多的。请返回这么多情况中，两个不相交子数组最大的和。
 * 例如：-1,3,4，-9,1,2最大的和为[3,4]与[1,2]的和10
 * @date 2020/1/3 10:12
 */
public class TwoSubArrayMaxSum {

    public static int twoSubArrayMaxSum(int[] arr){
        if(arr==null || arr.length<2)//注意根据题意，这里要小于2
            return 0;
        int[] left=new int[arr.length];//记录数组中每个位置左边形成的数组的最大子数组的和
        int[] right=new int[arr.length];//记录数组中每个位置右边形成的数组的最大子数组的和
        int max=Integer.MIN_VALUE;
        int cur=0;
        for(int i=0;i<arr.length;i++){
            cur+=arr[i];
            max=Math.max(max,cur);
            left[i]=max;
            cur=cur>0 ? cur:0;
        }
        cur=0;
        max=Integer.MIN_VALUE;
        for(int i=arr.length-1;i>-1;i--){
            cur+=arr[i];
            max=Math.max(cur,max);
            right[i]=max;
            cur=cur>0 ? cur:0;
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++){
            res=Math.max(res,left[i]+right[i+1]);
        }
        return res;
    }


    // for test
    public static int rightAnswer(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int p = 0; p < arr.length - 1; p++) {
            res = Math.max(res, maxSum(arr, 0, p) + maxSum(arr, p + 1, arr.length - 1));
        }
        return res;
    }

    // for test
    public static int maxSum(int[] arr, int l, int r) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = l; i <= r; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
    public static int twoSubArrayMaxSum2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int[] rArray = new int[arr.length];
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            cur += arr[i];
            max = Math.max(max, cur);
            rArray[i] = max;
            cur = cur < 0 ? 0 : cur;
        }
        int res = Integer.MIN_VALUE;
        max = Integer.MIN_VALUE;
        cur = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            res = Math.max(res, max + rArray[i + 1]);
            cur = cur < 0 ? 0 : cur;
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray() {
        int[] res = new int[(int) (Math.random() * 10) + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (Math.random() * 20) - 10;
        }
        return res;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 5000000;
        boolean hasErr = false;
        for (int i = 0; i < testTime; i++) {
            int[] test = generateRandomArray();
            if (twoSubArrayMaxSum(test) != rightAnswer(test)) {
                hasErr = true;
                System.out.println(Arrays.toString(test));
            }
        }
        if (hasErr) {
            System.out.println("23333333");
        } else {
            System.out.println("66666666");
        }

    }
}
