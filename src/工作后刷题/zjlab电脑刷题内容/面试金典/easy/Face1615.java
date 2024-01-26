package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

import java.awt.*;

/**
 * @Author: ZBL
 * @Date: 2024-01-15  09:32
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 *
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 *
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，
 * 其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 *
 * 示例：
 *
 * 输入： solution="RGBY",guess="GGRR"
 * 输出： [1,1]
 * 解释： 猜中1次，伪猜中1次。
 * 提示：
 *
 * len(solution) = len(guess) = 4
 * solution和guess仅包含"R","G","B","Y"这4种字符
 */
public class Face1615 {
    public int[] masterMind(String solution, String guess) {
        int[] ans = new int[2];
        int[] help1 = new int[4];
        int[] help2 = new int[4];
        for(int i = 0;i < 4;i++) {
            char sc = solution.charAt(i);
            char gc = guess.charAt(i);

            if(sc == gc) {
                ans[0]++;
            }
            if(sc == 'R') {
                help1[0]++;
            }
            if(sc == 'G') {
                help1[1]++;
            }
            if(sc == 'B') {
                help1[2]++;
            }
            if(sc == 'Y') {
                help1[3]++;
            }

            if(gc == 'R') {
                help2[0]++;
            }
            if(gc == 'G') {
                help2[1]++;
            }
            if(gc == 'B') {
                help2[2]++;
            }
            if(gc == 'Y') {
                help2[3]++;
            }
        }
        for(int i = 0;i <4;i++) {
            ans[1] += Math.min(help1[i],help2[i]);
        }
        ans[1] -= ans[0];
        return ans;
    }
}
