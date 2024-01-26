package 工作后刷题.zjlab电脑刷题内容.最长上升子序列系列;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2024-01-10  10:17
 * 无重叠区间(hard)
 * <p>
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
 * 返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * <p>
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * <p>
 * 输入: intervals = [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= intervals.length <= 105
 * intervals[i].length == 2
 * -5 * 104 <= starti < endi <= 5 * 104
 */
public class Code435 {

    //超时
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int max = 1;
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);

        }
        return intervals.length - max;
    }

    //O(nlogn) 通过
    public int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
            //或者直接 a[0]-b[0]也是可以的
        });
        int[] dp = new int[intervals.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = intervals[0][1];
        int len = 1;
        for (int i = 1; i < intervals.length; i++) {
            int left = 1, right = len + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] <= intervals[i][0]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == len + 1) {
                len++;
                dp[len] = intervals[i][1];
            } else {
                if (dp[left] > intervals[i][1]) {
                    dp[left] = intervals[i][1];
                }
            }

        }
        return intervals.length - len;
    }

        //贪心的方法
        public int eraseOverlapIntervals3(int[][] intervals) {
            if(intervals == null || intervals.length == 0){
                return 0;
            }
            Arrays.sort(intervals,(a,b) -> {
                return a[1] - b[1];
            });
            int ans = 1;
            int right = intervals[0][1];
            for(int i = 1;i < intervals.length;i++){
                if(right <= intervals[i][0]){
                    ans++;
                    right = intervals[i][1];
                }
            }
            return intervals.length - ans;
        }


    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        System.out.println(new Code435().eraseOverlapIntervals2(intervals));
    }
}
