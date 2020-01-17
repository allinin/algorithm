package ZUOSHEN.高频面试题.七_头条题;

import java.util.Stack;

/**
 * @author zbl
 * @version 1.0
 * @content: 给定一个数组序列，需要求选出一个区间，使得该区间是所有区间中经过如下计算的值最大的一个：区间中的最小数*区间中所有数的和，最后程序输出经过计算后的最大值即可，
 * 不需要输出具体的区间
 *
 * @date 2020/1/12 15:14
 */
public class AllTimesMinToMax {

    //时间复杂度O（n)
    public static int max1(int[] arr){
        int size=arr.length;
        //size[i]存放arr中0-i位置值的和,这样可以做到时间复杂度为O(n)
        int[] sums=new int[size];
        sums[0]=arr[0];
        for(int i=1;i<size;i++){
            sums[i]=sums[i-1]+arr[i];
        }
        Stack<Integer>stack=new Stack<>();
        int temp=0;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
               temp=stack.pop();
               res=Math.max(res,arr[temp]*(stack.isEmpty() ? sums[i-1] : (sums[i-1]-sums[stack.peek()])));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            temp=stack.pop();
            res=Math.max(res,arr[temp]*(stack.isEmpty() ? sums[size-1] : (sums[size-1]-sums[stack.peek()])));
        }
        return res;
    }


    //暴力解
    public static int max2(int [] arr){
        int res=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int minNum=Integer.MAX_VALUE;
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                    minNum=Math.min(minNum,arr[k]);
                }
                res=Math.max(minNum*sum,res);
            }
        }
        return res;

    }

    public static int[] gerenareRondomArray() {
        int[] arr = new int[(int) (Math.random() * 20) + 10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101);
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTimes = 2000000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = gerenareRondomArray();
            if (max1(arr) != max2(arr)) {
                System.out.println("FUCK!");
                break;
            }
        }

    }
}
