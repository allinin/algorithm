package 左神算法.进阶班二.第二章;

import java.util.*;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 如果str1和str2包含的字符种类一样，并且每种字符的个数也
一样，那么str1和str2算作变形词。
给定一个字符类型的数组，请把变形词分组。比如
输入：
["eat", "tea", "tan", "ate", "nat", "bat"]
输出：
[
["ate", "eat","tea"],
["nat","tan"],
["bat"]
]
注意：所有的字符都是小写。
 * @date 2020/2/15 19:31
 */
public class Problem04_Group_Anagrams {

    //将字符串进行排序的方式
    public static List<List<String>> groupAnagrams1(String[] strArr){
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strArr.length;i++){
            char[] chars = strArr[i].toCharArray();
            Arrays.sort(chars);
            if(!map.containsKey(chars.toString())){
                ArrayList<String> arrayList=new ArrayList<>();
                arrayList.add(strArr[i]);
                map.put(chars.toString(),arrayList);
            }else{
                List<String> list= map.get(chars.toString());
                list.add(strArr[i]);
            }
        }
        ArrayList<List<String>> res=new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    //使用有限穷举的方式
    public static List<List<String>> groupAnagrams2(String[] strArr){
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strArr.length;i++){
            int[] arr=new int[26];
            char[] chars = strArr[i].toCharArray();
            for(int j=0;j<chars.length;i++){
                arr[chars[j]-'a']++;
            }
            StringBuilder strB=new StringBuilder();
            for(int value:arr){
                strB.append(String.valueOf(value)).append("_");
            }
            String key=strB.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(strArr[i]);
        }
        ArrayList<List<String>> res=new ArrayList<>();
        for(List<String> list:map.values()){
            res.add(list);
        }
        return res;
    }
}
