package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.*;

/**
 * 前k个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class Code347 {

    /**
     * 最小堆的方式，Nlog(k)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            priorityQueue.add(key);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] ans = new int[k];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            ans[index++] = priorityQueue.poll();
        }

        return ans;
    }

    /**
     * 桶排序的方式
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //出现频率作为下表，listArray[i]存放出现频率为i的元素
        List<Integer>[] listArray = new List[nums.length + 1];
        for (Integer num : map.keySet()) {
            int val = map.get(num);
            if (listArray[val] == null) {
                listArray[val] = new ArrayList<>();
            }
            listArray[val].add(num);
        }
        int index = 0;
        for (int i = nums.length; i >= 0 && k > 0; i--) {
            if (listArray[i] != null && listArray[i].size() > 0) {
                for(int j = 0;j < listArray[i].size() && k > 0;j++,k--) {
                    ans[index++] = listArray[i].get(j);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 2, 2, 4, 4, 4, 2, 3, 3};
        Arrays.stream(new Code347().topKFrequent2(arr, 3)).asLongStream()
                .forEach(p -> System.out.println(p));
    }
}
