package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */
public class Code53 {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length;i++) {
            sum += nums[i];
            ans = Math.max(sum,ans);
            if(sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
    public int maxSubArray2(int[] nums) {
        return maxSubArrayByRange(nums,0,nums.length - 1);
    }
    //分治法：left - mid的最大子数组，mid+1 - right的最大子数组,以及一定包含mid,mid+1的最大子数组，三者中的最大者即为最终结果
    private int maxSubArrayByRange(int[] arr,int left,int right) {
        if(left > right) {
            return 0;
        }
        if(left == right) {
            return arr[left];
        }
        int mid = left + (right - left) / 2;
        return max3(maxSubArrayByRange(arr,left,mid),maxSubArrayByRange(arr,mid + 1,right)
        ,getSubArrayCrossedBoundary(arr,left,mid,right));
    }

    private int getSubArrayCrossedBoundary(int[] arr,int left,int mid,int right) {
        int leftSum = Integer.MIN_VALUE,rightSum = Integer.MIN_VALUE,sum = 0;
        //子数组的和一定是包含mid位置元素的子数组
        for(int i = mid ; i >= left;i--) {
            sum += arr[i];
            if(sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        //子数组的和一定是包含mid + 1位置元素的子数组
        for(int i = mid + 1 ; i <= right;i++) {
            sum += arr[i];
            if(sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    private int max3(int a,int b,int c) {
        return Math.max(a,Math.max(b,c));
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Code53().maxSubArray2(arr));
    }
}
