package 招行笔试算法;

/**
 * @author zbl
 * @version 1.0
 * @content:
给定一个正整数数组，它的第 i 个元素是比特币第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一次），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入比特币前卖出
 * @date 2020/2/18 19:21
 */
import java.util.*;
public class Main {


    //自己的实现方法
    public static int getMax(int[] arr){
        if(arr==null || arr.length==1 || arr.length==0)
            return 0;
        int len=arr.length;
        int[] minS=new int[len];
        int[] maxP=new int[len];
        minS[0]=arr[0];
        maxP[len-1]=arr[len-1];
        for(int i=1;i<len;i++){
            if(arr[i]<=minS[i-1])
                minS[i]=arr[i];
            else
                minS[i]=minS[i-1];
        }
        for(int i=len-2;i>-1;i--){
            if(arr[i]>=maxP[i+1])
                maxP[i]=arr[i];
            else
                maxP[i]=maxP[i+1];
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            res=Math.max(res,maxP[i]-minS[i]);
        }
        return res;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> coin=new ArrayList<>();
        while(in.hasNextInt()){ //因为题目要求给出的输入中只有输入数组说得元素，没有输入数组的长度，所以不能用数组来接受输入的元素
            //这里先用arraylist来结束输入的元素，然后将arraylist转换为数组。
            coin.add(in.nextInt());
        }
        Integer[] co=new Integer[coin.size()];
        coin.toArray(co);//将arraylist转换为数组
        int[] cs=new int[co.length];
        for(int i=0;i<co.length;i++)
        {
            cs[i]=co[i].intValue();
        }
        System.out.println(getMax(cs));
    }

}
