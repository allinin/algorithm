package 工作后刷题.zjlab电脑刷题内容.跳跃游戏系列;

/**
 * 跳跃游戏II(medium)
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 *
 * @author: ZBL
 * @date: 2024-09-05  19:02
 */
public class Code44 {

    //方法一：
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = i;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            for (int j = i + 1; j <= Math.min(max, nums.length - 1); j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
            if (max >= nums.length - 1) {
                break;
            }
        }
        return dp[nums.length - 1];
    }

    public static int jump2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        //max表示当前可以到到的最远位置,end表示跳了ans步后可以到达的最远位置,preEnd表示跳ans -1时能够达到的最远位置
        int max = 0, ans = 0, target = nums.length - 1, end = 0, preEnd = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                preEnd = end;
                end = max;
                ans++;
            }
            if (max >= target) {
                if (i < end && preEnd != i) {
                    ans++;
                }
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(jump2(test));
    }
}
