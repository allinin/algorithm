package 左神算法.高频面试题.九TOP_K问题;

import java.util.HashSet;

/**
 * @author zbl
 * @version 1.0
 * @content: 求正数数组的最小不可组成和
 * @date 2020/1/21 19:22
 */
public class SmallestUnFormedSum {

    public static int unformedSum1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        process(arr, 0, 0, set);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i != arr.length; i++) {
            min = Math.min(min, arr[i]);

        }

        for (int i = min + 1; i != Integer.MIN_VALUE; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }
    /*使用递归的方式求出数组所有的子集的和
         index:使用数组下标index及以后的元素
         sum:当前的和
        */
    public static void process(int[] arr, int i, int sum, HashSet<Integer> set) {
        if (i == arr.length) {
            set.add(sum);
            return;
        }
        process(arr, i + 1, sum, set);
        process(arr, i + 1, sum + arr[i], set);
    }



    public static int unformedSum2(int [] arr){
        if(arr==null || arr.length==0)
            return 1;
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            min=Math.min(min,arr[i]);
        }
        boolean[][] dp=new boolean[arr.length][sum+1];
        for(int i=0;i<arr.length;i++){
            dp[i][arr[i]]=true;

        }
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][arr[i-1]]=true;

            }
        }
        for(int j=min+1;j<sum+1;j++){
            for(int i=0;i<arr.length;i++){
                if(!dp[i][j])
                    return j;
            }
        }
        return sum+1;

    }

    public static int[] generateArray(int len, int maxValue) {
        int[] res = new int[len];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue) + 1;
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
        int len = 27;
        int max = 30;
        int[] arr = generateArray(len, max);
        printArray(arr);
        long start = System.currentTimeMillis();
        System.out.println(unformedSum1(arr));
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + " ms");
        System.out.println("======================================");
        start = System.currentTimeMillis();
        System.out.println(unformedSum2(arr));
        end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + " ms");
        System.out.println("======================================");

    }
}
