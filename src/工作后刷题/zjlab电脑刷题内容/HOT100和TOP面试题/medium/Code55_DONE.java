package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class Code55_DONE {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int n = nums.length;
        int most = 0;//当前能够跳到的最远位置
        for(int i = 0;i < n;i++) {
            //最远位置小于i，无法到达i处，从而无法到达末尾
            if(most < i) {
                return false;
            }
            //更新most
            most = Math.max(most,i + nums[i]);
            if(most >= n - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(new Code55_DONE().canJump(nums));
    }
}
