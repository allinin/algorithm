package 工作后刷题.zjlab电脑刷题内容.差分数组;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.TreeNode;

import java.util.*;

/**
 * @Author: ZBL
 * @Date: 2024-01-12  11:13
 * 花期内花的数目(hard)
 * 给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi]
 * 表示第 i 朵花的 花期 从 starti 到 endi （都 包含）。
 * 同时给你一个下标从 0 开始大小为 n 的整数数组 people ，people[i] 是第 i 个人来看花的时间。
 * <p>
 * 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
 * 输出：[1,2,2,2]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：flowers = [[1,10],[3,3]], people = [3,3,2]
 * 输出：[2,2,1]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= flowers.length <= 5 * 104
 * flowers[i].length == 2
 * 1 <= starti <= endi <= 109
 * 1 <= people.length <= 5 * 104
 * 1 <= people[i] <= 109
 */
public class Code2251 {

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] ans = new int[people.length];
        List<Integer> list = new ArrayList<>();
        for (int[] flower : flowers) {
            list.add(flower[0]);
            list.add(flower[1]);
        }

        for (int num : people) {
            list.add(num);
        }
        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        //离散化处理,最终的结果只与原数值的相对大小有关，根据原来的输入值进行大小编码，可以起到减少内存的作用
        for (int num : list) {
            if (!map.containsKey(num)) {
                map.put(num, idx++);
            }
        }
        DiffArray diffArray = new DiffArray(map.size());
        for(int[] flower : flowers) {
            diffArray.update(map.get(flower[0]),map.get(flower[1]),1);
        }

        int[] originArr = diffArray.getOriginArr();
        for(int i = 0;i < people.length;i++) {
            ans[i] = originArr[map.get(people[i])];
        }

        return ans;
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
            int maxValue = diffArr[0], nowValue = diffArr[0];
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
