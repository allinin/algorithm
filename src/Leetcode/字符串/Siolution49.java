package Leetcode.字符串;

import java.util.*;

/**
 * @Author zbl
 * @Date 2020/12/14 17:51
 * @Content
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 通过次数142,212提交次数219,031
 * @Version 1.0
 */
public class Siolution49 {

    /**
     * 方法一：计数法
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        //当且仅当他们的字符计数相等时，两个字符串是字母异位词
        if(strs.length==0)return new ArrayList();
        int[] count=new int[26];
        Map<String,List> temp=new HashMap<>();
        for(String str:strs){
            String s=str;
            Arrays.fill(count,0);
            for(char c:str.toCharArray()) count[c-'a']++;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<26;i++)
            {
                sb.append(count[i]+"#");//这里要加上一个#，用来区分不同的字母的个数统计
            }
            String key=sb.toString();
            if(!temp.containsKey(key)) temp.put(key,new ArrayList<String>());
            temp.get(key).add(s);
        }
        return new ArrayList(temp.values());
    }

    /**
     * 方法二：排序法
     * @param strs
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[]  chs=strs[i].toCharArray();
            Arrays.sort(chs);
            String key=new String(chs);//将每个字符串排序后形成的字符串作为key
            List<String> tmp= map.getOrDefault(key, new ArrayList<>());
            tmp.add(strs[i]);
            map.put(key,tmp);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs=new String[]{"bdddddddddd", "bbbbbbbbbbc"};
        List<List<String>> res= groupAnagrams(strs);

    }
}
