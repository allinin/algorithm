package Leetcode.TrieTree;

/**
 * @author zbl
 * @version 1.0
 * @content:实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/18 20:54
 */
public class Trie {

    private Node head;

    class Node{
        private Node[] children=new Node[26];
        private boolean end;
        public Node(){
            this.end=false;
        }
    }


    /** Initialize your data structure here. */
    public Trie() {
        this.head=new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len=word.length();
        Node cur=head;
        for(char ch :word.toCharArray()){
            if(cur.children[ch-'a']!=null){
                cur=cur.children[ch-'a'];
            }else{
                cur.children[ch-'a']=new Node();
                cur=cur.children[ch-'a'];
            }
        }
        cur.end=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur=head;
        for(char ch : word.toCharArray()){
            if(cur.children[ch-'a']!=null){
                cur=cur.children[ch-'a'];
            }else
                return false;
        }
        return cur.end==true ? true :false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur=head;
        for(char ch :prefix.toCharArray()){
            if(cur.children[ch-'a']!=null){
                cur=cur.children[ch-'a'];
            }else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true


    }
}
