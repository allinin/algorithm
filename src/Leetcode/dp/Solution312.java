package Leetcode.dp;

/**
 * @author zbl
 * @version 1.0
 * @content:有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

求所能获得硬币的最大数量。

说明:

你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
示例:

输入: [3,1,5,8]
输出: 167
解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
通过次数16,358提交次数26,232
在真实的面试中遇到过这道题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/burst-balloons
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/7/19 11:00
 */
public class Solution312 {

    public static int maxCoins(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n=nums.length;
        int[] help=new int[n+2];
        help[0]=1;
        help[n+1]=1;
        for(int i=0;i<n;i++){
            help[i+1]=nums[i];
        }
        int[][] dp=new int[help.length][help.length];
        for(int i=1;i<=n;i++){
            for(int j=i;j>=1;j--){//戳破j-i范围内的气球
                if(i==j){
                    dp[i][j]=help[i]*help[i-1]*help[i+1];
                }else{
                    int max=Integer.MIN_VALUE;
                    for(int k=j;k<=i;k++){//最后戳破哪个气球
                        if(k==j){
                            max=Math.max(max,help[j]*help[j-1]*help[i+1]+dp[j+1][i]);
                        }else if(k==i){
                            max=Math.max(max,help[i]*help[j-1]*help[i+1]+dp[j][i-1]);
                        }else{
                            max=Math.max(max,dp[j][k-1]+dp[k+1][i]+help[i+1]*help[k]*help[j-1]);
                        }
                        dp[j][i]=max;
                    }
                }
            }
        }
        return dp[1][n];

    }

    public static void main(String[] args) {

        int[] nums={3,1,5,8};
        System.out.println(maxCoins(nums));
    }
}
