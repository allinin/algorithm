package Leetcode.TrieTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个不含重复单词的列表，编写一个程序，返回给定单词列表中所有的连接词。

连接词的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。

示例:

输入: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

输出: ["catsdogcats","dogcatsdog","ratcatdogcat"]

解释: "catsdogcats"由"cats", "dog" 和 "cats"组成;
"dogcatsdog"由"dog", "cats"和"dog"组成;
"ratcatdogcat"由"rat", "cat", "dog"和"cat"组成。
说明:

给定数组的元素总数不超过 10000。
给定数组中元素的长度总和不超过 600000。
所有输入字符串只包含小写字母。
不需要考虑答案输出的顺序。
通过次数3,187提交次数7,201

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/concatenated-words
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/7/4 18:24
 */
public class Solution472 {


    //Trie Tree +dfs的方式
    class Node{
        private Node[] children=new Node[26];
        private boolean end;

        public Node(){

        }
    }

    class Trie{
        private Node root;
        public Trie(){
            this.root=new Node();
        }
        //构建trie tree
        public void insert(String s){
            Node cur=root;
            for(char c:s.toCharArray()){
                if(cur.children[c-'a']!=null){
                    cur=cur.children[c-'a'];
                }else{
                    cur.children[c-'a']=new Node();
                    cur=cur.children[c-'a'];
                }
            }
            cur.end=true;

        }
        //判断
        public boolean search(String s,int pos,int num){
            Node cur=root;
            for(int i=pos;i<s.length();i++){
                if(cur.children[s.charAt(i)-'a']==null)
                    return false;
                cur=cur.children[s.charAt(i)-'a'];
                if(cur.end){
                    if(i==s.length()-1) return num>=1;//注意这里是>=1,而不是>1
                    if(search(s,i+1,num+1)) return true;
                }
            }
            return false;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list=new ArrayList<>();
        if(words==null || words.length==0)
            return list;
        Trie trie=new Trie();
        for(String str:words){
            trie.insert(str);
        }
        for(String str: words){
            if(trie.search(str,0,0))
                list.add(str);
        }
        return list;
    }


}
