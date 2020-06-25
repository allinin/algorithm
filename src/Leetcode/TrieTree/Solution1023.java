package Leetcode.TrieTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）

给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。

 

示例 1：

输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
输出：[true,false,true,true,false]
示例：
"FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
"FootBall" 可以这样生成："F" + "oot" + "B" + "all".
"FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
示例 2：

输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
输出：[true,false,true,false,false]
解释：
"FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
"FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
示例 3：

输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
输入：[false,true,false,false,false]
解释：
"FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 

提示：

1 <= queries.length <= 100
1 <= queries[i].length <= 100
1 <= pattern.length <= 100
所有字符串都仅由大写和小写英文字母组成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/camelcase-matching
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/20 20:03
 */
public class Solution1023 {

    //法一：使用前缀树
    public class Node{
        Node[] lowerchildren=new Node[26];//小写字母
        Node[] upperchildren=new Node[26];//大写字母
        public Node(){
        }
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean>res=new ArrayList<>();
        int len=pattern.length();
        int big=0;
        for(int i=0;i<len;i++){
            if(pattern.charAt(i)>='A' && pattern.charAt(i)<='Z')
                big++;
        }
        Node root=new Node();
        //初始化前缀树
        for(String str :queries){
            Node cur=root;
            int index=0;
            int help=big;
            for(char ch :str.toCharArray()){
                if(index<len && ch==pattern.charAt(index)){
                    index++;
                }
                if(ch>='A' && ch<='Z'){//比较pattern中的大写字母的数量是否与query中的大写字母数量相等
                    help--;
                    if(help<0)
                        break;
                }

                if(ch>='a' && ch<='z'){
                    if(cur.lowerchildren[ch-'a']!=null){
                        cur=cur.lowerchildren[ch-'a'];
                    }else{
                        cur.lowerchildren[ch-'a']=new Node();
                        cur=cur.lowerchildren[ch-'a'];
                    }
                }else if(ch>='A' && ch<='Z'){
                    if(cur.upperchildren[ch-'A']!=null){
                        cur=cur.upperchildren[ch-'A'];
                    }else{
                        cur.upperchildren[ch-'A']=new Node();
                        cur=cur.upperchildren[ch-'A'];
                    }
                }

            }
            if(index==len && help==0) res.add(true);
            else res.add(false);

        }

        return res;
    }
    //=================================================
    //法二
    public List<Boolean> camelMatch2(String[] queries, String pattern) {
        List<Boolean> res=new ArrayList<>();
        for(String str:queries){
            res.add(isMatch(str,pattern));
        }
        return res;
    }

    public Boolean isMatch(String str,String pattern){
        int idx1=0,idx2=0;
        int n1=str.length();
        int n2=pattern.length();
        while(idx1<n1 && idx2<n2){
            char ch1=str.charAt(idx1),ch2=pattern.charAt(idx2);
            if(ch1==ch2){
                idx1++;
                idx2++;
            }else{
                if(ch1>='A' && ch1<='Z'){
                    return false;
                }
                idx1++;
            }
        }
        if(idx2!=n2) return false;
        while(idx1<n1){
            if(!(str.charAt(idx1)>='a' && str.charAt(idx1)<='z')){
                return false;
            }
            idx1++;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] queries={"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern="FB";
        Solution1023 solution1023=new Solution1023();
        List<Boolean> res = solution1023.camelMatch(queries, pattern);
        for(Boolean b : res){
            System.out.println(b);
        }

    }
}
