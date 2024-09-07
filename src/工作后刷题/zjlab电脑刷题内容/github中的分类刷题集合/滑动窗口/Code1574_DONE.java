package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.滑动窗口;

/**
 * @Author: ZBL
 * @Date: 2024-01-30  09:07
 * 删除最短的子数组使得剩余数组有序(medium)
 * 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
 * <p>
 * 一个子数组指的是原数组中连续的一个子序列。
 * <p>
 * 请你返回满足题目要求的最短子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,10,4,2,3,5]
 * 输出：3
 * 解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
 * 另一个正确的解为删除子数组 [3,10,4] 。
 * 示例 2：
 * <p>
 * 输入：arr = [5,4,3,2,1]
 * 输出：4
 * 解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
 * 示例 3：
 * <p>
 * 输入：arr = [1,2,3]
 * 输出：0
 * 解释：数组已经是非递减的了，我们不需要删除任何元素。
 * 示例 4：
 * <p>
 * 输入：arr = [1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * 0 <= arr[i] <= 10^9
 */
public class Code1574_DONE {

    //TODO 做的时候好费劲，一直有错，最后看了之前的答案才ac
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == n - 1) {
            return 0;
        }
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        int ans = Math.min(right, n - left - 1);
        int tmp1 = 0, tmp2 = right; //此时0-left单调，right - n-1单调
        while (tmp1 <= left && tmp2 < n) {
            if (arr[tmp1] <= arr[tmp2]) {
                ans = Math.min(ans, tmp2 - tmp1 - 1);
                tmp1++;
            } else {
                tmp2++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{16, 10, 0, 3, 22, 1, 14, 7, 1, 12, 15};
        System.out.println(new Code1574_DONE().findLengthOfShortestSubarray(arr));
    }
}
