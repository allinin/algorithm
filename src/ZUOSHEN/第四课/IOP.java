package ZUOSHEN.第四课;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class IOP {


    //构造一个内部类来封装指出与收益
    public static class Node{

        int cost;
        int profit;

        public  Node (int cost,int profit)
        {
            this.cost=cost;
            this.profit=profit;
        }
    }

    public static class MaxProfitHeap implements Comparator<Node>{


        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit-o1.profit;
        }
    }

    public static class MinCostHeap implements Comparator<Node>{


        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost-o2.cost;
        }
    }

    //k 表示最多可以完成的任务数目，m表示初始资金
    public static int getMaxProfit(int k,int m,int[] cost,int[] profit)
    {
        Node[] arr=new Node[cost.length];
        for(int i=0;i<cost.length;i++)
        {
            arr[i]=new Node(cost[i],profit[i]);
        }

        PriorityQueue<Node> minCost=new PriorityQueue<>(new MinCostHeap());
        PriorityQueue<Node> maxProfit=new PriorityQueue<>(new MaxProfitHeap());

        for(int i=0;i<arr.length;i++)
        {
           minCost.add(arr[i]);
        }
        for(int i=0;i<k;i++)
        {
            while(!minCost.isEmpty() && minCost.peek().cost<=m)
            {
                maxProfit.add(minCost.poll());
            }
            if(maxProfit.isEmpty())
            {
                return m;
            }
            m+=maxProfit.poll().profit;
        }
        return m;

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] cost=new int[4];
        int[] profit=new int[4];
        int k=0;
        int m=0;
        //int i=0;
        System.out.println("输入：");
        while(scanner.hasNext())
        {
        for(int i=0;i<4;i++)
            cost[i]=scanner.nextInt();
        for(int j=0;j<4;j++)
            profit[j]=scanner.nextInt();
        k=scanner.nextInt();
        m=scanner.nextInt();
            System.out.println("最大输出为： "+getMaxProfit(k,m,cost,profit));
        }

    }
}
