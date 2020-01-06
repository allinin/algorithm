package ZUOSHEN.高频面试题.数组问题;

import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @content:  如果把一个数组，每个位置的值代表一个高度，那么整个数组可以看做是一个直方图，如果把这个直方图当做容器的话，求这个容器能装多少水
 * @date 2020/1/2 10:45
 */
public class WaterProblem {
    //暴力解
    public static int getWater0(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int value = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int l = 0; l < i; l++) {
                leftMax = Math.max(arr[l], leftMax);
            }
            for (int r = i + 1; r < arr.length; r++) {
                rightMax = Math.max(arr[r], rightMax);
            }
            value += Math.max(0, Math.min(leftMax, rightMax) - arr[i]);
        }
        return value;
    }
    public static int getWater1(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int n = arr.length - 2;
        int[] leftMaxs = new int[n];
        leftMaxs[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMaxs[i] = Math.max(leftMaxs[i - 1], arr[i]);
        }
        int[] rightMaxs = new int[n];
        rightMaxs[n - 1] = arr[n + 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxs[i] = Math.max(rightMaxs[i + 1], arr[i + 2]);
        }
        int value = 0;
        for (int i = 1; i <= n; i++) {
            value += Math.max(0, Math.min(leftMaxs[i - 1], rightMaxs[i - 1]) - arr[i]);
        }
        return value;
    }

    //自己实现
    public static int getWater2(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int max = 0;
        int[] leftArr = new int[arr.length]; //记录原数组中每个元素左边的最大值
        leftArr[0] = 0;
        leftArr[1] = arr[0];
        for (int i = 2; i < arr.length; i++) {
            leftArr[i] = Math.max(leftArr[i - 1], arr[i - 1]);
        }

        int[] rightArr = new int[arr.length];//记录原数组中每个元素右边的最大值，只需要反着遍历数组即可。
        rightArr[arr.length - 1] = 0;
        rightArr[arr.length - 2] = arr[arr.length - 1];
        for (int i = arr.length - 3; i >= 0; i--) {
            rightArr[i] = Math.max(rightArr[i + 1], arr[i + 1]);
        }

        int res = 0;
        for (int i = 1; i <= arr.length - 2; i++) {
            res += Math.max(0, Math.min(leftArr[i], rightArr[i]) - arr[i]);
        }
        return res;
    }

    public static int getWater3(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int n = arr.length - 2;
        int[] rightMaxs = new int[n];
        rightMaxs[n - 1] = arr[n + 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxs[i] = Math.max(rightMaxs[i + 1], arr[i + 2]);
        }
        int leftMax = arr[0];
        int value = 0;
        for (int i = 1; i <= n; i++) {
            value += Math.max(0, Math.min(leftMax, rightMaxs[i - 1]) - arr[i]);
            leftMax = Math.max(leftMax, arr[i]);
        }
        return value;
    }

    //空间复杂度O（1），时间复杂度O(n）
    public static int getWater4(int[] arr){
        if(arr==null || arr.length==0)
            return 0;
        int maxL=arr[0];
        int maxR=arr[arr.length-1];
        int left=1;
        int right=arr.length-2;
        int max=0;
        while(left<=right){
            if(maxL<=maxR){
                max+=Math.max(0,maxL-arr[left]);
                maxL=Math.max(maxL,arr[left++]);
            }else{
                max+=Math.max(0,maxR-arr[right]);
                maxR=Math.max(maxR,arr[right--]);
            }
        }
        return max;

    }

    public static int[] generateRandomArray() {
        int[] arr = new int[(int) (Math.random() * 4) + 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10) + 2;
        }
        return arr;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            int[] arr = generateRandomArray();
            int r1 = getWater1(arr);
            int r2 = getWater2(arr);
            int r4=getWater4(arr);
            if(r1!=r2 || r1!=r4)
                System.out.println("What a fucking day! fuck that! man!");

    }
    }
}
