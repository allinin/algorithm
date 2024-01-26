package 工作后刷题.zjlab电脑刷题内容.二分查找.第k大小.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: ZBL
 * @Date: 2023-12-27  14:05
 * <p>
 * 查找和最小的k对数
 * <p>
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * <p>
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 * <p>
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 * <p>
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1 和 nums2 均为 升序排列
 * 1 <= k <= 104
 * k <= nums1.length * nums2.length
 */
public class Code373 {


    //方法一:优先级队列的方式(超时了)
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - a[0] - a[1]);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int[] tmp = new int[]{nums1[i], nums2[j]};
                priorityQueue.add(tmp);
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
        }
        while (!priorityQueue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int[] tmp = priorityQueue.poll();
            list.add(tmp[0]);
            list.add(tmp[1]);
            res.add(list);
        }
        return res;
    }

    //二分的方式，与378题类似
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        int left = nums1[0] + nums2[0], right = nums1[m - 1] + nums2[n - 1];
        int targetSum = right;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(k, nums1, nums2, mid)) {
                right = mid;
                targetSum = mid;
            } else {
                left = mid + 1;
            }
        }

        int pos = n - 1;
        /*找到小于目标值 pairSum 的数对*/
        for (int i = 0; i < m; i++) {
            while (pos >= 0 && nums1[i] + nums2[pos] >= targetSum) {
                pos--;
            }
            for (int j = 0; j <= pos && k > 0; j++, k--) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                res.add(list);
            }
        }

        //等于targetSum的数量
        pos = n - 1;
        for (int i = 0; i < m && k > 0; i++) {
            int start1 = i;
            while (i < m - 1 && nums1[i] == nums1[i + 1]) {
                i++;
            }
            while (pos >= 0 && nums1[i] + nums2[pos] > targetSum) {
                pos--;
            }
            int start2 = pos;
            while (pos > 0 && nums2[pos] == nums2[pos - 1]) {
                pos--;
            }
            if (nums1[i] + nums2[pos] != targetSum) {
                continue;
            }
            int count = (int) Math.min(k, (long) (i - start1 + 1) * (start2 - pos + 1));
            for (int j = 0; j < count && k > 0; j++, k--) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[pos]);
                res.add(list);
            }
        }

        return res;

    }

    private boolean check(int k, int[] nums1, int[] nums2, int target) {
        int left = 0, right = nums2.length - 1;
        long sum = 0;//可能超过int的范围
        while (left < nums1.length && right >= 0) {
            if (nums1[left] + nums2[right] <= target) {
                sum += (right + 1);
                left++;
            } else {
                right--;
            }
        }
        return sum >= k;
    }

}
