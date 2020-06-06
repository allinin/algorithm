package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

示例1:

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").



示例2:

输入: s1= "ab" s2 = "eidboaoo"
输出: False

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-in-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/3 16:26
 */
public class Solution567 {
    public static boolean checkInclusion(String s1, String s2) {
        if((s2==null || s2.length()==0) && s1!=null) return false;
        if(s1==null || s1.length()==0) return true;
        int len1=s1.length();
        int len2=s2.length();
        int[] help1=new int[26];//s1的辅助数组，代替map的作用
        int [] help2=new int[26];//s2的辅助数组，代替map的作用
        int left=0,right=0,count=0,valid=0;
        for(int i=0;i<len1;i++){
            help1[s1.charAt(i)-'a']++;//统计s1中每个字符的个数
        }
        //计算s1中不同字符的数量
        for(int i=0;i<26;i++){
            if(help1[i]!=0)
                count++;
        }

        while(right!=len2){
            int index=s2.charAt(right++)-'a';
            if(help1[index]!=0){
                help2[index]++;
                if(help2[index]==help1[index])
                    valid++;
            }

            //left--right的范围已经包含了s1的所有字符，进行判断缩小窗口
            while(valid==count){
                if(right-left==len1)
                    return true;
                int p=s2.charAt(left++)-'a';
                if(help1[p]!=0){
                    help2[p]--;
                    if(help1[p]>help2[p])
                        valid--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1="adc";
        String s2="dcda";
        System.out.println(checkInclusion(s1,s2));
    }
}
