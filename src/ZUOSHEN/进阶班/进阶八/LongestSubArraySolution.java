package ZUOSHEN.进阶班.进阶八;

/**
 * @author zbl
 * @version 1.0
 * @content: 给定一个数组arr,全是正数；一个整数aim,求累加和等于aim的最长子数组，额外空间复杂度O(1),时间复杂度O（N)
 * @date 2020/1/23 20:45
 */
public class LongestSubArraySolution {

    public static int maxLength(int[] arr,int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = 0;
        int sum = arr[0];
        while (right < arr.length) {
            if(sum<aim){
                right++;
                if(right==arr.length){
                    break;
                }
                sum+=arr[right];
            }else if(sum==aim){
                res=Math.max(res,right-left+1);
                sum+=(++right==arr.length) ? 0:arr[right];
            }else{
                sum-=arr[left++];
            }

        }
        return  res;
    }


    //相当于是使用了滑动窗口的方法
    public static int maxLength2(int[] arr,int k){
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else if (sum < k) {
                right++;
                if (right == arr.length) {//边界判断
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return len;

    }

    public static int[] generateArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 10)+1 ;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for(int i=0;i<100000;i++){
            int[] arr = generateArray(20);
            if(maxLength(arr, 20)!=maxLength2(arr,20))
                System.out.println("error");
        }


    }

}
