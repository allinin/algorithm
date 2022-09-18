package hot100;

public class LeetCode152 {

    public static int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int ans = max;
        int tmpMax = max;
        int tmpMin = min;
        for(int i = 1;i < nums.length;i++){
            tmpMax = max;
            tmpMin = min;
            if(nums[i] >= 0){
                max = Math.max(nums[i],tmpMax * nums[i]);
                min = Math.min(nums[i],tmpMin * nums[i]);
            }else {
                max = Math.max(nums[i],tmpMin * nums[i]);
                min = Math.min(nums[i],tmpMax * nums[i]);
            }
            ans = Math.max(ans,max);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,-2,-4};
        System.out.println(maxProduct(arr));
    }

}
