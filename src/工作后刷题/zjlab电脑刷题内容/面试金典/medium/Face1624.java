package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import javax.jnlp.ClipboardService;
import java.util.*;
import java.util.zip.DeflaterInputStream;

/**
 * @Author: ZBL
 * @Date: 2024-01-16  09:38
 * 数对和
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,6,5], target = 11
 * 输出: [[5,6]]
 * 示例 2:
 * <p>
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 * 提示：
 * <p>
 * nums.length <= 100000
 * -10^5 <= nums[i], target <= 10^5
 */
public class Face1624 {

    //排序后双指针
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                res.add(list);
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    //哈希
    public List<List<Integer>> pairSums2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (diff == nums[i]) {
                if (map.getOrDefault(diff, 0) >= 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[i]);
                    res.add(list);
                    map.put(nums[i], map.get(nums[i]) - 2);
                }

            } else {
                if (map.getOrDefault(diff, 0) >= 1 && map.getOrDefault(nums[i], 0) >= 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(diff);
                    res.add(list);
                    map.put(diff, map.get(diff) - 1);
                    map.put(nums[i], map.get(nums[i]) - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, -1, 0, 3, 5, 6, 7, 9, 13, 14};
        List<List<Integer>> lists = new Face1624().pairSums2(arr, 12);
        for (List<Integer> list : lists) {
            System.out.print(list.get(0) + "_" + list.get(1));
            System.out.println();
        }

    }
}
