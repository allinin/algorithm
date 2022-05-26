package codeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an undirected tree, return its diameter: the number of edges in a longest path in that tree.
 * <p>
 * The tree is given as an array of edges where edges[i] = [u, v] is a bidirectional edge between nodes u and v.
 * Each node has labels in the set {0, 1, ..., edges.length}.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: edges = [[0,1],[0,2]]
 * Output: 2
 * Explanation:
 * A longest path of the tree is the path 1 - 0 - 2.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: edges =
 * Output: 4
 * Explanation:[[0,1],[1,2],[2,3],[1,4],[4,5]]
 * A longest path of the tree is the path 3 - 2 - 1 - 4 - 5.
 * Constraints:
 * <p>
 * 0 <= edges.length < 10^4
 * edges[i][0] != edges[i][1]
 * 0 <= edges[i][j] <= edges.length
 * The given edges form an undirected tree.
 * 题解：
 * <p>
 * If it is a tree, then its nodes n = edges.length + 1.
 * <p>
 * Build the tree graph first. Then start DFS from node 0.
 * <p>
 * DFS returns the deepest depth. DFS state needs current node, tree graph, and parent.
 * <p>
 * For current node, for all its neighbors, as long as it is not parent, get the depth from it, pick 2 largest.
 * <p>
 * Use these 2 largest to update the diameter.
 * <p>
 * And returns the largest depth + 1.
 * <p>
 * Time Complexity: O(n). n = edges.length.
 * <p>
 * Space: O(n).
 */
public class LeetCode1245 {

    /**
     * 1、遍历 edges 数组，把它转为邻接链表(或者邻接集合)表示的图。(因为这是一个无向图，所以需要分别以数组的两个值为开始节点进行存储)
     *
     * 2、定义一个全局变量 ans 表示最终返回的最长路径的边数；
     *
     * 3、遍历图，对每一个结点进行 DFS；
     *
     * DFS的实现：
     *
     * 1、遍历当前结点的所有子结点进行 DFS，找出长度最长的两个路径 max1 和 max2；
     *
     * 2、更新 ans = Math.max(ans, max1 + max2)，其中 max1 + max2 就好像是以当前点为圆心，加上两个半径，得到直径；
     *
     * 3、DFS 返回的是 Math.max(max1, max2)；
     * @param edges
     * @return
     */
    public static int ans = 0;
    public static int treeDiameter(int[][] edges) {

        int n = edges.length;
        List<Integer> [] treeList = new List[n + 1];
        for(int i = 0;i <= n;i++){
            treeList[i] = new ArrayList<>();
        }
        //将数组表示的图转换成邻接矩阵表示的图
        for(int[] arr :edges){
            treeList[arr[0]].add(arr[1]);
            treeList[arr[1]].add(arr[0]);
        }
        boolean[] visited = new boolean[n + 1];
        process(treeList,0,visited);
        return ans;
    }

    /**
     * 返回以index为起点的经过的最大节点数量
     * @param treeList
     * @param index
     * @param visited
     * @return
     */
    private static int process(List<Integer>[] treeList,int index,boolean[] visited){
        visited[index] = true;
        List<Integer> list = treeList[index];
        //相当于以index节点为圆心的的两个最大半径
        int max1 = 0;
        int max2 = 0;
        for(int newIndex : list){
            if(visited[newIndex]){
                continue;
            }
            //返回以newIndex为起点可以经过的最大节点数量，即因为newIndex与index相连因此也等于以index为圆心的最大边长
            int tmp = process(treeList,newIndex,visited);
            if(tmp > max1){
                max2 = max1;
                max1 = tmp;
            }else if(tmp > max2) {
                max2 = tmp;
            }
        }
        ans = Math.max(ans,max1 + max2);
        return Math.max(max1,max2) + 1;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {{0,1},{1,2},{2,3},{1,4},{4,5}};
        System.out.println(treeDiameter(edges));
    }
}
