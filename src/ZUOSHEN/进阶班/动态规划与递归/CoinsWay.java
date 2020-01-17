package ZUOSHEN.进阶班.动态规划与递归;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content: 换钱的方法数
 * 给定一个数组arr，arr中所有的值都是正数且不重复。每个值代表一个面值的货币，每种面值的货币可以使用任意张，再给定一个一个整数aim,代表要找的钱数，求换钱有多少种方法。
 * @date 2020/1/15 14:49
 */
public class CoinsWay {

    public static int coins1(int[] arr,int aim){
        if(arr==null || arr.length==0 || aim<0){
            return 0;
        }
        return process1(arr,0,aim);
    }
    //index：表示自由使用arr中index以及之后的货币
    public static int process1(int[] arr, int index, int aim) {
        int res=0;
        if(index==arr.length){
            return aim==0 ? 1:0;
        }
        for(int i=0;arr[index]*i<=aim;i++){
            res+=process1(arr,index+1,aim-arr[index]*i);
        }
        return res;
    }
    // 记忆化搜索,即用缓存记录下以前的情况，在再次使用的时候先判断缓存中有没有
    //key:index_aim;
    //value:目标值,即可能方法的个数
    public static HashMap<String,Integer>map=new HashMap<>();

    public static int process2(int[] arr,int index,int aim){
        int res=0;
        if(index==arr.length){
            return aim==0 ? 1:0;
        }
        for(int i=0;arr[index]*i<=aim;i++){
            String key=String.valueOf(index+1)+"_"+String.valueOf(aim-arr[index]*i);
            if(map.containsKey(key)){
                res+=map.get(key);
            }else{
                res+=process2(arr,index+1,aim-arr[index]*i);
            }
        }
        map.put(String.valueOf(index)+"_"+String.valueOf(aim),res);
        return res;
    }

    public static int coins2(int[] arr,int aim){
        if(arr==null || arr.length==0 || aim<0){
            return 0;
        }
        return process2(arr,0,aim);
    }

    public static void main(String[] args) {
        int[] coins = { 10, 5, 1, 25 };
        int aim = 2000;

        long start = 0;
        long end = 0;
        start = System.currentTimeMillis();
        System.out.println(coins1(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");
        start=0;
        end=0;
        start = System.currentTimeMillis();
        System.out.println(coins2(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");
        start = System.currentTimeMillis();
        System.out.println(coinsOther(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        aim = 20000;

        start = System.currentTimeMillis();
        System.out.println(coins2(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.println(coins3(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.println(coins4(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.println(coins5(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

    }
}
