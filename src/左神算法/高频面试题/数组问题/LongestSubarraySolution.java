package 左神算法.高频面试题.数组问题;

/**
 * @author zbl
 * @version 1.0
 * @content: 给定义全是正数的数组，请返回累加和为给定值k的最长子数组的长度
 * @date 2019/12/26 12:45
 */
public class LongestSubarraySolution {


    //相当于是使用了滑动窗口的方法
    public static int maxLength(int[] arr,int k){
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else if (sum < k) {
                right++;
                if (right == arr.length) {//边界判断
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return len;

    }
    public static int[] generateArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 10)+1 ;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = generateArray(20);
        printArray(arr);
        System.out.println(maxLength(arr, 15));

    }

}
