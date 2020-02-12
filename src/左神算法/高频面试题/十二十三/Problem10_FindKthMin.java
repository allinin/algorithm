package 左神算法.高频面试题.十二十三;

/**
 * @author zbl
 * @version 1.0
 * @content:给定两个有序数组arr1和arr2,再给定一个整数k,返回所有的数中第k小的数。
 * 要求：
 * 如果arr1长度为N，arr2的长度为M，时间复杂度要求O（log(min(M,N)),额外空间复杂度为O（1）
 * @date 2020/2/10 16:49
 */
public class Problem10_FindKthMin {


    public static int findKthMin(int[] arr1,int[] arr2,int k){
        if(arr1==null || arr2==null){
           throw new RuntimeException("Your arr is invalid");
        }
        if(k<1 || k>arr1.length+arr2.length){
            throw new RuntimeException("K is invalid");
        }
        int[] longs=arr1.length>=arr2.length ? arr1:arr2;
        int[] shorts=arr1.length<arr2.length ? arr1: arr2;
        int l=longs.length;
        int s=shorts.length;
        if(k<=s){
            return getUpMedian(longs,0,k-1,shorts,0,k-1);
        }
        if(k>l){
            if(shorts[k-l-1]>=longs[l-1])
                return shorts[k-l-1];
            if(longs[k-s-1]>=shorts[s-1])
                return longs[k-s-1];
            return getUpMedian(longs,k-s,l-1,shorts,k-l,s-1);
        }
        if(longs[k-s]>=shorts[s-1])
           return longs[k-s];
        return getUpMedian(shorts,0,s-1,longs,k-s,k-1);


    }

    //当e1-s1==e2-s2时，才可用该方法
    public static int getUpMedian(int[] arr1,int s1,int e1,int[] arr2,int s2,int e2){
        int m1=0;
        int m2=0;
        int offset=0;
        while(s1<e2){
            m1=(s1+e1)/2;
            m2=(s2+e2)/2;
            offset=((e1-s1)&1)^1;
            if(arr1[m1]==arr2[m2]){
                return arr1[m1];
            }else if(arr1[m1]>arr2[m2]){
                e1=m1;
                s2=m2+offset;
            }else{
               e2=m2;
               s1=m1+offset;
            }
        }
        return Math.min(arr1[s1],arr2[s2]);
    }
}
