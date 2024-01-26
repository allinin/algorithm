package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2024-01-11  09:39
 * <p>
 * 谷与峰
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。
 * 例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。
 * 现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 * <p>
 * 示例:
 * <p>
 * 输入: [5, 3, 1, 2, 3]
 * 输出: [5, 1, 3, 2, 3]
 * 提示：
 * <p>
 * nums.length <= 10000
 */
public class Face1011 {
    public void wiggleSort(int[] nums) {
        int[] help = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            help[i] = nums[i];
        }
        Arrays.sort(help);
        int idx = 0;
        for(int i = 0;i < nums.length;i += 2) {
            nums[i] = help[idx++];
        }
        for(int i = 1;i < nums.length;i += 2) {
            nums[i] = help[idx++];
        }
    }

    //一次遍历的方式
    public void wiggleSort2(int[] nums) {
       for(int i = 0;i < nums.length - 1;i++) {
           if(i % 2 == 0) {
               if(nums[i] > nums[i + 1]) {
                  swap(nums,i,i +1);
               }
           } else {
               //峰
               if(nums[i] < nums[i + 1]) {
                   swap(nums,i,i + 1);
               }
           }

       }
    }

    private void swap(int[] arr,int left,int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    //异或交换
    private void swap2(int[] arr,int left,int right) {
        arr[left] ^= arr[right];
        arr[right] ^= arr[left];
        arr[left] ^= arr[right];
    }
}
