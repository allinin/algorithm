package 公司真题;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content:1、现在有3种硬币分别为：1元，5元，10元，现在给你63元，让你全部换成硬币，
 * 求出最小硬币数量，也就是说，怎么用最少的硬币数凑成63元。
 *
 *  2、现在有3种硬币分别为：1元，5元，10元，现在给你63元，让你全部换成硬币，求有多少种换钱的方式

 * @date 2020/3/30 17:25
 */
public class ChangeMoney {

    //现在有3种硬币分别为：1元，5元，10元，现在给你63元，让你全部换成硬币，
    // 求出最小硬币数量，也就是说，怎么用最少的硬币数凑成63元。
    public static int process(int[] arr,int money){
       int[] help=new int[money+1];//辅助数组记录每个钱数最小的硬币数。
       help[0]=0;
       for(int i=1;i<=money;i++){

           //默认最少硬币数就是当前金额本身
           int minCoin=i;

           for(int j=0;j<arr.length;j++){
               if(i>=arr[j]){
                   int temp=help[i-arr[j]]+1;

                   if(temp<minCoin){
                       minCoin=temp;
                   }
               }

           }

           help[i]=minCoin;
           //System.out.println(help[i]);

       }

           return help[money];
    }


    /**
     *     现在有3种硬币分别为：1元，5元，10元，现在给你63元，让你全部换成硬币，求有多少种换钱的方式

     */
    //暴力递归
    public static int process1(int[] arr,int index,int money){
       int res=0;
       if(index==arr.length){
           return res=money==0 ? 1:0;
       }else{
           for(int i=0;(money-arr[index]*i)>=0;i++){
                res+=process1(arr,index+1,money-arr[index]*i);
           }
       }
       return res;
    }

    //记忆化搜索的方式
    public static HashMap<String,Integer> map=new HashMap<>();
    public static int process2(int[] arr,int index,int money){
        int res=0;
        if(index==arr.length){
            return res=money==0 ? 1:0;
        }else{
            for(int i=0;(money-arr[index]*i)>=0;i++){
                int nextAim=money-arr[index]*i;
                String key=String.valueOf((index+1)+"_"+nextAim);
                if(map.containsKey(key)){
                    res+=map.get(key);
                }else{
                    res+=process2(arr,index+1,money-arr[index]*i);

                }
            }
        }

        map.put(String.valueOf(index+"_"+money),res);
        return res;
    }


    public static void main(String[] args) {
        int[] arr=new int[]{1,5,10};
        System.out.println(process(arr,59));
    }
}
