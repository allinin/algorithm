package 工作后刷题.zjlab电脑刷题内容.二分题目合集.二分答案.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-24  15:11
 * <p>
 * 在D天内送达包裹的能力(medium)
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。
 * 我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * <p>
 * 输入：weights = [3,2,2,4,1,4], days = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 * <p>
 * 输入：weights = [1,2,3,1,1], days = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= days <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 */
public class Code1011 {

    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = 0, min = 1;
        for (int i = 0; i < n; i++) {
            max += weights[i];
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (check(mid, weights, days)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean check(int target, int[] weights, int days) {
        int sum = 0, ans = 1;
        for (int i = 0; i < weights.length; i++) {
            if(weights[i] > target) {
                return false;
            }
            if (sum + weights[i] <= target) {
                sum += weights[i];
            } else {
                sum = weights[i];
                ans++;
            }
        }
        return ans <= days;
    }
}
