package codeTop;

import java.util.ArrayList;
import java.util.List;

public class ByteDance1 {


    public static void main(String[] args) {
        int[] arr = new int[] {2,3,4,3,5,8,9,11,3,1,5,0,2};
        List<Integer> minK = getMinK(arr, 6);
        for(int num : minK){
            System.out.println(num);
        }

    }
    //求一个数组最小的k个数 时间复杂度：o(n)
    public static List<Integer> getMinK(int[] arr,int k){
        List<Integer> list = new ArrayList<>();
        int left = 0,right = arr.length - 1;
        while(left < right && k > 0){
            int mid = process(arr,left,right);
            if(mid - left + 1 < k){
                for(int i = left;i <= mid;i++){
                    list.add(arr[i]);
                }
                left = mid + 1;
                k -= (mid + 1);
            }else if(mid - left + 1 > k){
                right = mid - 1;
            }else {
                for(int i = left;i <= mid;i++){
                    list.add(arr[i]);
                }
                break;
            }
        }
        return  list;
    }

    public static int process(int[] arr,int left,int right){
        int l = left - 1,r = right;
        while(left < r){
            if(arr[left] < arr[right]){
                swap(arr,++l,left++);
            }else if(arr[left] > arr[right]){
                swap(arr,--r,left);
            }else{
                left++;
            }
        }
        swap(arr,left,right);
        return left;
    }

    private static void swap(int[] arr,int left,int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

}
