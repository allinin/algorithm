package 工作后刷题.zjlab电脑刷题内容.二分题目合集.最小化最大值;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZBL
 * @Date: 2023-12-26  13:55
 * <p>
 * 打家劫舍IV
 * <p>
 * 沿街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。
 * <p>
 * 由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。
 * <p>
 * 小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。
 * <p>
 * 给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。
 * <p>
 * 另给你一个整数 k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。
 * <p>
 * 返回小偷的 最小 窃取能力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,5,9], k = 2
 * 输出：5
 * 解释：
 * 小偷窃取至少 2 间房屋，共有 3 种方式：
 * - 窃取下标 0 和 2 处的房屋，窃取能力为 max(nums[0], nums[2]) = 5 。
 * - 窃取下标 0 和 3 处的房屋，窃取能力为 max(nums[0], nums[3]) = 9 。
 * - 窃取下标 1 和 3 处的房屋，窃取能力为 max(nums[1], nums[3]) = 9 。
 * 因此，返回 min(5, 9, 9) = 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,7,9,3,1], k = 2
 * 输出：2
 * 解释：共有 7 种窃取方式。窃取能力最小的情况所对应的方式是窃取下标 0 和 4 处的房屋。返回 max(nums[0], nums[4]) = 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= (nums.length + 1)/2
 */
public class Code2560_DONE {

    int ans = Integer.MAX_VALUE;

    //超出时间限制
    public int minCapability(int[] nums, int k) {
        for (int i = k; i <= (nums.length + 1) / 2; i++) {
            process(nums, 0, i, 0, 0);
        }
        for (int i = k; i <= (nums.length + 1) / 2; i++) {
            for (int start = 0; start < nums.length; start++) {

            }
        }

        return ans;
    }


    private void process(int[] nums, int index, int k, int nowNum, int max) {
        if (nowNum == k) {
            ans = Math.min(ans, max);
            return;
        }
        if (index >= nums.length) {
            return;
        }
        //剩余节点数量不够
        if ((k - nowNum - 1) * 2 >= nums.length) {
            return;
        }
        //下一次可以窃取的起始索引
        for (int i = index; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(max, nums[i]);
            process(nums, i + 2, k, nowNum + 1, max);
            max = tmp;
        }
    }

    Map<String, List<Integer>> map = new HashMap<>();

    //超出内存限制
    public int minCapability2(int[] nums, int k) {
        for (int i = k; i <= (nums.length + 1) / 2; i++) {
            List<Integer> list = process2(nums, 0, i, 0);
            list.forEach(p -> ans = Math.min(ans, p));
        }
        return ans;
    }

    private List<Integer> process2(int[] nums, int index, int k, int nowNum) {
        List<Integer> res = new ArrayList<>();
        if (nowNum == k) {
            return res;
        }
        String key = index + "_" + (k - nowNum);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        //下一次可以窃取的起始索引
        for (int i = index; i + (k - nowNum - 1) * 2 < nums.length; i++) {
            List<Integer> subRes = process2(nums, i + 2, k, nowNum + 1);
            int targetNum = nums[i];
            if (subRes.size() == 0) {
                res.add(targetNum);
            } else {
                subRes.forEach(p -> res.add(Math.max(p, targetNum)));
            }
            map.put(key, res);

        }
        return res;
    }

    //二分+dp的方式，最小化最大值
    public int minCapability3(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min,num);
            max = Math.max(max, num);
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (check(nums, mid, k)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean check(int[] nums, int mid, int k) {
        int[] dp = new int[nums.length + 1];//记录从0-i的房间中偷不超过mid的房屋的数量
        dp[1] = nums[0] <= mid ? 1 : 0;
        for (int i = 2; i <= nums.length; i++) {
            if(nums[i - 1] > mid) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 1],1 + dp[i - 2]);
            }
        }
        return dp[nums.length] >= k;
    }
    //对check的优化
    private boolean check2(int[] nums, int k, int mx) {
        int f0 = 0, f1 = 0;
        for (int x : nums) {
            if (x > mx) {
                f0 = f1;
            } else {
                int tmp = f1;
                f1 = Math.max(f1, f0 + 1);
                f0 = tmp;
            }
        }
        return f1 >= k;
    }


    public static void main(String[] args) {
        System.out.println(new Code2560_DONE().minCapability3(new int[]{5038, 3053, 2825, 3638, 4648, 3259, 4948, 4248, 4940, 2834, 109, 5224, 5097, 4708, 2162, 3438, 4152, 4134, 551, 3961, 2294, 3961, 1327, 2395, 1002, 763, 4296, 3147, 5069, 2156, 572, 1261, 4272, 4158, 5186, 2543, 5055, 4735, 2325, 1206, 1019, 1257, 5048, 1563, 3507, 4269, 5328, 173, 5007, 2392, 967, 2768, 86, 3401, 3667, 4406, 4487, 876, 1530, 819, 1320, 883, 1101, 5317, 2305, 89, 788, 1603, 3456, 5221, 1910, 3343, 4597}, 28));
        System.out.println(new Code2560_DONE().minCapability3(new int[]{2, 3, 5, 9}, 2));
    }
}
