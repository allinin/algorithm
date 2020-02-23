package 左神算法.进阶班二.第一章;

import java.util.LinkedList;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 给定数组arr和整数num，共返回有多少个子数组满足如下情况：
max(arr[i..j]) - min(arr[i..j]) <= num
max(arr[i..j])表示子数组arr[i..j]中的最大值，min(arr[i..j])表示子数组arr[i..中的最小值。
【要求】
如果数组长度为N，请实现时间复杂度为O(N)的解法。
 * @date 2020/2/17 15:40
 */
public class Problem05_AllLessNumSubArray {

    //左程云做法
    public static int getNum1(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            res += j - i;
            i++;
        }
        return res;
    }

    public static int getNum(int[] arr, int num) {
        if(arr==null || arr.length==0){
            return 0;
        }
        int l=0;
        int r=0;
        int len=arr.length;
        int res=0;
        LinkedList<Integer> qmin=new LinkedList<>();
        LinkedList<Integer> qmax=new LinkedList<>();
        while(l<len){
            while(r<len){
                while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[r]){
                    qmax.pollLast();
                }
                qmax.addLast(r);
                while(!qmin.isEmpty() && arr[qmin.peekLast()]>=arr[r]){
                    qmin.pollLast();
                }
                qmin.addLast(r);
                if(arr[qmax.peekFirst()]-arr[qmin.peekFirst()]>num){
                    break;
                }
                r++;
            }
            if(l==qmax.peekFirst()){
                qmax.pollFirst();
            }
            if(l==qmin.peekFirst()){
                qmin.pollFirst();
            }
            res+=r-l;
            l++;


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
        System.out.println(getNum1(arr, num));
        printArray(arr);
        System.out.println(getNum(arr,num));

    }


}
