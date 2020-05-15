package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/4/21 18:14
 */
public class Solution {

    public static boolean canJump(int[] nums) {
        if(nums==null || nums.length==0)
            return true;
        int len=nums.length;
        boolean[] dp=new boolean[len];
        dp[0]=true;
        //dp[1]=true;
        for(int i=0;i<len && dp[i]==true;i++){
            for(int j=1;j<=nums[i];j++){
                if(dp[len-1]==true)
                    return true;
                if(i+j>len-1)
                    continue;
                dp[i+j]=true;
            }


        }
        return dp[len-1];
    }

    //贪心
    public static boolean solution2(int[] nums){
        if(nums==null || nums.length==0)
            return true;
        int len=nums.length;
        int mostRight=0;
        for(int i=0;i<len;i++){
            if(i<=mostRight){
                mostRight=Math.max(mostRight,nums[i]+i);
            }
            if(mostRight>=len-1)
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        int [] arr=new int[]{3,2,1,0,4};
        System.out.println(canJump(arr));
    }
}
