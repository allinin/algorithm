package ZUOSHEN.高频面试题.五;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content: 小易有一个长度为n的整数序列，a1,a2 ......an，然后考虑在一个空序列b上进行n次以下操作：
 * 1.将ai放入b序列的末尾2.逆转b序列，小易需要你计算输出n次之后的b序列
 * @date 2020/1/6 11:09
 */
public class Problem4 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[] arr=new int[num];
        for(int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }
        String str = reverse(arr, num);
        char[] chas=str.toCharArray();
        for(int i=0;i<chas.length;i++){
            if(i!=chas.length-1){
                System.out.print(chas[i]-'0'+" ");
            }else {
                System.out.print(chas[i]-'0');
            }

        }
        sc.close();
        //reverse2();

    }

    //方法一
    public static String reverse(int[] arr,int num){
        if(num==1){
            return String.valueOf(arr[0]);
        }
         return arr[num-1]+new String(new StringBuffer(reverse(arr,num-1)).reverse());




    }

    //方法二，使用双端队列
    public static void reverse2(){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            Deque<Integer> deque = new LinkedList<Integer>();
            boolean convert = false;
            for (int i = 0; i < n; i++) {
                if (convert) {
                    deque.addLast(in.nextInt());
                } else {
                    deque.addFirst(in.nextInt());
                }
                convert = !convert;
            }
            if (convert) {
                while (deque.size() != 1) {
                    System.out.print(deque.pollFirst() + " ");
                }
                System.out.println(deque.pollFirst());
            } else {
                while (deque.size() != 1) {
                    System.out.print(deque.pollLast() + " ");
                }
                System.out.println(deque.pollLast());
            }
        }
        in.close();
    }


}
