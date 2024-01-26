package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.easy;

/**
 * @Author: ZBL
 * @Date: 2023-12-29  10:41
 * <p>
 * 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 3：
 * <p>
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 4：
 * <p>
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 * <p>
 * <p>
 * 进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 */
public class Code268 {

    //进阶实现
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i]++;
        }
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]);
            if(idx < n + 1){
                nums[idx - 1] *= (-1);
            }
        }

        for(int i = 0;i < n;i++) {
            if(nums[i] > 0) {
                return i;
            }
        }


        return n;

    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Code268().missingNumber(new int[]{1, 3, 0}));
    }
}
