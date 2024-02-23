package 工作后刷题.zjlab电脑刷题内容.二分题目合集.二分答案.medium;


import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2023-12-28  09:24
 *
 * 完成旅途的最少时间
 *
 * 给你一个数组 time ，其中 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间。
 *
 * 每辆公交车可以 连续 完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以 立马开始 下一趟旅途。
 * 每辆公交车 独立 运行，也就是说可以同时有多辆公交车在运行且互不影响。
 *
 * 给你一个整数 totalTrips ，表示所有公交车 总共 需要完成的旅途数目。
 * 请你返回完成 至少 totalTrips 趟旅途需要花费的 最少 时间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：time = [1,2,3], totalTrips = 5
 * 输出：3
 * 解释：
 * - 时刻 t = 1 ，每辆公交车完成的旅途数分别为 [1,0,0] 。
 *   已完成的总旅途数为 1 + 0 + 0 = 1 。
 * - 时刻 t = 2 ，每辆公交车完成的旅途数分别为 [2,1,0] 。
 *   已完成的总旅途数为 2 + 1 + 0 = 3 。
 * - 时刻 t = 3 ，每辆公交车完成的旅途数分别为 [3,1,1] 。
 *   已完成的总旅途数为 3 + 1 + 1 = 5 。
 * 所以总共完成至少 5 趟旅途的最少时间为 3 。
 * 示例 2：
 *
 * 输入：time = [2], totalTrips = 1
 * 输出：2
 * 解释：
 * 只有一辆公交车，它将在时刻 t = 2 完成第一趟旅途。
 * 所以完成 1 趟旅途的最少时间为 2 。
 *
 *
 * 提示：
 *
 * 1 <= time.length <= 105
 * 1 <= time[i], totalTrips <= 107
 */
public class Code2187 {
    public long minimumTime(int[] time, int totalTrips) {

        int n = time.length;
        if(n == 1) {
            return 1l * time[0] * totalTrips;
        }
        Arrays.sort(time);
        long max = Math.max(1l * time[0] * totalTrips,time[n - 1] * 1l);
        long min = 1l;
        while(min < max) {
            long mid = min +(max - min) / 2;
            if(check(mid,time,totalTrips)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
    private boolean check(long target,int[] time,int totalTrips) {
        long sum = 0l;
        for(int i = 0;i < time.length;i++) {
            sum += target / time[i];
        }
        return sum >= totalTrips;
    }

    public static void main(String[] args) {
        int[] time = new int[]{10000};
        int total = 10000000;
        System.out.println(new Code2187().minimumTime(time,total));
    }
}
