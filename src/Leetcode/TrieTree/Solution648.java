package Leetcode.TrieTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。

现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。

你需要输出替换之后的句子。

 

示例：

输入：dict(词典) = ["cat", "bat", "rat"] sentence(句子) = "the cattle was rattled by the battery"
输出："the cat was rat by the bat"
 

提示：

输入只包含小写字母。
1 <= dict.length <= 1000
1 <= dict[i].length <= 100
1 <= 句中词语数 <= 1000
1 <= 句中词语长度 <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/replace-words
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/18 22:23
 */
public class Solution648 {

    public class Node{
        Node[] children=new Node[26];
        boolean end;
        public Node(){
            this.end=false;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        String[] strs=sentence.split(" ");
        StringBuilder sb=new StringBuilder();
        Node root=new Node();
        //将字典中的元素构建前缀树
        for(String str :dict){
            Node cur=root;
            for(char ch :str.toCharArray()){
                if(cur.children[ch-'a']!=null){
                    cur=cur.children[ch-'a'];
                }else{
                    cur.children[ch-'a']=new Node();
                    cur=cur.children[ch-'a'];
                }
            }
            cur.end=true;//词根的结尾
        }

        for(String str: strs){
            Node cur=root;
            boolean flag=false;//判断是否没有碰到end结点
            StringBuilder tmp=new StringBuilder();
            for(char ch :str.toCharArray()){
                if(cur.end) {
                    sb.append(tmp.toString());
                    sb.append(" ");
                    flag=true;
                    break;
                }

                if(cur.children[ch-'a']!=null){
                    tmp.append(ch);
                    cur=cur.children[ch-'a'];
                }else{
                    sb.append(str+" ");
                    flag=true;
                    break;
                }

            }
            if(!flag)
                sb.append(tmp.toString()+" ");
        }
        String res=sb.toString();
        return res.substring(0,res.length()-1);


    }

    public static void main(String[] args) {
        List<String> dict=new ArrayList<>();
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        dict.add("aaaa");
        String strs="a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        System.out.println(new Solution648().replaceWords(dict,strs));
    }

}
