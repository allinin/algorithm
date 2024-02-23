package 工作后刷题.zjlab电脑刷题内容.二分题目合集.二分答案.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-24  15:10
 * <p>
 * 准时到达的列车最小速度(medium)
 * 给你一个浮点数 hour ，表示你到达办公室可用的总通勤时间。要到达办公室，你必须按给定次序乘坐 n 趟列车。
 * 另给你一个长度为 n 的整数数组 dist ，其中 dist[i] 表示第 i 趟列车的行驶距离（单位是千米）。
 * <p>
 * 每趟列车均只能在整点发车，所以你可能需要在两趟列车之间等待一段时间。
 * <p>
 * 例如，第 1 趟列车需要 1.5 小时，那你必须再等待 0.5 小时，搭乘在第 2 小时发车的第 2 趟列车。
 * 返回能满足你准时到达办公室所要求全部列车的 最小正整数 时速（单位：千米每小时），如果无法准时到达，则返回 -1 。
 * <p>
 * 生成的测试用例保证答案不超过 107 ，且 hour 的 小数点后最多存在两位数字 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：dist = [1,3,2], hour = 6
 * 输出：1
 * 解释：速度为 1 时：
 * - 第 1 趟列车运行需要 1/1 = 1 小时。
 * - 由于是在整数时间到达，可以立即换乘在第 1 小时发车的列车。第 2 趟列车运行需要 3/1 = 3 小时。
 * - 由于是在整数时间到达，可以立即换乘在第 4 小时发车的列车。第 3 趟列车运行需要 2/1 = 2 小时。
 * - 你将会恰好在第 6 小时到达。
 * 示例 2：
 * <p>
 * 输入：dist = [1,3,2], hour = 2.7
 * 输出：3
 * 解释：速度为 3 时：
 * - 第 1 趟列车运行需要 1/3 = 0.33333 小时。
 * - 由于不是在整数时间到达，故需要等待至第 1 小时才能搭乘列车。第 2 趟列车运行需要 3/3 = 1 小时。
 * - 由于是在整数时间到达，可以立即换乘在第 2 小时发车的列车。第 3 趟列车运行需要 2/3 = 0.66667 小时。
 * - 你将会在第 2.66667 小时到达。
 * 示例 3：
 * <p>
 * 输入：dist = [1,3,2], hour = 1.9
 * 输出：-1
 * 解释：不可能准时到达，因为第 3 趟列车最早是在第 2 小时发车。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == dist.length
 * 1 <= n <= 105
 * 1 <= dist[i] <= 105
 * 1 <= hour <= 109
 * hours 中，小数点后最多存在两位数字
 */
public class Code1870 {

    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1, right = 10000000;//因为hour保留两位小数，所以最小便是x.01,dist[i]最大为100000,所以这里最大取10000000
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, dist, hour)) {
                right = mid;

            } else {
                left = mid + 1;
            }
        }
        if (check(left, dist, hour)) {
            return left;
        }
        return -1;
    }

    private boolean check(int target, int[] dist, double hour) {
        double sum = 0d;
        for (int i = 0; i < dist.length; i++) {
            if (i != dist.length - 1) {
                sum += dist[i] % target == 0 ? dist[i] / target : dist[i] / target + 1;
            } else {
                sum += 1.0d * dist[i] / target; //保留小数
            }
        }
        return sum <= hour;
    }
    public static void main(String[] args) {
        int[] dist = new int[]{1, 3, 2};
        double hour = 1.9;
        System.out.println(new Code1870().minSpeedOnTime(dist, hour));
    }
}
