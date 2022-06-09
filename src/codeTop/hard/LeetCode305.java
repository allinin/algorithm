package codeTop.hard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 假设你设计一个游戏，用一个 m 行 n 列的 2D 网格来存储你的游戏地图。

 起始的时候，每个格子的地形都被默认标记为「水」。
 我们可以通过使用 addLand 进行操作，将位置 (row, col) 的「水」变成「陆地」。

 你将会被给定一个列表，来记录所有需要被操作的位置，然后你需要返回计算出来 每次 addLand 操作后岛屿的数量。

 注意：一个岛的定义是被「水」包围的「陆地」，通过水平方向或者垂直方向上相邻的陆地连接而成。
 你可以假设地图网格的四边均被无边无际的「水」所包围。

 示例:
 输入: m = 3, n = 3,
 positions = [[0,0], [0,1], [1,2], [2,1]]
 输出: [1,1,2,3]
 解析:
 起初，二维网格 grid 被全部注入「水」。（0 代表「水」，1 代表「陆地」）
 0 0 0
 0 0 0
 0 0 0

 操作 #1：addLand(0, 0) 将 grid[0][0] 的水变为陆地。
 1 0 0
 0 0 0   Number of islands = 1
 0 0 0

 操作 #2：addLand(0, 1) 将 grid[0][1] 的水变为陆地。
 1 1 0
 0 0 0   岛屿的数量为 1
 0 0 0

 操作 #3：addLand(1, 2) 将 grid[1][2] 的水变为陆地。
 1 1 0
 0 0 1   岛屿的数量为 2
 0 0 0

 操作 #4：addLand(2, 1) 将 grid[2][1] 的水变为陆地。
 1 1 0
 0 0 1   岛屿的数量为 3
 0 1 0

 拓展：
 你是否能在 O(k log mn) 的时间复杂度程度内完成每次的计算？
 （k 表示 positions 的长度）

 */
public class LeetCode305 {

    public static void main(String[] args) {
        LeetCode305 leetCode305 = new LeetCode305();
        int[] ans = leetCode305.numsIsland2(3, 3, new int[][]{{0, 0}, {0, 1}, {2, 1}, {1, 2}});
        for(int i : ans){
            System.out.println(i);
        }


    }


    public  int[] numsIsland2(int m,int n,int[][] positions){
        int len = positions.length;
        int[] ans = new int[len];
        int sum = m * n;
        int[][] grid = new int[m][n];
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        DisjionSet disjionSet = new LeetCode305().new DisjionSet(sum);
        Set<Integer> set = new HashSet<>();//记录position中可能存在相同的元素
        for(int i = 0;i < len;i++){
            int pos = positions[i][0] * n + positions[i][1];
            //先认为当前点构成的岛屿是独立的
            ans[i] = i > 0 ? ans[i - 1] + 1 : 1;
            //标记为岛屿
            grid[positions[i][0]][positions[i][1]] = 1;
            //如果已经存在过该节点
            if(set.contains(pos)){
                ans[i]--;
                continue;
            }
            set.add(pos);
            for(int[] direction : directions){
                //当前节点相邻的节点
                int row = positions[i][0] + direction[0];
                int col = positions[i][1] + direction[1];
                //临界点没有跑出边界范围，同时临界点是1，则合并
                if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1){
                    if(disjionSet.isMerge(pos,row * n + col)){
                        ans[i]--;
                    }
                }
            }
        }
        return ans;
    }

    //定义并查集的结构
     class DisjionSet{
        private int[] fatherChildMap;

        public DisjionSet(int n){
            this.fatherChildMap = new int[n];
            //初始化，第i个节点的父节点为i;
            for(int i = 0; i < n;i++){
                fatherChildMap[i] = i;
            }
        }

        //找到a节点的父节点，同时直接将a挂在父节点下
        public  int findFather(int a){
            int father = fatherChildMap[a];
            if(fatherChildMap[a] != a){
               father = findFather(fatherChildMap[a]);
            }
            fatherChildMap[a] = father;
            return father;
        }
        //节点a与节点b是否需要合并,其中节点a与节点b是临近节点
        public boolean isMerge(int a,int b){
            int fatherA = findFather(a);
            int fatherB = findFather(b);
            if(fatherB != fatherA){
                fatherChildMap[fatherA] = fatherB;
                return true;
            }
            return false;
        }
    }

}
