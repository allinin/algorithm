package Leetcode.背包dp;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

 

示例：

输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
解释：

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。
 

提示：

数组非空，且长度不会超过 20 。
初始的数组的和不会超过 1000 。
保证返回的最终结果能被 32 位整数存下。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/target-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/25 13:21
 */
public class Solution494 {

    public int findTargetSumWays(int[] nums, int S) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if((sum+S)%2!=0 || sum<S)
            return 0;
        int target=(sum+S)/2;
        int[] dp=new int[target+1];//前i个元素，组合得到和为j一共有多少种方案
        for(int i=0;i<=n;i++){
            dp[0]=1;//和为0的组合一共有1种
        }

        for(int i=1;i<=n;i++){
            for(int j=target;j>=0;j--){
                if(j-nums[i-1]>=0)
                    dp[j]+=dp[j-nums[i-1]];
            }
        }
        return dp[target];

    }

    public static void main(String[] args) {
        int[] nums={1,1,1,1,1};
        System.out.println(new Solution494().findTargetSumWays(nums,3));
    }
}
