package 工作后刷题.zjlab电脑刷题内容.二分查找.第k大小.hard;

/**
 * @Author: ZBL
 * @Date: 2024-01-24  15:21
 *  两个有序数组的第k小乘积(hard)
 * 给你两个 从小到大排好序 且下标从 0 开始的整数数组 nums1 和 nums2 以及一个整数 k ，
 * 请你返回第 k （从 1 开始编号）小的 nums1[i] * nums2[j] 的乘积，
 * 其中 0 <= i < nums1.length 且 0 <= j < nums2.length 。
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [2,5], nums2 = [3,4], k = 2
 * 输出：8
 * 解释：第 2 小的乘积计算如下：
 * - nums1[0] * nums2[0] = 2 * 3 = 6
 * - nums1[0] * nums2[1] = 2 * 4 = 8
 * 第 2 小的乘积为 8 。
 * 示例 2：
 *
 * 输入：nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
 * 输出：0
 * 解释：第 6 小的乘积计算如下：
 * - nums1[0] * nums2[1] = (-4) * 4 = -16
 * - nums1[0] * nums2[0] = (-4) * 2 = -8
 * - nums1[1] * nums2[1] = (-2) * 4 = -8
 * - nums1[1] * nums2[0] = (-2) * 2 = -4
 * - nums1[2] * nums2[0] = 0 * 2 = 0
 * - nums1[2] * nums2[1] = 0 * 4 = 0
 * 第 6 小的乘积为 0 。
 * 示例 3：
 *
 * 输入：nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
 * 输出：-6
 * 解释：第 3 小的乘积计算如下：
 * - nums1[0] * nums2[4] = (-2) * 5 = -10
 * - nums1[0] * nums2[3] = (-2) * 4 = -8
 * - nums1[4] * nums2[0] = 2 * (-3) = -6
 * 第 3 小的乘积为 -6 。
 *
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 5 * 104
 * -105 <= nums1[i], nums2[j] <= 105
 * 1 <= k <= nums1.length * nums2.length
 * nums1 和 nums2 都是从小到大排好序的。
 */
public class Code2040 {

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        return 0;
    }
}
