package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.网格dp;

import java.util.Arrays;
import java.util.List;

/**
 * 三角形
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * <p>
 * 输入：triangle = [[-10]]
 * 输出：-10
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 *
 * @author: ZBL
 * @date: 2024-11-20  18:59
 */
public class Code120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] preDp = new int[triangle.get(size - 1).size()];
        for (int i = 0; i < preDp.length; i++) {
            preDp[i] = triangle.get(size - 1).get(i);
        }
        int[] nowDp = preDp;
        for (int i = size - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            nowDp = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                nowDp[j] = list.get(j) + Math.min(preDp[j], preDp[j + 1]);
            }
            preDp = nowDp;
        }
        return nowDp[0];
    }

}
