package 左神算法.基础班.第四课;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前
 * 完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应
 * 的项目。最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最
 * 终可获得的最多资本
   来源：力扣（LeetCode）
   链接：https://leetcode-cn.com/problems/ipo
   著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
