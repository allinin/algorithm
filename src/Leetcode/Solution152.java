package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。



示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。

示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/4/28 10:56
 */
public class Solution152 {

    public static int maxProduct(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int len=nums.length;
        int[] dpmin=new int[len+1];//以数组中每一个数结尾的最小乘积子数组
        int[] dpmax=new int[len+1];//以数组中每一个数结尾的最大乘积子数组

        dpmin[1]=nums[0];
        dpmax[1]=nums[0];
        int max=nums[0];
        for(int i=2;i<=len;i++){
            if(nums[i-1]<0){//遇到负数的时候，最大的变成最小的，最小的变成最大的
                int temp=dpmin[i-1];
                dpmin[i-1]=dpmax[i-1];
                dpmax[i-1]=temp;
            }
            dpmax[i]=Math.max(nums[i-1],dpmax[i-1]*nums[i-1]);
            dpmin[i]=Math.min(nums[i-1],dpmin[i-1]*nums[i-1]);
            max=Math.max(max,dpmax[i]);
        }


        return max;
    }

    public static void main(String[] args) {
        int[] nums={-2,3,-4};
        System.out.println(maxProduct(nums));
    }
}
