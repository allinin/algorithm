package 工作后刷题.zjlab电脑刷题内容.分类刷题集合.滑动窗口;

/**
 * @Author: ZBL
 * @Date: 2024-01-25  10:47
 * 区间子数组个数(medium)
 * 给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、
 * 非空且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。
 * <p>
 * 生成的测试用例保证结果符合 32-bit 整数范围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,4,3], left = 2, right = 3
 * 输出：3
 * 解释：满足条件的三个子数组：[2], [2, 1], [3]
 * 示例 2：
 * <p>
 * 输入：nums = [2,9,2,5,6], left = 2, right = 8
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= left <= right <= 109
 */
public class Code795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int ans = 0, leftEdge = 0, rightEdge = 0, preLessLeftIdx = -1;//连续小于left的数字的最左边界
        while (rightEdge < n) {
            if (nums[rightEdge] >= left && nums[rightEdge] <= right) {
                ans += (rightEdge - leftEdge + 1); //计算当前位置到leftEdge的子数组个数
                rightEdge++;
                preLessLeftIdx = -1;//连续小于left的数字的最左边界置为无效值
            } else if (nums[rightEdge] > right) {
                rightEdge++;
                leftEdge = rightEdge;
                preLessLeftIdx = -1;//连续小于left的数字的最左边界置为无效值
            } else {
                ans += rightEdge - leftEdge;//计算当前位置到leftEdge的子数组个数，因为当前位置不满足，所以这里没有+1
                //如果存在连续小于left的情况，则减去连续小于left的元素的数量
                if (preLessLeftIdx >= 0) {
                    ans -= rightEdge - preLessLeftIdx;
                } else {
                    preLessLeftIdx = rightEdge;
                }
                rightEdge++;
            }
        }
        return ans;
    }
}
