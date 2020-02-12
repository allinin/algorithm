package 左神算法.高频面试题.五;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/1/5 22:02
 */
public class Problem2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数组长度： ");
        while(sc.hasNext()){

            int n=sc.nextInt();
            int[] arr=new int[n];
            System.out.println("请输入数组元素： ");
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            if(isArithmeticSequeue(arr,n))
            {
                System.out.println("Possible");
            }else {
                System.out.println("Impossible");
            }

        }
    }

    public static boolean isArithmeticSequeue(int[] seq,int n){
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=seq[i];
            min=Math.min(min,seq[i]);
        }
        if ((2 * (sum - n * min)) % (n * (n - 1)) == 0)
            return true;
        else
            return false;
    }
}
