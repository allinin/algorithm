package Leetcode.TrieTree;

/**
 * @author zbl
 * @version 1.0
 * @content:设计一个支持以下两种操作的数据结构：

void addWord(word)
bool search(word)
search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。

示例:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
说明:

你可以假设所有单词都是由小写字母 a-z 组成的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/20 17:09
 */
public class Solution211 {
    private Node root;
    public class Node{
        Node[] children=new Node[26];
        boolean end;
        public Node(){
            this.end=false;
        }
    }

    /** Initialize your data structure here. */
    public Solution211() {
        this.root=new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur=root;
        for(char ch: word.toCharArray()){
            if(cur.children[ch-'a']!=null){
                cur=cur.children[ch-'a'];
            }else{
                cur.children[ch-'a']=new Node();
                cur=cur.children[ch-'a'];
            }
        }
        cur.end=true;

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Node cur=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch>='a' && ch<='z'){
                if(cur.children[ch-'a']!=null) {
                    cur = cur.children[ch - 'a'];
                }
                else
                    return false;
            }else{//遇到了.
                for(Node next :cur.children){
                    if(next!=null)
                    if(process(word,next,i+1))
                        return true;
                }
                return false;//字典中的单词已经到了最后一个字符，但是查找的单词还有在最后还有一个.的情况。

            }
        }
        if(cur.end) return true;
        return false;
    }

    private boolean process(String word,Node cur,int pos){
        if(pos==word.length())
            return true;
        for(int i=pos;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch>='a' && ch<='z'){
                if(cur.children[ch-'a']!=null){
                    cur=cur.children[ch-'a'];
                }else{
                    return false;
                }
            }else{
                for(Node next:cur.children){
                    if(next!=null)
                    if(process(word,next,i+1))
                        return true;
                }
                return false;//字典中的单词已经到了最后一个字符，但是查找的单词还有在最后还有一个.的情况。
            }
        }

        if(cur.end) return true;
        return false;

    }

    public static void main(String[] args) {
        Solution211 solution211=new Solution211();
        solution211.addWord("bad");
        solution211.addWord("dad");

        solution211.addWord("mad");
        solution211.addWord("pad");
        solution211.search("bad");
        System.out.println( solution211.search(".ad"));

        solution211.search("p..");




    }
}
