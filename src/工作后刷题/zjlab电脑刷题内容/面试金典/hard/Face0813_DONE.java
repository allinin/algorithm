package 工作后刷题.zjlab电脑刷题内容.面试金典.hard;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2024-01-09  14:24
 * 堆箱子。
 * 给你一堆n个箱子，箱子宽 wi、深 di、高 hi。
 * 箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。
 * 实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
 * <p>
 * 输入使用数组[wi, di, hi]表示每个箱子。
 * <p>
 * 示例1:
 * <p>
 * 输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
 * 输出：6
 * 示例2:
 * <p>
 * 输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
 * 输出：10
 * 提示:
 * <p>
 * 箱子的数目不大于3000个。
 */
public class Face0813_DONE {

    //最长上升子序列变种
    public int pileBox(int[][] box) {
        int ans = 0;
        //按照某一个维度进行排序，排序后将剩余的两个维度看做一个整体，则问题可以看做是一维的最长上升子序列问题了
        Arrays.sort(box, (a, b) -> a[1] - b[1]);
        int[] dp = new int[box.length];
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += box[i][2];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
