package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个字符串，逐个翻转字符串中的每个单词。



示例 1：

输入: "the sky is blue"
输出: "blue is sky the"

示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

示例 3：

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。



说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/4 18:24
 */
public class Solution151 {

    public static String reverseWords(String s) {
        if(s==null || s.length()==0)
            return s;
        s=s.trim();
        if(s.length()==0) return s;
        String[] strs=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.length;i++){
            if(!strs[i].equals("")){
                sb.append(strs[i]+" ");
            }
        }
        String temp=sb.toString().substring(0,sb.length()-1);
        String[] help=temp.split(" ");
        int left=0,right=help.length-1;
        while(left<right){
            swap(help,left,right);
            left++;
            right--;
        }
        StringBuilder sb1=new StringBuilder();
        for(String str: help){
            sb1.append(str+" ");
        }
        return sb1.toString().substring(0,sb1.length()-1);


    }
    private static void swap(String[] strs,int i,int j){
        String t=strs[i];
        strs[i]=strs[j];
        strs[j]=t;
    }

    public static void main(String[] args) {
        String str="a good   example";
        System.out.println(reverseWords(str));

    }
}
