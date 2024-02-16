package 工作后刷题.zjlab电脑刷题内容.分类刷题合集.二分;


/**
 * @Author: ZBL
 * @Date: 2024-01-30  09:13
 * 修车最少时间(medium)
 * 给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。
 * 能力值为 r 的机械工可以在 r * n2 分钟内修好 n 辆车。
 * <p>
 * 同时给你一个整数 cars ，表示总共需要修理的汽车数目。
 * <p>
 * 请你返回修理所有汽车 最少 需要多少时间。
 * <p>
 * 注意：所有机械工可以同时修理汽车。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ranks = [4,2,3,1], cars = 10
 * 输出：16
 * 解释：
 * - 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
 * - 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
 * - 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
 * - 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * 16 分钟是修理完所有车需要的最少时间。
 * 示例 2：
 * <p>
 * 输入：ranks = [5,1,8], cars = 6
 * 输出：16
 * 解释：
 * - 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
 * - 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * - 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
 * 16 分钟时修理完所有车需要的最少时间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= ranks.length <= 105
 * 1 <= ranks[i] <= 100
 * 1 <= cars <= 106
 */
public class Code2594 {

    //二分答案
    public long repairCars(int[] ranks, int cars) {
        long left = 1l, right = 100l * 1000000000000l;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (check(mid, ranks, cars)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(long target, int[] ranks, int cars) {
        long sum = 0l;
        for (int rank : ranks) {
            sum += (long) Math.sqrt(target / rank);
        }
        return sum >= cars;
    }
}
