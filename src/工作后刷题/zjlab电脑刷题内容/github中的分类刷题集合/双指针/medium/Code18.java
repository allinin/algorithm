package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.双指针.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和(medium)
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 * @author: ZBL
 * @date: 2024-09-06  19:47
 */
public class Code18 {

    /**
     * code 15的基础上再包了一层，不过需要注意考虑超过Integer.MAX_VALUE的情况
     * @param nums
     * @param target
     * @return
     */

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (j > 1 + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int left = j + 1, right = len - 1;
                while (left < right) {
                    //这里是long,四数字之和可能超范围
                    long sum = nums[left] + nums[right];
                    if (sum + nums[j] + nums[i] < target) {
                        left++;
                    } else if (sum + nums[i] + nums[j] > target) {
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        int leftValue = nums[left++];
                        int rightValue = nums[right--];
                        while (left < right && nums[left] == leftValue) left++;
                        while (right > left && nums[right] == rightValue) right--;
                    }
                }
            }

        }
        return res;
    }
}
