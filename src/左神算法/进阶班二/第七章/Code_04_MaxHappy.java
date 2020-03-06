package 左神算法.进阶班二.第七章;

import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:某公司要举办一次晚会，每个参加晚会的人都不希望见到自己的直接上
司，每个人有自己的活跃度，和上下级的关系，
求邀请哪些人能使晚会的活跃度最大，最后返回活跃度即可。
例子：给定一个矩阵，
1 8
1 9
1 10
第0个数组为[1,8]，表示0号员工的直接上级是1号员工，活跃度是8
第1个数组为[1,9]，表示1号员工的直接上级是1号员工（大老板，头节
点），活跃度是9
第2个数组为[1,10]，表示2号员工的直接上级是1号员工，活跃度是10
为了使气氛最活跃，应该1不来，0和2来，活跃度为18，返回18
 * @date 2020/2/29 16:40
 */
public class Code_04_MaxHappy {

    public static class Node{
        public int huo;
        public List<Node> nexts;

        public Node(int huo, List<Node> nexts) {
            this.huo = huo;
            this.nexts = nexts;
        }
    }

    public static class ReturnData{
        public int lai_huo;
        public int bu_huo;

        public ReturnData(int lai_huo, int bu_huo) {
            this.lai_huo = lai_huo;
            this.bu_huo = bu_huo;
        }
    }

    public static int getMax(Node head){
        ReturnData returnData=process(head);
        return Math.max(returnData.bu_huo,returnData.lai_huo);
    }

    public static ReturnData process(Node head){
        List<Node> list=head.nexts;
        int laihuo=head.huo;
        int buhuo=0;
        for(int i=0;i<list.size();i++){
            ReturnData returnData = process(list.get(i));
            laihuo+=returnData.bu_huo;
            buhuo+=Math.max(returnData.bu_huo,returnData.lai_huo);
        }
        return new ReturnData(laihuo,buhuo);

    }


    //改为动态规划
    public static int maxHappy(int[][] matrix){
        int[][] dp=new int[matrix.length][2];  //dp[i][0]:表示i来的欢乐度，dp[i][1]代表i不来的欢乐度
        boolean [] visited=new boolean[matrix.length]; //visited[i]表示第i个人有没有已经计算过了
        int root=0;
        for(int i=0;i<matrix.length;i++){
            if(i==matrix[i][0])
                root=i;
        }
        process(matrix,dp,visited,root);

        return Math.max(dp[root][0],dp[root][1]);
    }

    private static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
        visited[root]=true;
        dp[root][0]=matrix[root][1];
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==root && !visited[i]){
                process(matrix,dp,visited,i);
                dp[root][0]+=dp[i][1];
                dp[root][1]+=Math.max(dp[i][0],dp[i][1]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
        System.out.println(maxHappy(matrix));
    }


}
