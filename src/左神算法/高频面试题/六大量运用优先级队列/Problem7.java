package 左神算法.高频面试题.六大量运用优先级队列;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content: 假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前
 * 完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应
 * 的项目。最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最
 * 终可获得的最多资本

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ipo
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/1/10 13:00
 */
public class Problem7 {
    //因为一个cost对应着一个profit,所以我们可以将cost与之对应的profit封装在一个对象中
    public static class Node{
        int profit;
        int cost;

        public Node(int profit, int cost) {
            this.profit = profit;
            this.cost = cost;
        }
    }

    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost-o2.cost;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return  -o1.profit+o2.profit;
        }
    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
       while(k>0) {
            while (!minCostQ.isEmpty() && minCostQ.peek().cost <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().profit;
            k--;
        }
        return W;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[] cost=new int[4];
        int[] profit=new int[4];
        for(int i=0;i<4;i++)
        {
            cost[i]=in.nextInt();
        }
        for(int i=0;i<4;i++){
            profit[i]=in.nextInt();
        }

        int k=in.nextInt();
        int m=in.nextInt();
        System.out.println(findMaximizedCapital(k,m,profit,cost));
        in.close();

    }
}
