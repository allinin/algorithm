package ZUOSHEN.高频面试题.五;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/1/5 22:10
 */
public class Problem3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入字符串s ");
        String str= sc.nextLine();
        System.out.println("请输入字符串长度：");
        int n=sc.nextInt();
        System.out.println(maxSubString(str));
        System.out.println(maxEqual0And1(str));
        sc.close();

    }

    public static int maxSubString(String str){
        if(str==null || str.length()==0)
            return 0;
        int cur=1;
        int max=1;
        char[] chas = str.toCharArray();
        for(int i=1;i<chas.length;i++){
            if(chas[i]!=chas[i-1])
            {
                cur++;
                max=Math.max(cur,max);
            }else{
                cur=1;
            }
        }
        return max;
    }

    public static int maxEqual0And1(String str){
           if(str==null || str.length()<2)
           {
               return 0;
           }
           char[] chas=str.toCharArray();
           //System.out.println(Arrays.toString(chas));
           int[] arr=new int[chas.length];
           for(int i=0;i<arr.length;i++){
               if(chas[i]=='0')
               {

                   arr[i]=-1;
               }else if(chas[i]=='1') {
                   arr[i]=1;
               }
           }
         // System.out.println(Arrays.toString(arr));
           HashMap<Integer,Integer>map=new HashMap<>();
           map.put(0,-1);
           int cur=0;
           int max=0;
           for(int i=0;i<arr.length;i++){
               cur+=arr[i];
               if(!map.containsKey(cur))
               {
                   map.put(cur,i);
               }else{
                   max=Math.max(max,i-map.get(cur));
               }
           }
           return max;
    }
}
