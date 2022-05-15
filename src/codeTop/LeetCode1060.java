package codeTop;

/**
 * 现有一个按 升序 排列的整数数组 nums ，其中每个数字都 互不相同 。
 *
 * 给你一个整数 k ，请你找出并返回从数组最左边开始的第 k 个缺失数字。
 * 例如：A[4,7,9,10],K = 1  ===> ans = 5
 */
public class LeetCode1060 {

    public  static int missingElement(int[] arr,int k){
        int n = arr.length;
        if(k > process(n - 1,arr)){
            return arr[n - 1] + k - process(n - 1,arr);
        }
        int left = 0,right = n - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(process(mid,arr) < k){
                left = mid + 1;
            }else {
                //此时process(mid,arr) >= k,继续循环，则最终while结束的时候返回的是距离arr[0]丢失k个元素的最左边的元素
                right = mid;
            }
        }
        return arr[left - 1] + k - process(left - 1,arr);
    }

    /**
     * 表示nums数组的第idx位到第0位丢失了几个数字
     * @param idx
     * @param nums
     * @return
     */
    private static int process(int idx,int[] nums){
        return nums[idx] - nums[0] - idx;
    }

    public static void main(String[] args) {
        System.out.println(missingElement(new int[]{4,7,8,10},2));
    }
}
