package 左神算法.进阶班二.第四章;


/**
 * @author zbl
 * @version 1.0
 * @content:
题目六
数组中未出现的最小正整数
【题目】
给定一个无序整型数组arr，找到数组中未出现的最小正整数。
【举例】
arr=[-1,2,3,4]。返回1。
arr=[1,2,3,4]。返回5。
 * @date 2020/2/21 16:37
 */
public class Code_06_SmallestMissNum {

    public static int missNum(int[] arr){
        int l=0;
        int r=arr.length;
        while(l<r){
            if(arr[l]==l+1)
                l++;
            else if(arr[l]<=l || arr[l]>r || arr[l]==arr[arr[l]-1] )
                ////arr[arr[l] - 1] == arr[l]:表示arr中存在1~arr.length的两个两个相同的数
                arr[l]=arr[--r];
            else{
                swap(arr,l,arr[l]-1); //表示1~arr.lenght之间的数大的跑到了前面
            }
        }
        return l+1;
    }

    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        int[] arr = { -1, 0, 2, 1, 3, 5 };
        System.out.println(missNum(arr));

    }

}
