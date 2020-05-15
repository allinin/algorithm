package 左神算法.基础班.第四课;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 给定一个字符串类型的数组strs，请找到一种拼接顺序，使得将所有的字符串拼接起来组成的大写字符串是所有可能性字典序中最小的
 * 并并反复回这个大写字符串
 * @date 2020/3/24 9:57
 */
public class LowestString {

    public String lowestString(String[] strs){
        if(strs==null || strs.length==0)
            return "";
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        String res="";
        for(int i=0;i<strs.length;i++){
            res+=strs[i];
        }
        return res;
    }
}
