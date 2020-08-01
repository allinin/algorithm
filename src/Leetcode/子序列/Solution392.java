package Leetcode.子序列;

/**
 * @author zbl
 * @version 1.0
 * @content:给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

示例 1:
s = "abc", t = "ahbgdc"

返回 true.

示例 2:
s = "axc", t = "ahbgdc"

返回 false.

后续挑战 :

如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/is-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/7/27 22:07
 */
public class Solution392 {

    public static boolean isSubsequence(String s, String t) {
        if(t==null || t.length()==0){
            if(s==null || s.length()==0)
                return true;
            else
                return false;
        }
        int n=t.length(),m=s.length();
        int i=0,j=0;
        while(i<n && j<m){
            if(s.charAt(j)==t.charAt(i)){
                j++;
            }
            i++;
        }
        return j==m;

    }

    public static void main(String[] args) {
       String s="abc" ;
       String t="ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
}
