package Leetcode.字符串;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {

    List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s==null || s.length()==0) return res;
        int n=s.length();
        for(int i=0;i<n;i++){
            process(s,0,i,new ArrayList<String>());
        }
        return res;

    }

    private void process(String s,int start,int end,List<String> list){
        if(isPrime(s,start,end)){
            list.add(s.substring(start,end+1));
            if(end==s.length()-1){
                res.add(new ArrayList<>(list));
                return;
            }
            for(int i=end+1;i<s.length();i++){
                process(s,end+1,i,list);
            }
        }

    }
    //判断s从start到end是否为回文串
    private  boolean isPrime(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution131().partition("cbb");
    }
}
