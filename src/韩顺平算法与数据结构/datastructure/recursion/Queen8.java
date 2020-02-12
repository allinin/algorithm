package 韩顺平算法与数据结构.datastructure.recursion;

import javax.security.auth.login.AccountException;
import java.util.Map;

public class Queen8 {

    //定义一个max表示共有多少个皇后
    int max=8;
    int [] arr=new int[max];
    static int count=0;
    static int judgecount=0;

    public static void main(String[] args) {
        Queen8 queen8=new Queen8();
        queen8.check(0);
        System.out.println(count);
        System.out.println(judgecount);
    }
    //放置第n个皇后
   public void check(int n)
   {
       if(n==max){
           print();
           return;
       }
       for(int i=0;i<max;i++)
       {
           arr[n]=i;
           if(judge(n))
           {
               check(n+1);
           }

       }

   }

    //判断第n个皇后是否和前面n-1个皇后位置冲突
    public boolean judge(int n)
    {    judgecount++;
        for(int i=0;i<n;i++)
        {
            if(arr[n]==arr[i] || Math.abs(arr[i]-arr[n])== Math.abs(i-n))
                return false;
        }
        return true;
    }

    //输出皇后的摆放位置
    public void print()
    {
        count++;
        for(int i=0;i<8;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
