public class Test {

    public int[] process(int[] arr,int target){
        int n = arr.length;
        int left = 0,right = n - 1;
        int[] ans = new int[2];
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        if(arr[left] != target){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }else{
            ans[0] = left;
        }
        left = 0;
        right = n - 1;
        while(left < right){
            int mid = left +(right - left + 1) / 2;
            if(arr[mid] <= target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        ans[1] = left;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,2,2,2,2};
        int[] ans = new Test().process(arr,-2);
        for(int num : ans){
        }
    }
}
