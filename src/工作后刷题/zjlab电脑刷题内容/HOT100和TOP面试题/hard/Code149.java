package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

import java.util.*;

/**
 * @Author: ZBL
 * @Date: 2023-12-22  14:37
 * <p>
 * // TODO 最大公约数的使用及求解
 * 直线上最多的点数
 * <p>
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * 示例 2：
 * <p>
 * <p>
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * points 中的所有点 互不相同
 */
public class Code149 {

    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            Map<String, Integer> map = new HashMap<>();
            int max = 0;
            //计算i节点到j节点各节点的斜率
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int diffx =  x1 - x2;
                int diffy =  y1 - y2;
                //求出最大公约数
                int com = gcd(diffx,diffy);
                //斜率表示(x,y分别除以最大公约数化简,避免小数的问题)
                String key = (diffx / com) + "_" + (diffy / com);
                map.put(key,map.getOrDefault(key,0) + 1);
                max = Math.max(max,map.get(key));
            }
            ans = Math.max(ans,max + 1);//加上i节点
        }

        return ans;
    }

    //获取a,b的最大公约数
    private int getGreatestCommonDivisor(int a,int b) {
        return b == 0 ? a : getGreatestCommonDivisor(b,a % b);
    }


    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{-9,-651},{-4,-4},{-8,-582},{9,591},{-3,3}};
        System.out.println(new Code149().maxPoints(points));

        System.out.println(3/7 + "_");
    }
}
