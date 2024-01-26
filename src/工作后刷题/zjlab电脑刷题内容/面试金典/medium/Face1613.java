package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-12  15:04
 * 平分正方形
 * <p>
 * 给定两个正方形及一个二维平面。请找出将这两个正方形分割成两半的一条直线。假设正方形顶边和底边与 x 轴平行。
 * <p>
 * 每个正方形的数据square包含3个数值，正方形的左下顶点坐标[X,Y] = [square[0],square[1]]，
 * 以及正方形的边长square[2]。所求直线穿过两个正方形会形成4个交点，
 * 请返回4个交点形成线段的两端点坐标（两个端点即为4个交点中距离最远的2个点，这2个点所连成的线段一定会穿过另外2个交点）。
 * 2个端点坐标[X1,Y1]和[X2,Y2]的返回格式为{X1,Y1,X2,Y2}，要求若X1 != X2，需保证X1 < X2，否则需保证Y1 <= Y2。
 * <p>
 * 若同时有多条直线满足要求，则选择斜率最大的一条计算并返回（与Y轴平行的直线视为斜率无穷大）。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * square1 = {-1, -1, 2}
 * square2 = {0, -1, 2}
 * 输出： {-1,0,2,0}
 * 解释： 直线 y = 0 能将两个正方形同时分为等面积的两部分，返回的两线段端点为[-1,0]和[2,0]
 * 提示：
 * <p>
 * square.length == 3
 * square[2] > 0
 */
public class Face1613 {
    class Solution {
        public double[] cutSquares(int[] square1, int[] square2) {
            // 圆心坐标
            double x1 = square1[0] + square1[2] / 2d, y1 = square1[1] + square1[2] / 2d;
            double x2 = square2[0] + square2[2] / 2d, y2 = square2[1] + square2[2] / 2d;
            if (x1 == x2) {// 垂直x轴，交点在上下边
                return new double[]{
                        x1,
                        Math.min(square1[1], square2[1]),
                        x1,
                        Math.max(square1[1] + square1[2], square2[1] + square2[2])
                };
            }
            //评分2个正方形的直线即为同时经过两个正方形中心的直线
            // y = k * x + b
            double k = (y2 - y1) / (x2 - x1);
            double b = y1 - k * x1;
            if (k >= -1 && k <= 1) {// 交点在左右边
                return new double[]{
                        Math.min(square1[0], square2[0]),
                        k * Math.min(square1[0], square2[0]) + b,
                        Math.max(square1[0] + square1[2], square2[0] + square2[2]),
                        k * Math.max(square1[0] + square1[2], square2[0] + square2[2]) + b
                };
            }
            // 交点在上下边
            double[] ans = new double[]{
                    (Math.min(square1[1], square2[1]) - b) / k,
                    Math.min(square1[1], square2[1]),
                    (Math.max(square1[1] + square1[2], square2[1] + square2[2]) - b) / k,
                    Math.max(square1[1] + square1[2], square2[1] + square2[2])
            };
            if (ans[0] < ans[2]) return ans;
            // 重排序，保证第一个点在左边
            return new double[]{ans[2], ans[3], ans[0], ans[1]};
        }
    }
}
