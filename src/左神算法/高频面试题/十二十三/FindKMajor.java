package 左神算法.高频面试题.十二十三;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author zbl
 * @version 1.0
 * @content:在数组中找到出现次数大于N/k的数
 * 给定一个整形数组arr,打印其中出现次数大于一半的数，如果没有这样的数，打印提示信息。
 * 进阶：给定一个整型数组arr,在给定一个整数k,打印所有出现次数大于N/k的数，如果没有这样的数，打印提示信息
 * @date 2020/2/5 18:56
 */
public class FindKMajor {

    public static void printHalfMajor(int[] arr){
        int cand=0;
        int times=0;
        for(int i=0;i<arr.length;i++){
            if(times==0)
                cand=arr[i];
            else if(arr[i]==cand)
                times++;
            else
                times--;
        }
        times=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==cand)
                times++;
        }
        if(times>arr.length/2){
            System.out.println(cand);
        }else
            System.out.println("no such number..");
    }

    //一个数组中至多有k-1个数出现的次数满足大于N/K
    public static void printKMajor(int[] arr,int k){
        if(k<2){
            System.out.println("the value is invalid");
            return;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                if(map.size()==k-1)
                    allMinusOne(map);
                else
                    map.put(arr[i],1);
            }
        }
        HashMap<Integer, Integer> res = getReals(map, arr);
        boolean isPrint=false;
        for(Map.Entry<Integer,Integer> entry:res.entrySet()){
            if(entry.getValue()>arr.length/k){
                System.out.print(entry.getKey()+" ");
                isPrint=true;
            }
        }
        if(!isPrint)
            System.out.println("no such number..");
    }

    public static void allMinusOne(HashMap<Integer,Integer> map){

        List<Integer> list=new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()==1){
                list.add(entry.getKey());
            }else{
                map.put(entry.getKey(),entry.getValue()-1);
            }
        }
        for(Integer integer:list){
            map.remove(integer);
        }
    }

    //得到候选人中真正出现次数
    public static HashMap<Integer,Integer> getReals(HashMap<Integer,Integer>cands,int[] arr){
        HashMap<Integer,Integer> res=new HashMap<>();
        for(Map.Entry<Integer,Integer> entry:cands.entrySet()){
            int times=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==entry.getKey()){
                    times++;
                }
            }
            res.put(entry.getKey(),times);
        }
        return res;
    }



    public static void allCandsMinusOne(HashMap<Integer, Integer> map) {
        List<Integer> removeList = new LinkedList<Integer>();
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            Integer key = set.getKey();
            Integer value = set.getValue();
            if (value == 1) {
                removeList.add(key);
            }
            map.put(key, value - 1);
        }
        for (Integer removeKey : removeList) {
            map.remove(removeKey);
        }
    }
    //优化
    public static HashMap<Integer, Integer> getReals(int[] arr,
                                                     HashMap<Integer, Integer> cands) {
        HashMap<Integer, Integer> reals = new HashMap<Integer, Integer>();
        for (int i = 0; i != arr.length; i++) {
            int curNum = arr[i];
            if (cands.containsKey(curNum)) {
                if (reals.containsKey(curNum)) {
                    reals.put(curNum, reals.get(curNum) + 1);
                } else {
                    reals.put(curNum, 1);
                }
            }
        }
        return reals;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 1, 2, 1 };
        printHalfMajor(arr);
        int K = 4;
        printKMajor(arr, K);
    }
}
