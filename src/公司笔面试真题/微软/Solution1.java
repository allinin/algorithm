package 公司笔面试真题.微软;

/**
 * @Author zbl
 * @Date 2020/11/22 14:54
 * @Content:  给定两个已经排序好的数组，找到两者所有元素中第k大的元素
 * @Version 1.0
 */
public class Solution1 {

    public int getKth(int[] arr1,int [] arr2,int k){
        int len1=arr1.length;
        int len2=arr2.length;
        return process(arr1,0,len1-1,arr2,0,len2-1,k);
    }

    //二分法,取中间位置的二分
    public int process(int[] arr1,int start1,int end1,int [] arr2,int start2,int end2,int k){
        if(end1<start1){
           return arr2[start2+k-1];
        }
        if(end2<start2) return arr1[start1+k-1];
        //取中间位置：因为无论数组的长度为啥，一定右中间位置
        int mid1=start1+(end1-start1)/2;
        int mid2=start2+(end2-start2)/2;
        //从arr1开始位置到mid位置以及从arr2开始位置到mid位置的总个数
        int halflen=mid1+mid2-start1-start2+2;
        if(arr1[mid1]<arr2[mid2]){
            if(halflen>k){
                //此时第k个元素一定在arr2[mid]的左边
                return process(arr1,start1,end1,arr2,start2,mid2-1,k);
            }else{
                //此时arr1中的前mid1个元素一定包含在前k个元素中
                return process(arr1,mid1+1,end1,arr2,start2,end2,k-(mid1-start1+1));
            }
        }else{
            if(halflen>k){
                //此时第k个元素一定在arr1[mid]的左边
                return process(arr1,start1,mid1-1,arr2,start2,end2,k);
            }else{
                //此时arr2中的前mid1个元素一定包含在前k个元素中
                return process(arr1,start1,end1,arr2,mid2+1,end2,k-(mid2-start2+1));
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1={1,2,3,4};
        int[] arr2={2,4,5,6};
        System.out.println(new Solution1().getKth(arr1,arr2,5));
    }

}
