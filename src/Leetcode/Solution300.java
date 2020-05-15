package Leetcode;

import java.util.ArrayList;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。

进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/5/4 13:11
 */
public class Solution300 {


        public static int lengthOfLIS(int[] nums) {

            if(nums==null || nums.length==0)
                return 0;
            int len=nums.length;
            int[] dp=new int[len];//代表长度为i+1的递增子序列的最小结尾
            dp[0]=nums[0];
            int l=0,r=0,right=1;//right代表dp的有效长度
            for(int i=1;i<len;i++){
                l=0;r=right;
                while(l<r){
                    int m=(l+r)>>>1;
                    if(nums[i]>dp[m]){
                        l=m+1;
                    }else{
                        r=m;
                    }
                }
                dp[l]=nums[i];
//                right=Math.max(right,l);
                if(l==right) right++;
            }
            return right;
        }

    public static void main(String[] args) {
        int[] arr=new int[]{10,9,2,5,3,7,101,18};
        //System.out.println(lengthOfLIS(arr));
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        res.add(new ArrayList<Integer>(list){{add(2);}});
        System.out.println(res.size());


     }
    }

