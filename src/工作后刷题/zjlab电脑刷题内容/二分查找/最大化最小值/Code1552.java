package 工作后刷题.zjlab电脑刷题内容.二分查找.最大化最小值;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2023-12-27  14:03
 * 两球之间的磁力
 * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
 * <p>
 * 已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
 * <p>
 * 给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：position = [1,2,3,4,7], m = 3
 * 输出：3
 * 解释：将 3 个球分别放入位于 1，4 和 7 的三个篮子，两球间的磁力分别为 [3, 3, 6]。最小磁力为 3 。我们没办法让最小磁力大于 3 。
 * 示例 2：
 * <p>
 * 输入：position = [5,4,3,2,1,1000000000], m = 2
 * 输出：999999999
 * 解释：我们使用位于 1 和 1000000000 的篮子时最小磁力最大。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == position.length
 * 2 <= n <= 10^5
 * 1 <= position[i] <= 10^9
 * 所有 position 中的整数 互不相同 。
 * 2 <= m <= position.length
 */
public class Code1552 {


    //最小值最大化:采用二分查找的方式，找出最小值可能的的范围，然后不断尝试选定的范围中的值是否符合要求。
    //本质就是一个不断尝试的过程
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int min = 1,max = position[position.length - 1] - position[0];
        while(min < max) {
            int mid = min + (max - min + 1) / 2;
            if(check(position,m,mid)) {
                min = mid;
            } else{
                //说明取mid,符合要求的球的数量小于k
                max = mid - 1;
            }
        }
        return min;
    }


    //校验排序数组中任意任意两球间的距离>= mid符合要求的球的数量
    private boolean check(int[] position, int m, int mid) {
        int num = 1,pre = position[0];
        for(int i = 1;i < position.length;i++) {
            if(position[i] - pre >= mid) {
                num++;
                pre = position[i];
            }
        }
        return num >= m;
    }
}
