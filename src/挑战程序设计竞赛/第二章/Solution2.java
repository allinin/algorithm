package 挑战程序设计竞赛.第二章;

import java.util.Arrays;

/**
 * @Author zbl
 * @Date 2020/12/2 18:49
 * @Content:
 * 直线上有N个点，点i的位置为Xi。从这N个点中选择若干个，给他们加上标记。对每一个点，其距离为R
 * 以内的区域里必须有带有标记的点，在满足这个条件的情况下，给出最少需要多少个点加标记
 * @Version 1.0
 */
public class Solution2 {

    public int getMin(int[] arr,int R){

        Arrays.sort(arr);//从小到达排序
        int n=arr.length;
        int ans=0;
        int idx=0;

        while(idx<n){
            int pos=arr[idx++];//距离下一个要确定的做标记点最左边的点的位置
            while(idx<n && arr[idx]-pos<=R){
                idx++;
            }
            int target=arr[idx-1];//加标记的点
            while(idx<n && arr[idx]-target<=R){//寻找下一个最左端的点的位置
                idx++;
            }
            ans++;

        }
        return ans;
    }

    public static void main(String[] args) {
          int[] arr=new int[]{3,2,6,8,10,13};
        System.out.println(new Solution2().getMin(arr,3));
    }
}
