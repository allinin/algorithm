package ZUOSHEN.高频面试题;

/**
 * @author zbl
 * @version 1.0
 * @content:数组小和的定义如下：
 * 例如：数组s=[1,3,5,2,4,6],在s[0]的左边小于等于s[0]的数的和为0.在s[1]的左边小于等于s[1]的数的和为1，在s[2]的左边小于等于s[2]的数的和为1+3=4……
 * s的小和等于各个位置的小和的和。给定一个数组s,实现函数返回s的小和。
 * @date 2019/12/28 10:42
 */
public class SmallSum {

    public static  int getSmallSum(int[] arr)
    {
        if(arr==null || arr.length==0)
            return 0;
        return func(arr,0,arr.length-1);
    }
    public static int func(int[] arr,int l,int r){
        if(l==r)
            return 0;
        int mid=(l+r)/2;
        return func(arr,l,mid)+func(arr,mid+1,r)+merge(arr,l,r,mid);
    }

    public static int merge(int[] arr,int left,int right,int mid){
        int[] help=new int[right-left+1];
        int h=0;
        int i=left;
        int j=mid+1;
        int smallSum=0;
        while(i<=mid && j<=right)
        {
            if(arr[i]<=arr[j])
            {   /**仅仅比归并排序多了这一步
                 */
                smallSum+=arr[i]*(right-j+1);
                help[h++]=arr[i++];
            }else{
                help[h++]=arr[j++];
            }
        }
        for(;(j<=right)||(i<=mid);j++,i++){
            help[h++]=i>mid? arr[j]:arr[i];
        }
        for(int m=0;i<help.length;m++){
            arr[left++]=help[i];
        }
        return smallSum;
    }
}
