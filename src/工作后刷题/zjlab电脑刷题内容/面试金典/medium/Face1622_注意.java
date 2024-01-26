package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.*;

/**
 * @Author: ZBL
 * @Date: 2024-01-16  08:50
 * <p>
 * 兰顿蚂蚁(medium)
 * <p>
 * 一只蚂蚁坐在由白色和黑色方格构成的无限网格上。开始时，网格全白，蚂蚁面向右侧。每行走一步，蚂蚁执行以下操作。
 * <p>
 * (1) 如果在白色方格上，则翻转方格的颜色，向右(顺时针)转 90 度，并向前移动一个单位。
 * (2) 如果在黑色方格上，则翻转方格的颜色，向左(逆时针方向)转 90 度，并向前移动一个单位。
 * <p>
 * 编写程序来模拟蚂蚁执行的前 K 个动作，并返回最终的网格。
 * <p>
 * 网格由数组表示，每个元素是一个字符串，代表网格中的一行，黑色方格由 'X' 表示，白色方格由 '_' 表示，
 * 蚂蚁所在的位置由 'L', 'U', 'R', 'D' 表示，分别表示蚂蚁 左、上、右、下 的朝向。
 * 只需要返回能够包含蚂蚁走过的所有方格的最小矩形。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 0
 * 输出: ["R"]
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出:
 * [
 * "_X",
 * "LX"
 * ]
 * 示例 3:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * "_U",
 * "X_",
 * "XX"
 * ]
 * 说明：
 * <p>
 * K <= 100000
 */
public class Face1622_注意 {

    // TODO 一次AC,只不过做题时间有点长了

    //记录当前方向LURD向左，向右后的方向
    String[][] help = new String[][]{{"D", "U"}, {"L", "R"}, {"U", "D"}, {"R", "L"}};

    //当前方向前进一格后的row,col变化
    int[][] indexHelp = new int[][]{{0,-1}, {-1, 0}, {0, 1}, {1, 0}};

    //记录走过的位置以及位置的状态
    Map<String, String> map = new HashMap<>();
    //记录方向与help索引的关系
    Map<String, Integer> directionMap = new HashMap<>();

    public List<String> printKMoves(int K) {
        List<String> res = new ArrayList<>();
        if (K == 0) {
            res.add("R");
            return res;
        }

        directionMap.put("L", 0);
        directionMap.put("U", 1);
        directionMap.put("R", 2);
        directionMap.put("D", 3);
        process(0,K,0,0,"R");
        //处理map，计算结果矩阵的长宽
        int rowStart = Integer.MAX_VALUE,colStart = Integer.MAX_VALUE,rowEnd = Integer.MIN_VALUE,colEnd = Integer.MIN_VALUE;
        List<int[]> positionList = new ArrayList<>();
        List<String> positionValueList = new ArrayList<>();
        for(Map.Entry<String,String> entry : map.entrySet()) {
            String[] indexs = entry.getKey().split("_");
            int[] position = new int[]{Integer.valueOf(indexs[0]),Integer.valueOf(indexs[1])};

            rowStart = Math.min(rowStart,position[0]);
            rowEnd = Math.max(rowEnd,position[0]);
            colStart = Math.min(colStart,position[1]);
            colEnd = Math.max(colEnd,position[1]);

            positionList.add(position);
            positionValueList.add(entry.getValue());
        }
        //结果矩阵初始化
        String[][] matrix = new String[rowEnd - rowStart + 1][colEnd - colStart + 1];
        for(String[] rows : matrix) {
            Arrays.fill(rows,"_");
        }
        //填充结果矩阵
        for(int i = 0; i < positionList.size();i++) {
            int[] position = positionList.get(i);
            matrix[position[0] - rowStart][position[1] - colStart] = positionValueList.get(i);
        }
        //构建返回结果
        for(String[] str : matrix) {
            res.add(String.join("",str));
        }
        return res;

    }

    private void process(int step, int k, int row, int col, String direction) {
        if (step == k) {
            map.put(row +"_" +col,direction);
            return;
        }
        String key = row + "_" + col;
        //不包含的情况下,或者当前位置是白色的情况
        if (!map.containsKey(key) || map.get(key).equals("_")) {
            map.put(key, "X");
            String newDirection = help[directionMap.get(direction)][1];
            int[] indexUpdate = indexHelp[directionMap.get(newDirection)];
            process(step + 1, k,row + indexUpdate[0],col + indexUpdate[1],newDirection);
        } else {
            //当前位置是黑色的情况
            map.put(key,"_");
            //左转
            String newDirection = help[directionMap.get(direction)][0];
            int[] indexUpdate = indexHelp[directionMap.get(newDirection)];
            process(step + 1, k,row + indexUpdate[0],col + indexUpdate[1],newDirection);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Face1622_注意().printKMoves(5));
    }

}
