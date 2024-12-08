package 工作后刷题.zjlab电脑刷题内容.打家劫舍系列;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 删除并获的点数 medium
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 *
 * @author: ZBL
 * @date: 2024-11-19  19:43
 */
public class Code740_done {

    int ans = 0;

    //超时了
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // nums中出现的不同数：这些不同数的和
        Set<Integer> set = new HashSet<>();
        Map<String, Integer> deleteMap = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
            set.add(num);
        }
        process(map, 0, set);
        return ans;
    }

    private int process(Map<Integer, Integer> map, int result, Set<Integer> set) {
        if (map.isEmpty()) {
            ans = Math.max(ans, result);
            return 0;
        }
        int tmp = 0;
        for (int num : set) {
            if (!map.containsKey(num)) {
                continue;
            }
            result += map.get(num);
            int r1 = map.get(num);
            int r2 = map.getOrDefault(num - 1, 0);
            int r3 = map.getOrDefault(num + 1, 0);
            map.remove(num);
            map.remove(num - 1);
            map.remove(num + 1);
            process(map, result, set);
            result -= r1;
            map.put(num, r1);
            if (r2 != 0) {
                map.put(num - 1, r2);
            }
            if (r3 != 0) {
                map.put(num + 1, r3);

            }
        }
        return tmp;

    }

    //打家截舍类似题目
    public int deleteAndEarn2(int[] nums) {
        int max = 0;
        //找出最大值
        for (int num : nums) {
            max = Math.max(num, max);
        }
        //表示idx位置的数的总和
        int[] sameValueSum = new int[max + 1];
        for (int num : nums) {
            sameValueSum[num] += num;
        }
        int[] dp = new int[max + 1];//表示删除前i个数字能够最大点数
        dp[1] = sameValueSum[1];
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sameValueSum[i]);//表示不取当前i值及取当前i值的最大值
        }
        return dp[max];
    }

    public static void main(String[] args) {
        System.out.println(new Code740_done().deleteAndEarn(new int[]{3, 4, 2}));
    }
}
