package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能将算法的时间复杂度降低到 O(nlog(n)) 吗?
 */
public class Code300 {

    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int n = nums.length;
        int[] dp = new int[n + 1];//以第i个元素结尾的最长子序列
        Arrays.fill(dp, 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] minEndArray = new int[n + 1];//最小结尾子数组
        Arrays.fill(minEndArray, Integer.MAX_VALUE);
        int effectLong = 1;
        for (int i = 0; i < n; i++) {
            int target = nums[i];
            //left,right分别是最小结尾子数组的起始位置与最后有效位置
            int left = 1, right = effectLong;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if(minEndArray[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            //如果当前位置的最小结尾小于目标值，目标值大于当前所有的最小结尾，最小结尾子数组扩充长度
            if(minEndArray[left] < target) {
                minEndArray[left + 1] = target;
                effectLong++;
            } else {
                //小于则说明当前最小结尾可以有更小的值
                minEndArray[left] = target;
            }
        }

        return effectLong;
    }

    //最小结尾子数组写法2
    public int lengthOfLIS3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] minEndArray = new int[n + 1];//最小结尾子数组
        Arrays.fill(minEndArray, Integer.MAX_VALUE);
        int effectLong = 1;
        for (int i = 0; i < n; i++) {
            int target = nums[i];
            //left,right分别是最小结尾子数组的起始位置与target最右可能的位置
            int left = 1, right = effectLong + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if(minEndArray[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            //left == effectLong + 1说明最小结尾子数组扩充长度
            if(left == effectLong + 1) {
                minEndArray[left] = target;
                effectLong++;
            } else {
                //小于则说明当前最小结尾可以有更小的值
                minEndArray[left] = target;
            }
        }

        return effectLong;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        System.out.println(new Code300().lengthOfLIS2(arr));
    }
}
