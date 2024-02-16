package 工作后刷题.zjlab电脑刷题内容.二分查找.最大化最小值;


/**
 * @Author: ZBL
 * @Date: 2023-12-28  09:22
 * <p>
 * 最大化城市的最小电量(hard)
 * <p>
 * 给你一个下标从 0 开始长度为 n 的整数数组 stations ，其中 stations[i] 表示第 i 座城市的供电站数目。
 * <p>
 * 每个供电站可以在一定 范围 内给所有城市提供电力。换句话说，如果给定的范围是 r ，
 * 在城市 i 处的供电站可以给所有满足 |i - j| <= r 且 0 <= i, j <= n - 1 的城市 j 供电。
 * <p>
 * |x| 表示 x 的 绝对值 。比方说，|7 - 5| = 2 ，|3 - 10| = 7 。
 * 一座城市的 电量 是所有能给它供电的供电站数目。
 * <p>
 * 政府批准了可以额外建造 k 座供电站，你需要决定这些供电站分别应该建在哪里，这些供电站与已经存在的供电站有相同的供电范围。
 * <p>
 * 给你两个整数 r 和 k ，如果以最优策略建造额外的发电站，返回所有城市中，最小电量的最大值是多少。
 * <p>
 * 这 k 座供电站可以建在多个城市。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：stations = [1,2,4,5,0], r = 1, k = 2
 * 输出：5
 * 解释：
 * 最优方案之一是把 2 座供电站都建在城市 1 。
 * 每座城市的供电站数目分别为 [1,4,4,5,0] 。
 * - 城市 0 的供电站数目为 1 + 4 = 5 。
 * - 城市 1 的供电站数目为 1 + 4 + 4 = 9 。
 * - 城市 2 的供电站数目为 4 + 4 + 5 = 13 。
 * - 城市 3 的供电站数目为 5 + 4 = 9 。
 * - 城市 4 的供电站数目为 5 + 0 = 5 。
 * 供电站数目最少是 5 。
 * 无法得到更优解，所以我们返回 5 。
 * 示例 2：
 * <p>
 * 输入：stations = [4,4,4,4], r = 0, k = 3
 * 输出：4
 * 解释：
 * 无论如何安排，总有一座城市的供电站数目是 4 ，所以最优解是 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == stations.length
 * 1 <= n <= 105
 * 0 <= stations[i] <= 105
 * 0 <= r <= n - 1
 * 0 <= k <= 109
 */
public class Code2528 {

    //超时了
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] help = new long[stations.length];
        long left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = Math.max(0, i - r); j <= Math.min(n - 1, i + r); j++) {
                help[i] += stations[j];
            }
            left = Math.min(left, help[i]);
            right = Math.max(right, help[i]);
        }
        right += k;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            if (check(mid, help, k,r)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(long target, long[] nums, int k,int r) {
        int sum = 0;
        long[] diff = new long[nums.length];
        for(int i = 0;i < nums.length;i++) {
            diff[i] = nums[i] - target;
        }
        for(int i = 0;i < nums.length;i++) {
            //当前电量差值小于0，说明需要发电站的辅助
            if(diff[i] >= 0) {
                continue;
            }
            //为了能够尽可能地帮助到后面的城市，在能够照顾到当前城市的最右边的城市处建立发电站
            int lastIndex = Math.min(i + r,nums.length - 1);
            long addNum = diff[i] * (-1);
            for(int j = Math.max(0,lastIndex - r);j <= Math.min(nums.length - 1,lastIndex + r);j++) {
                diff[j] += addNum;
            }
            sum += addNum;
        }
        return sum <= k;
    }

    //TODO 二分+前缀和+差分数组
    public long maxPower2(int[] stations, int r, int k) {
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{13,12,8,14,7};
        int k = 23,r =2;

        System.out.println(new Code2528().maxPower(arr,r,k));
    }
}
