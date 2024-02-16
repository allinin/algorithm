package 工作后刷题.zjlab电脑刷题内容.二分查找.二分答案.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-24  15:09
 * <p>
 * 每个小孩最多能分到多少糖果(medium)
 * 给你一个 下标从 0 开始 的整数数组 candies 。数组中的每个元素表示大小为 candies[i] 的一堆糖果。
 * 你可以将每堆糖果分成任意数量的子堆 ，但 无法 再将两堆合并到一起。
 * <p>
 * 另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到相同数量的糖果。每个小孩可以拿走至多一堆糖果，有些糖果可能会不被分配。
 * <p>
 * 返回每个小孩可以拿走的最大糖果数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：candies = [5,8,6], k = 3
 * 输出：5
 * 解释：可以将 candies[1] 分成大小分别为 5 和 3 的两堆，然后把 candies[2] 分成大小分别为 5 和 1 的两堆。
 * 现在就有五堆大小分别为 5、5、3、5 和 1 的糖果。可以把 3 堆大小为 5 的糖果分给 3 个小孩。可以证明无法让每个小孩得到超过 5 颗糖果。
 * 示例 2：
 * <p>
 * 输入：candies = [2,5], k = 11
 * 输出：0
 * 解释：总共有 11 个小孩，但只有 7 颗糖果，但如果要分配糖果的话，必须保证每个小孩至少能得到 1 颗糖果。因此，最后每个小孩都没有得到糖果，答案是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candies.length <= 105
 * 1 <= candies[i] <= 107
 * 1 <= k <= 1012
 */
public class Code2226 {

    public int maximumCandies(int[] candies, long k) {
        int left = 0, right = 0;
        for (int num : candies) {
            right = Math.max(num, right);
        }
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(mid, candies, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int mid, int[] candics, long k) {
        long sum = 0l;
        for (int num : candics) {
            sum += num / mid;
        }
        return sum >= k;
    }
}
