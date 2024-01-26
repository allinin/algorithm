package 工作后刷题.zjlab电脑刷题内容.差分数组;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.PriorityQueue;

/**
 * @Author: ZBL
 * @Date: 2024-01-12  09:20
 * <p>
 * 生存人数(medium)
 * <p>
 * 给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，实现一个方法以计算生存人数最多的年份。
 * <p>
 * 你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。如果一个人在某一年的任意时期处于生存状态，
 * 那么他应该被纳入那一年的统计中。例如，生于 1908 年、死于 1909 年的人应当被列入 1908 年和 1909 年的计数。
 * <p>
 * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * birth = [1900, 1901, 1950]
 * death = [1948, 1951, 2000]
 * 输出： 1901
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 < birth.length == death.length <= 10000
 * birth[i] <= death[i]
 */
public class Face1610 {


    //仿照了218天际线问题的做法
    public int maxAliveYear(int[] birth, int[] death) {
        int[][] mergeInfos = new int[birth.length * 2][2];
        for (int i = 0; i < birth.length; i++) {
            mergeInfos[i][0] = birth[i];
            mergeInfos[i][1] = i;
        }
        for (int j = 0; j < death.length; j++) {
            mergeInfos[j + death.length][0] = death[j] * (-1);
            mergeInfos[j + death.length][1] = j;
        }
        Arrays.sort(mergeInfos, (a, b) -> Math.abs(a[0]) - Math.abs(b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> death[a] - death[b]);
        int ans = 0, maxSize = 0;
        for (int i = 0; i < mergeInfos.length; i++) {
            //新人出生
            if (mergeInfos[i][0] > 0) {
                if (queue.isEmpty() || death[queue.peek()] >= mergeInfos[i][0]) {
                    queue.add(mergeInfos[i][1]);
                    if (maxSize < queue.size()) {
                        maxSize = queue.size();
                        ans = mergeInfos[i][0];
                    }
                } else {
                    while (!queue.isEmpty() && death[queue.peek()] < mergeInfos[i][0]) {
                        queue.poll();
                    }
                    queue.add(mergeInfos[i][1]);
                }
            } else {
                //死亡
//                queue.remove(mergeInfos[i][1]);
                //死亡时间先到达的一定在队列头部，直接poll就可以了。
                queue.poll();
            }
        }

        return ans;
    }

    //方法二：差分数组的方式
    public int maxAliveYear2(int[] birth, int[] death) {

        DiffArray diffArray = new DiffArray(102);
        for (int i = 0; i < birth.length; i++) {
            diffArray.update(birth[i] - 1900, death[i] - 1900, 1);
        }
        return diffArray.getMaxIndex() + 1900;
    }

    class DiffArray {

        //差分数组
        int[] diffArr;

        //构建一个初始值为0的差分数组
        public DiffArray(int n) {
            this.diffArr = new int[n];
        }

        //根据原数组arr构建差分数组
        public DiffArray(int[] arr) {
            this.diffArr = new int[arr.length];
            diffArr[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                diffArr[i] = arr[i] - arr[i + 1];
            }
        }

        //原数组[i,j]范围的元素增加delta
        public void update(int i, int j, int delta) {
            diffArr[i] += delta;
            if (j + 1 < diffArr.length) {
                diffArr[j + 1] -= delta;
            }
        }

        //获取更新后的原数组
        public int[] getOriginArr() {
            int[] origin = new int[diffArr.length];
            origin[0] = diffArr[0];
            for (int i = 1; i < origin.length; i++) {
                origin[i] = origin[i - 1] + diffArr[i];
            }
            return origin;
        }

        //获取不断更新操作后，原数组最大值所在的索引，如果有多个，返回最小的索引
        public int getMaxIndex() {
            int ans = 0;
            int maxValue = diffArr[0],nowValue = diffArr[0];
            for (int i = 1; i < diffArr.length; i++) {
                nowValue += diffArr[i];
                if (nowValue > maxValue) {
                    maxValue = nowValue;
                    ans = i;
                }
            }
            return ans;
        }
    }
}