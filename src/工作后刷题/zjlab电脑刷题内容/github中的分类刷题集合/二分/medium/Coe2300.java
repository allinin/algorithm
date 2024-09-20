package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二分.medium;

import java.util.Arrays;

/**
 * 咒语和药水的成功对数 medium
 * <p>
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
 * <p>
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 * <p>
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * 输出：[4,0,3]
 * 解释：
 * - 第 0 个咒语：5 * [1,2,3,4,5] = [5,10,15,20,25] 。总共 4 个成功组合。
 * - 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
 * - 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,9,12,15] 。总共 3 个成功组合。
 * 所以返回 [4,0,3] 。
 * 示例 2：
 * <p>
 * 输入：spells = [3,1,2], potions = [8,5,8], success = 16
 * 输出：[2,0,2]
 * 解释：
 * - 第 0 个咒语：3 * [8,5,8] = [24,15,24] 。总共 2 个成功组合。
 * - 第 1 个咒语：1 * [8,5,8] = [8,5,8] 。总共 0 个成功组合。
 * - 第 2 个咒语：2 * [8,5,8] = [16,10,16] 。总共 2 个成功组合。
 * 所以返回 [2,0,2] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == spells.length
 * m == potions.length
 * 1 <= n, m <= 105
 * 1 <= spells[i], potions[i] <= 105
 * 1 <= success <= 1010
 *
 * @author: ZBL
 * @date: 2024-09-20  18:31
 */
public class Coe2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        if (spells.length == 0) {
            return new int[0];
        }
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            long target = (success % spells[i] == 0 ? success / spells[i] : success / spells[i] + 1);
            if (target > potions[potions.length - 1]) {
                continue;
            } else if (target <= potions[0]) {
                ans[i] = potions.length;
            } else {
                int firstIndex = findFirstIndex(potions, target);
                if (firstIndex == potions.length) {
                    continue;
                }
                ans[i] = potions.length - firstIndex;
            }

        }
        return ans;
    }

    private int findFirstIndex(int[] potions, long target) {
        int left = 0, right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < target) {
                left = mid + 1;
            } else {
                // <= target
                right = mid;
            }
        }
        return left;
    }
}
