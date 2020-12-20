package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false
说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-pattern
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/16 14:42
 */
public class Solution290 {

    //方法一：
    public static boolean wordPattern(String pattern, String s) {
        if(pattern==null || pattern.length()==0)
            return s==null || s.length()==0;
        if(s==null || s.length()==0) return false;
        String[] strs=s.split(" ");
        int m=pattern.length();
        int n=strs.length;
        if(m!=n) return false;
        HashMap<Integer,String> map=new HashMap<>();
        HashMap<String,List<Integer>> map2 = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,strs[i]);
            if(map2.containsKey(strs[i])){
                List<Integer> list=map2.get(strs[i]);
                list.add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map2.put(strs[i],list);
            }
        }
        List<Integer>[] help=new List[26];
        for(int i=0;i<26;i++){
            help[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            char c=pattern.charAt(i);
            help[c-'a'].add(i);
        }
        for(int i=0;i<26;i++){
            if(help[i].size()>0){
                int first=help[i].get(0);
                String str=map.get(first);
                List<Integer> list=map2.get(str);
                if(list.size() != help[i].size()){
                    return false;
                }
                for(int j=0;j<help[i].size();j++){
                    if(! help[i].get(j).equals(list.get(j))){ //因为是Integer包装类型，所以这里如果使用!=可能会报错
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //方法二：
    public static boolean wordPattern2(String pattern, String s) {
        if(pattern==null || pattern.length()==0)
            return s==null || s.length()==0;
        if(s==null || s.length()==0) return false;
        String[] strs=s.split(" ");
        int m=pattern.length();
        int n=strs.length;
        if(m!=n) return false;
        HashMap<Character,String> map=new HashMap<>();//字符：字符串的映射
        for(int i=0;i<m;i++){
            char c=pattern.charAt(i);
            if(!map.containsKey(c)){
                if(map.containsValue(strs[i]))
                    return false;
                map.put(c,strs[i]);
            }else{
                if(!map.get(c).equals(strs[i]))
                    return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        String pattern="ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String s="s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(wordPattern(pattern,s));
    }
}
