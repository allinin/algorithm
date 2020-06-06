package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:给你一个字符串 s，请你对 s 的子串进行检测。

每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。我们可以 重新排列 子串 s[left], ..., s[right]，并从中选择 最多 k 项替换成任何小写英文字母。

如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。

返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。

注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，也就是说，如果 s[left..right] = "aaa" 且 k = 2，我们只能替换其中的两个字母。（另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）



示例：

输入：s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
输出：[true,false,false,true,true]
解释：
queries[0] : 子串 = "d"，回文。
queries[1] : 子串 = "bc"，不是回文。
queries[2] : 子串 = "abcd"，只替换 1 个字符是变不成回文串的。
queries[3] : 子串 = "abcd"，可以变成回文的 "abba"。 也可以变成 "baab"，先重新排序变成 "bacd"，然后把 "cd" 替换为 "ab"。
queries[4] : 子串 = "abcda"，可以变成回文的 "abcba"。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/can-make-palindrome-from-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/4 16:45
 */
public class Solution1177 {

    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res=new ArrayList<>();
        int len=queries.length;
        int len1=s.length();
        //对字符串进行预处理，统计每个字符在一定位置出现的次数,避免后面的重复计算
        int[][] count=new int[len1][26];
        count[0][s.charAt(0)-'a']++;//将第一个字符加入到预处理数组
        for(int i=1;i<len1;i++){
            char ch=s.charAt(i);
            System.arraycopy(count[i-1],0,count[i],0,26);
            count[i][ch-'a']++;
        }

        for(int i=0;i<len;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            int k=queries[i][2];
            String subs=s.substring(start,end+1);
            if(subs.length()==1) {
                res.add(true);
            }else if(k>=subs.length())
                res.add(true);
            else{
                int [] help=new int[26];
                int sublen=subs.length();
                for(int j=0;j<26;j++){
                    help[j]=count[end][j]-(start>0 ? count[start-1][j] : 0);
                }
                for(int j=0;j<26;j++){
                    if(help[j]%2==0)
                        sublen-=help[j];
                    else if(help[j]>2){
                        sublen-=(help[j]-1);
                    }
                }
                sublen=sublen/2;
                if(sublen>k) res.add(false);
                else res.add(true);

            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s="ninmjmj";
        int[][] arr={{3,3,0},{1,1,1},{2,5,4},{1,3,1},{5,6,1}};
        System.out.println(canMakePaliQueries(s,arr));
    }
}
