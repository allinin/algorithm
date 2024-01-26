package 工作后刷题.zjlab电脑刷题内容.二分查找.二分答案.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-24  15:14
 * 制作m束花所需的最少天数(medium)
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * <p>
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * <p>
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 * <p>
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 1
 * 输出：3
 * 解释：让我们一起观察这三天的花开过程，x 表示花开，而 _ 表示花还未开。
 * 现在需要制作 3 束花，每束只需要 1 朵。
 * 1 天后：[x, _, _, _, _]   // 只能制作 1 束花
 * 2 天后：[x, _, _, _, x]   // 只能制作 2 束花
 * 3 天后：[x, _, x, _, x]   // 可以制作 3 束花，答案为 3
 * 示例 2：
 * <p>
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 2
 * 输出：-1
 * 解释：要制作 3 束花，每束需要 2 朵花，也就是一共需要 6 朵花。而花园中只有 5 朵花，无法满足制作要求，返回 -1 。
 * 示例 3：
 * <p>
 * 输入：bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * 输出：12
 * 解释：要制作 2 束花，每束需要 3 朵。
 * 花园在 7 天后和 12 天后的情况如下：
 * 7 天后：[x, x, x, x, _, x, x]
 * 可以用前 3 朵盛开的花制作第一束花。但不能使用后 3 朵盛开的花，因为它们不相邻。
 * 12 天后：[x, x, x, x, x, x, x]
 * 显然，我们可以用不同的方式制作两束花。
 * 示例 4：
 * <p>
 * 输入：bloomDay = [1000000000,1000000000], m = 1, k = 1
 * 输出：1000000000
 * 解释：需要等 1000000000 天才能采到花来制作花束
 * 示例 5：
 * <p>
 * 输入：bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * bloomDay.length == n
 * 1 <= n <= 10^5
 * 1 <= bloomDay[i] <= 10^9
 * 1 <= m <= 10^6
 * 1 <= k <= n
 */
public class Code1482 {

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        //注意这里的m*k可能超过int的范围，所以需要转化为long,或者采用n / k < m的形式
        if (1l * m * k < n) {
            return -1;
        }
        int left = Integer.MAX_VALUE, right = 0;
        for (int bloom : bloomDay) {
            right = Math.max(bloom, right);
            left = Math.min(left,bloom);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, bloomDay, m, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int target, int[] bloomDay, int m, int k) {
        int tmp = k;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= target) {
                if (--tmp == 0) {
                    tmp = k;
                    m--;
                    if (m == 0) {
                        return true;
                    }
                }
            } else {
                tmp = k;
            }
        }
        return false;
    }


}
