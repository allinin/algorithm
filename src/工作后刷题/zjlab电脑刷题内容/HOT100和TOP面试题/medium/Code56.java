package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Code56 {

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals,(a,b) -> {
            if(a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            } else {
                return a[1] - b[1];
            }
        });
        List<int[]> res = new ArrayList<>();
        int[] pre = intervals[0];
        for(int i = 1; i < intervals.length;i++) {
            int[] now = intervals[i];
            //没有重合
            if(now[0] > pre[1]){
                res.add(new int[] {pre[0],pre[1]});
                pre = now;
            } else {
                pre[1] = Math.max(pre[1],now[1]);
            }
        }
        //最后一个再添加进结果集
        res.add(pre);
        return res.toArray(new int[0][2]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = new Code56().merge(arr);
        for(int[] a : merge) {
            for(int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
