package Leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 448. 找到所有数组中消失的数字
给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例:

输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]
 * @date 2020/7/3 22:05
 */
public class Solution448 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<>();
        if(nums==null || nums.length==0) return list;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==i+1){
                continue;
            }
            if(nums[i]<=n)
                swap(nums,i,nums[i]-1);
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1)
                list.add(nums[i]);
        }
        return list;
    }

    private static void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{4,3,2,7,8,2,3,1};
        List<Integer> list = findDisappearedNumbers(nums);
        for(Integer num:list){
            System.out.println(num);
        }

    }
}
