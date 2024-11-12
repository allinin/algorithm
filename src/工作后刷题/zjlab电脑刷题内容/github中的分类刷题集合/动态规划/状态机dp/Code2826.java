package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.状态机dp;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * 将三个组排序 medium
 * 给你一个整数数组 nums 。nums 的每个元素是 1，2 或 3。在每次操作中，你可以删除 nums 中的一个元素。返回使 nums 成为 非递减 顺序所需操作数的 最小值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,3,2,1]
 * 输出：3
 * 解释：
 * 其中一个最优方案是删除 nums[0]，nums[2] 和 nums[3]。
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,2,1,3,3]
 * 输出：2
 * 解释：
 * 其中一个最优方案是删除 nums[1] 和 nums[2]。
 * 示例 3：
 * <p>
 * 输入：nums = [2,2,2,2,3,3]
 * 输出：0
 * 解释：
 * nums 已是非递减顺序的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 3
 * 进阶：你可以使用 O(n) 时间复杂度以内的算法解决吗？
 *
 * @author: ZBL
 * @date: 2024-11-12  19:30
 */
public class Code2826 {

    public int minimumOperations(List<Integer> nums) {
        int size = nums.size();
        int[] dp = new int[size]; //以第i个元素结尾的最长非递减子序列的长度
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (nums.get(j) <= nums.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return size - ans;
    }



    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(2, 1, 3, 2, 1);
        System.out.println(new Code2826().minimumOperations(list));
    }
}
