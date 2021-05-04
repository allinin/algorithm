package 面试相关.公司笔面试真题.网易.二一;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:现在有n个物品，每一个物品都有一个价值，现在想将这份物品分给两个人，要求这两个人每一个人
 * 分到的物品的价值总和相同（个数可以不同），剩下的物品就需要扔掉，现在想知道最少需要扔掉多少价值的物品才能满足要求
 * @date 2020/8/8 17:57
 */
public class Solution1 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            t--;
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }

            System.out.println(new Solution1().new Solution().process(n,arr));
        }
    }

    class Solution{
        int n;
        int[] arr;
        int res=Integer.MAX_VALUE;


        public int process(int n,int[] arr){
            this.n=n;
            this.arr=arr;
            dfs(n-1,0,0,0);
            return res;
        }

        /**
         *
         * @param index:遍历到数组中的第几个元素了
         * @param p1：第一个人持有的总价值
         * @param p2:第二个人持有的总价值
         * @param value：丢弃的总价值
         */
        private void dfs(int index,int p1,int p2,int value){
            if(index==-1){
                if(p1==p2 && value<res) res=value;
                return;
            }

            dfs(index-1,p1+arr[index],p2,value);//分配给第一个人
            dfs(index-1,p1,p2+arr[index],value);//分配给第二个人
            dfs(index-1,p1,p2,value+arr[index]);//直接丢弃

        }
    }
}
