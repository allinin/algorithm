package Leetcode;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/5/21 11:52
 */
public class Solution1 {

    public static int[] twoSum(int[] nums, int target) {
        int len=nums.length;
        int[] res=new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(nums[i],i);

        }
        for(int i=0;i<len;i++){
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i){
                res[0]=i;
                res[1]=map.get(target-nums[i]);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={3,2,4};
        int[] res=twoSum(arr,6);
        System.out.println(res[0]+" "+res[1]);
    }
}
