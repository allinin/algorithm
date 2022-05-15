package codeTop;

import java.util.ArrayList;

/**
 * LeetCode 280
 * 给一个没有排序的数组，将其重新排序成nums[0] <= nums[1] >= nums[2] <= nums[3]....的样子，要求in-place。
 *
 * 示例
 * 输入: nums = [3,5,2,1,6,4]
 * 输出: 一个可能的解答是 [3,5,1,6,2,4]
 */
public class wiggleSort {

    public static void wiggleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int n = arr.length;
        for(int i = 1;i < n;i++){
            if((i % 2 == 0 && arr[i] > arr[i - 1]) || (i % 2 == 1 && arr[i] < arr[i - 1])){
                int tmp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = tmp;
            }
        }
    }



    public static void main(String[] args) {
        int[] nums = new int[]{3,5,2,1,6,4};
        wiggleSort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());
    }
}
