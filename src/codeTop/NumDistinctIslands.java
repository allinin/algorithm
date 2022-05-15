package codeTop;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空 01 二维数组表示的网格，一个岛屿由四连通（上、下、左、右四个方向）的 1 组成，你可以认为网格的四周被海水包围。
 *
 * 请你计算这个网格中共有多少个形状不同的岛屿。两个岛屿被认为是相同的，当且仅当一个岛屿可以通过平移变换（不可以旋转、翻转）和另一个岛屿重合。
 *
 * 示例 1：
 * 11000
 * 11000
 * 00011
 * 00011
 * 给定上图，返回结果 1 。
 *
 * 示例 2：
 * 11011
 * 10000
 * 00001
 * 11011
 * 给定上图，返回结果 3 。
 *
 * 注意：
 * 11
 * 1
 * 和
 * 1
 * 11
 * 是不同的岛屿，因为我们不考虑旋转、翻转操作。
 *
 */
public class NumDistinctIslands {

    public int numDistinctIsland(int[][] arr){
        Set<String> set = new HashSet<>();
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[0].length;j++){
                if(arr[i][j] == 0){
                    continue;
                }
                //记录小岛的形状
                StringBuilder sb = new StringBuilder();
                process(arr,i,j,i,j,sb);
                set.add(sb.toString());
            }
        }
        return set.size();
    }

    private void process(int[][] arr,int row,int col,int oldRow,int oldCol,StringBuilder sb){
        if(row >= arr.length || row < 0 || col < 0 || col >= arr[0].length || arr[row][col] == 0){
            return;
        }
        int rowIdx = row - oldRow;
        int colIdx = col - oldCol;
        sb.append(rowIdx + "_"+colIdx);
        arr[row][col] = 0;
        //代表在1的位置
        process(arr,row + 1,col,row,col,sb);
        process(arr,row - 1,col,row,col,sb);
        process(arr,row,col + 1,row,col,sb);
        process(arr,row,col - 1,row,col,sb);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        System.out.println(new NumDistinctIslands().numDistinctIsland(arr));
    }
}
