package 左神算法.高频面试题.六大量运用优先级队列;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content: 很简单，不用看了
 * @date 2020/1/8 10:12
 */
public class Problem1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int x=sc.nextInt();
            int f=sc.nextInt();
            int d=sc.nextInt();
            int p=sc.nextInt();
            System.out.println(liveDay(x,f,d,p));
        }
        sc.close();
    }

    public static int liveDay(int x,int f,int d,int p){
        int p1=d/x;
        if(p1<=f){
            return p1;
        }
        int res=d-f*x;
        return f+res/(p+x);
    }
}
