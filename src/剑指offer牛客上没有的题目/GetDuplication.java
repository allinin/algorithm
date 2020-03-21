package 剑指offer牛客上没有的题目;

/**
 * @author zbl
 * @version 1.0
 * @content:不修改数组找出数组中的重复的数字
 * 在一个长度为n+1的数组里的所有的数字都在1~n的范围内，所以数组中至少有一个重复的数字，请找出数组中任意的一个重复的数字
 * 要求：空间复杂度为O(1)
 *
 * @date 2020/3/14 19:17
 */
public class GetDuplication {

    public static int getResult(int [] arr,int len){
        if(arr==null || len<1)
            return -1;
        int start=1;
        int end=len-1;
        int mid=0;
        while(start<=end){
            mid=((end-start)>>1)+start;
            int count=countRange(arr,len,start,mid);
            if(start==end){
                if(count>1)
                    return start;
                else
                    break;
            }
            if(count>mid-start+1){
                end=mid;
            }else{
                start=mid+1;
            }

        }
        return -1;
    }

    //统计数组中的元素在start-end的个数
    private static int countRange(int[] arr,int len,int start,int end){

        int count=0;
        for(int i=0;i<len;i++){
            if(arr[i]>=start && arr[i]<=end)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,9,8};
        System.out.println(getResult(arr,9));
    }
}
