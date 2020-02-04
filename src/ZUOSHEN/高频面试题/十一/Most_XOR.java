package ZUOSHEN.高频面试题.十一;

import java.util.HashMap;

/**
 * 给出n个数，问最多有多少个不重叠的非空区间，使得每个区间内数字的xor都等于0.
 */
public class Most_XOR {

    public static int maxXor(int[] arr){
        if(arr==null || arr.length==0)
            return 0;
        int [] mosts=new int[arr.length];//记录以i位置结尾的情况下，能够划分的最大个数
        int xor=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);//为了预防错过异或和本身就是0的情况，在map中提前塞一个记录（0，-1），表示异或和为0的点最近出现在-1位置，
        int ans=0;
        for(int i=0;i<arr.length;i++){
            xor^=arr[i];
            if(map.containsKey(xor)){
                int pre=map.get(xor);
                mosts[i]=pre==-1 ? 1:mosts[pre]+1;
            }
            if(i>0){
                mosts[i]=Math.max(mosts[i],mosts[i-1]);//随着i的增大，mosts[i]只增不减，所以和mosts[i-1]取最大值
            }
            map.put(xor,i);
            ans=Math.max(ans,mosts[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] test = { 3, 0, 2, 2,2,2,2,2,2,2,2,2,2,2,2 };
        System.out.println(maxXor(test));
    }
}
