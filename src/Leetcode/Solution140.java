package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/5/12 11:54
 */
public class Solution140 {
    public static List<String> wordBreak(String s, List<String> wordDict) {

        int len=s.length();
        List<String>[] dp=new List [len+1];//代表前i个字符组成的字符串可以拼接的情况
        if(!cwordBreak(s,wordDict)) return new ArrayList<String>();
        for(int i=0;i<=len;i++){
            dp[i]=new ArrayList<String>();
        }
        dp[0].add("");
        for(int i=1;i<=len;i++){
            for(int j=0;j<i;j++){
                if(dp[j].size()>0 && wordDict.contains(s.substring(j,i)))
                {
                    for(String str : dp[j]){
                        dp[i].add(str+(str.equals("")?"":" ")+s.substring(j,i));
                    }
                }
            }
        }
        return dp[len];
    }

    public static boolean cwordBreak(String s, List<String> wordDict) {
        int len=s.length();//代表s的前i个字符是否可以拆分成wordDict中的单词
        boolean [] dp=new boolean[len+1];
        dp[0]=true;
        for(int i=1;i<=len;i++){
            for(String str:wordDict){
                int l=str.length();
                if(i-l>=0 && dp[i-l] && s.substring(i-l,i).equals(str)){
                    dp[i]=true;
                    break;
                }
            }

        }

        return dp[len];
    }

    public static void main(String[] args) {
        String str="catsanddog";
        List<String> list=new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        System.out.println(wordBreak(str,list));

    }
}
