package 工作后刷题.zjlab电脑刷题内容.二分题目合集.最小化最大值;

/**
 * @Author: ZBL
 * @Date: 2024-01-24  15:13
 * 袋子里最少数目的球(medium)
 * 给你一个整数数组 nums ，其中 nums[i] 表示第 i 个袋子里球的数目。同时给你一个整数 maxOperations 。
 * <p>
 * 你可以进行如下操作至多 maxOperations 次：
 * <p>
 * 选择任意一个袋子，并将袋子里的球分到 2 个新的袋子中，每个袋子里都有 正整数 个球。
 * 比方说，一个袋子里有 5 个球，你可以把它们分到两个新袋子里，分别有 1 个和 4 个球，或者分别有 2 个和 3 个球。
 * 你的开销是单个袋子里球数目的 最大值 ，你想要 最小化 开销。
 * <p>
 * 请你返回进行上述操作后的最小开销。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [9], maxOperations = 2
 * 输出：3
 * 解释：
 * - 将装有 9 个球的袋子分成装有 6 个和 3 个球的袋子。[9] -> [6,3] 。
 * - 将装有 6 个球的袋子分成装有 3 个和 3 个球的袋子。[6,3] -> [3,3,3] 。
 * 装有最多球的袋子里装有 3 个球，所以开销为 3 并返回 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,8,2], maxOperations = 4
 * 输出：2
 * 解释：
 * - 将装有 8 个球的袋子分成装有 4 个和 4 个球的袋子。[2,4,8,2] -> [2,4,4,4,2] 。
 * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,4,4,4,2] -> [2,2,2,4,4,2] 。
 * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,4,4,2] -> [2,2,2,2,2,4,2] 。
 * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2] 。
 * 装有最多球的袋子里装有 2 个球，所以开销为 2 并返回 2 。
 * 示例 3：
 * <p>
 * 输入：nums = [7,17], maxOperations = 2
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= maxOperations, nums[i] <= 109
 */
public class Code1760 {

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int target, int[] nums, int operations) {
        long sum = 0l;
        for (int num : nums) {
            if (num <= target) {
                continue;
            }

            //数量大于target的袋子进行分割，每次拿出target个球，一共需要的次数
            sum += num % target == 0 ? num / target - 1 : num / target;
        }
        return sum <= operations;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {7,17};
        int maxOperations = 2;
        System.out.println(new Code1760().minimumSize(nums,maxOperations));
    }
}
