package 公司笔面试真题.猿辅导.二零_2;

import java.util.*;

/**
 * @author zbl
 * @version 2020 校招笔试2
 * @content:猿辅导老师在直播课上和同学们做游戏，让同学们在聊天区报自己的学号，每报一次可以获得一个礼物。但是老师不给报数次数超过了一定的次数的同学发礼物。
现在请你来帮助老师把聊天区的报数数列处理一下。
规定，当发现某个数大于 m 次时，则认定为报数过多，我们需要得到去除这些学生的报数后的报数数列。

输入描述:
第一行：两个数，学生报数总个数n，和允许的最大重复次数 m，以空格分隔
第二行：n个整数，表示学生所有报数数列，以空格分隔，范围是-2147483648~2147483647

输出描述:
只有一行，去除超出m次的报数数字后的报数数列，该数列不改变原报数顺序，数列以空格分隔

输入例子1:
7 2
4 3 3 3 1 5 5

输出例子1:
4 1 5 5

输入例子2:
6 3
1 2 2 2 2 2

输出例子2:
1
 * @date 2020/7/25 16:21
 */
public class Solution1 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        List<Integer> list = process(n, m, arr);
        for(int i=0;i< list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
    private static List<Integer> process(int n, int m, int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int i=0;i<n;i++){
            if(map.get(arr[i])<=m){
                if(!list.contains(arr[i]))
                list.add(arr[i]);
            }
        }
        return list;
    }


}
