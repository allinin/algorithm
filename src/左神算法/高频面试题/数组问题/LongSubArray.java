package 左神算法.高频面试题.数组问题;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content: 一个数组由整数组成，求奇数与偶数数量相等的最大子数组的长度；
 * 一个数组由0和1组成，求0和1数量相等的最大子数组的长度；一个数组由0,1,2组成，求1和2数量相等的最大子数组的长度
 * @date 2020/1/4 12:29
 */
public class LongSubArray {

    public static int getLongSubArray(int[] arr){
        //偶数全部标为-1，奇数全部变为1，也就是求累加和为0的最大子数组的长度
        if(arr==null || arr.length==0)
            return 0;
        for(int i=0;i<arr.length;i++){
            arr[i]=(arr[i] & 1)==1 ? 1:-1;//偶数全部标为-1，奇数全部变为1，
        }
        //System.out.println(Arrays.toString(arr));
        int res=0;
        int cur=0;

        HashMap<Integer,Integer> map=new HashMap<>();//k:累加和，v：该累加和第一次出现的位置
        map.put(0,-1);//代表0第一次出现的位置是-1.
        //map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            cur+=arr[i];
            if(!map.containsKey(cur))
            {
                map.put(cur,i);
            }else{
                res=Math.max(res,i-map.get(cur));
            }
//            if(cur==0){
//                res=Math.max(res,i+1);
//            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,24,11,0,1};
        System.out.println(getLongSubArray(arr));
    }

}
