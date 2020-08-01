package Leetcode.数组;

import java.util.Stack;

/**
 * @author zbl
 * @version 1.0
 * @content:给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。

求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。

说明: 请尽可能地优化你算法的时间和空间复杂度。

示例 1:

输入:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
输出:
[9, 8, 6, 5, 3]
示例 2:

输入:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
输出:
[6, 7, 6, 0, 4]
示例 3:

输入:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
输出:
[9, 8, 9]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/create-maximum-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/7/31 22:55
 */
public class Solution321 {

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if((nums1==null || nums1.length==0) && (nums2==null || nums2.length==0))
            return new int[0];
        int m=nums1.length;
        int n=nums2.length;
        int [] res=new int[k];
        if(k==m+n){
            return getMax(k,nums1,nums2);
        }else{ //k<m+n;
            for(int i=0;i<=k;i++){//从nums1中取i个数
                if(m-i>=0 && n-k+i>=0){
                    int[] ans1=process(nums1,m-i);
                    int[] ans2=process(nums2,n-k+i);
                    int[] ans=getMax(k,ans1,ans2);
                    if(!isBiger(res,ans)) res=ans;
                }
            }
        }
        return res;

    }

    private static int[] getMax(int k,int[] nums1,int[] nums2){
        if(nums1==null || nums2==null){
            return nums2==null ? nums1:nums2;
        }
        int[] res=new int[k];
        int left=0,right=0;
        int index=0;
        int m=nums1.length;
        int n=nums2.length;
        while(left<m && right<n){
            if(nums1[left]>nums2[right]){
                res[index++]=nums1[left];
                left++;
            }else if(nums1[left]<nums2[right]){
                res[index++]=nums2[right++];
            }else{//相等的情况
                if(compare(nums1,nums2,left,right)){
                    res[index++]=nums1[left++];
                }else{
                    res[index++]=nums2[right++];
                }
            }
        }
        while(left<m){
            res[index++]=nums1[left++];
        }
        while(right<n){
            res[index++]=nums2[right++];
        }
        return res;
    }

    //长度为n的数组中，去掉k个数字，使他们组成的数值最大
    private static int[] process(int[] nums,int k){
        int n=nums.length;
        int[] res=new int[n-k];
        if(k==0) return nums;
        if(k==n) return null;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            int num=nums[i];
            while(!stack.isEmpty() && k>0 && stack.peek()<num){
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        while(k>0){
            stack.pop();
            k--;
        }
        int len=res.length-1;
        while(!stack.isEmpty()){
            res[len--]=stack.pop();
        }
        return res;
    }

    //长度相同的nums1与nums2,是否num1形成的数字大于nums2形成的数字
    private static boolean isBiger(int[] nums1,int[] nums2){
        int n=nums1.length;
        for(int i=0;i<n;i++){
            if(nums1[i]>nums2[i]) return true;
            if(nums1[i]<nums2[i]) return false;
            continue;
        }
        return false;

    }

    //当nums1与nums2分别在p1、p2位置相同的时候应该移动谁的坐标。true:移动p1
    private static boolean compare(int[] nums1,int[] nums2,int p1,int p2){
        int m=nums1.length;
        int n=nums2.length;
        while(p1<m && p2<n && nums1[p1]==nums2[p2]){
            p1++;
            p2++;
        }
        return p2==n ||(p1<m && nums1[p1]>nums2[p2]);
    }

    public static void main(String[] args) {
        int[] nums1={3,4,6,5};
        int[] nums2={9, 1, 2, 5, 8, 3};
        int[] ints = maxNumber(nums1, nums2, 5);
        for(int num:ints){
            System.out.println(num);
        }
    }


}
