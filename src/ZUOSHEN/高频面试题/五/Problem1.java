package ZUOSHEN.高频面试题.五;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/1/5 21:57
 */
public class Problem1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Set<Character> set=new HashSet<>();
        int count =0;
        for(char c:s.toCharArray()){
            if(!set.contains(c)){
                count++;
                set.add(c);
            }
        }
        if(count>2){
            System.out.println(0);
        }else if(count==2){
            System.out.println(2);
        }else {
            System.out.println(count);
        }
        sc.close();
    }


}
