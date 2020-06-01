package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。

示例 1：

输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。



提示：

1 <= k <= len(nums) <= 16
0 < nums[i] < 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/1 10:06
 */
public class Solution698 {

    public  static  boolean canPartitionKSubsets(int[] nums, int k) {
        int len=nums.length;
        if(len<k) return false;
        int count=0,max=0;
        for(int i=0;i<len;i++){
            count+=nums[i];
            max=Math.max(max,nums[i]);
        }
        if(count%k!=0) return false;
        int num=count/k;
        if(num<max) return false;
        boolean[] flag=new boolean[len];
        return process(nums,k,flag,num,num,0);

    }

    private static boolean process(int[] nums,int k,boolean[] flags,int target,int num,int start){//target：当前的目标值，num:总额目标值,start开始位置
        if(k==0)
            return true;
        if(target==0)
            return process(nums,k-1,flags,num,num,0);//当target==0时，开始时下一轮
        for(int i=start;i<nums.length;i++){
            if(!flags[i] && target-nums[i]>=0){
                flags[i]=true;
                if(process(nums,k,flags,target-nums[i],num,i+1)) return true;
                flags[i]=false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr={5,2,5,5,5,5,5,5,5,5,5,5,5,5,5,3};
        int k=15;
        System.out.println(canPartitionKSubsets(arr,k));


    }
}
