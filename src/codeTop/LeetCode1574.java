package codeTop;

public class LeetCode1574 {

    public static int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        int left = 0, right = len-1;
        while(left < len - 1 && arr[left] <= arr[left + 1]){
            left++;
        }
        while(right > 0 && arr[right] >= arr[right - 1]){
            right--;
        }
        if(right <= left){
            return 0;
        }
        //保留左边有序的或者右边有序的
        int ans = Math.min(right,len - left - 1);
        int l = right,r = len - 1;
        for(int i = 0;i <= left;i++){
            int target = arr[i];
            r = len - 1;
            l = Math.max(l,right);
            //l - r范围内寻找第一个大于等于target的值得坐标，这样的值不一定存在
            while(l < r){
                int mid = l + (r - l) / 2;
                if(arr[mid] < target){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
            if(arr[l] >= target){
                ans = Math.min(ans,r - i -1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,1,2,3,4,10,2};
        System.out.println(findLengthOfShortestSubarray(arr));
    }
}
