package ZUOSHEN.进阶班二.第一章;

import java.util.Arrays;

/**
 * 给定一个数组arr,和一个整数aim,返回所有满足两个数相加等于aim的不同整数对///找出所有三个数相加等于aim的所有不同整数对
 */
public class PrintUniquePair {

    public static void printUniquePair(int[] arr,int aim){
        if(arr==null || arr.length<2){
            return;
        }
        Arrays.sort(arr);
        int left=0;
        int right=arr.length-1;
        int sum=0;
        while(left<right){
            sum=arr[left]+arr[right];
            if(sum<aim){
                left++;
            }else if(sum>aim){
                right--;
            }else{
                if(left==0 || arr[left]!=arr[left-1]){
                    System.out.println(arr[left]+"  "+arr[right]);
                }
                left++;
                right--;
            }
        }
    }
    //三个值得
    public static void printUniqueTriad(int[] arr,int aim){
        if(arr==null || arr.length<3)
            return;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(i==0 || arr[i]!=arr[i-1]){
                printRest(arr,i,i+1,arr.length-1,aim-arr[i]);
            }
        }
    }

    public static void printRest(int[] arr,int f,int l,int r,int k){
        int sum=0;
        while(l<r){
            sum=arr[l]+arr[r];
            if(sum<k){
                l++;
            }else if(sum>k){
                r--;
            }else{
                if(l==f+1 || arr[l]!=arr[l-1] ){
                    System.out.println(arr[f]+" "+arr[l]+" "+arr[r]);
                }
                l++;
                r--;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr=new int[]{1,1,4,1,2,2,3,4,5,5,5,5,6,6,6,7};
        printUniquePair(arr,8);
        printUniqueTriad(arr,10);
    }
}
