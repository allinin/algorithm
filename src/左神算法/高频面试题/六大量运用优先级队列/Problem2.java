package 左神算法.高频面试题.六大量运用优先级队列;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content: 小易将n个棋子放在一张无限大的棋盘上。第i个棋子在在第x[i]行，y[i]列。同一个格子可以放置多个棋子。每一次操作小易可以把一个棋子拿起并移动到原来
 * 格子的上下左右的任意一个格子中，小易想知道要让棋盘上出现一个格子中至少有i(1<=i<=n)个棋子所需要的最少操作次数
 * @date 2020/1/8 10:17
 */
public class Problem2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int size = in.nextInt();
            int[] x = new int[size];
            int[] y = new int[size];
            for (int i = 0; i < size; i++) {
                x[i] = in.nextInt();
            }
            for (int i = 0; i < size; i++) {
                y[i] = in.nextInt();
            }
            int[] res = minOPs(size, x, y);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < size; i++) {
                result.append(String.valueOf(res[i]) + " ");
            }
            System.out.println(result.toString().trim());
        }
        in.close();
    }

    public static int[] minOPs(int size,int[] x,int[] y){
        int[] res=new int[size];
        for(int i=0;i<size;i++){
            res[i]=Integer.MAX_VALUE;
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){//选中n^2个点，求棋子到选中的点的距离，从中选出距离最小的。

                for(int k=0;k<size;k++){//求每一个点到选中的点的曼哈顿距离
                    pq.add(Math.abs(x[k]-x[i])+Math.abs(y[k]-y[j]));

                }

                int sum=0;
                int resI=0;
                while(!pq.isEmpty()){
                    sum+=pq.poll();
                    res[resI]=Math.min(res[resI],sum);//选取所有距离中的最小的,res[i]代表使一个格子中有i+1个棋子的最小值
                    resI++;
                }
            }
        }
        return res;
    }

}
