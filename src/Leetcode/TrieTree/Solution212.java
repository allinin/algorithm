package Leetcode.TrieTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

示例:

输入:
words = ["oath","pea","eat","rain"] and board =
[
['o','a','a','n'],
['e','t','a','e'],
['i','h','k','r'],
['i','f','l','v']
]

输出: ["eat","oath"]
说明:
你可以假设所有输入都由小写字母 a-z 组成。

提示:

你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
通过次数15,287提交次数37,454

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/19 10:58
 */
public class Solution212 {

//    //回溯法
//    private List<String> res=new ArrayList<>();
//    public List<String> findWords(char[][] board, String[] words) {
//       // res=new ArrayList<>();
//        if(board==null || board.length==0 || words==null || words.length==0)
//            return res;
//        int row=board.length;
//        int col=board[0].length;
//        int len=words.length;
//        boolean[][] visited=new boolean[row][col];
//        for(int i=0;i<len;i++){
//            String str=words[i];
//           boolean flag=false;
//            for(int m=0;m<row;m++){
//                Arrays.fill(visited[m],false);
//            }
//            for(int j=0;j<row;j++){
//                for(int k=0;k<col;k++){
//                    if(board[j][k]==str.charAt(0)){
//                        if(process(j,k,board,visited,str,0)){
//                            flag=true;
//                           break;
//                        }
//                    }
//                }
//               if(flag)
//                   break;
//            }
//        }
//        return res;
//    }
//
//    private boolean process(int i,int j,char[][] board,boolean[][] visited,String str,int pos){
//        if(pos==str.length()){
//            res.add(str);
//            return true;
//        }
//        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j]){
//            return false;
//        }
//        if(board[i][j]==str.charAt(pos)){
//            visited[i][j]=true;//记录该点被访问
//        }else{
//            return false;
//        }
//
//        if(process(i+1,j,board,visited,str,pos+1)) return true;
//        if(process(i-1,j,board,visited,str,pos+1)) return true;
//        if(process(i,j+1,board,visited,str,pos+1)) return true;
//        if(process(i,j-1,board,visited,str,pos+1)) return true;
//        visited[i][j]=false;//回溯
//        return false;
//    }

    //前缀树回溯方法
//前缀树结点
public class Node{
    Node[] children=new Node[26];
    boolean end=false;//是否是结尾
    String val;//当前节点代表的字符串值
    public Node(){
    }
}

    //前缀树
    public class TrieTree{
        public Node root;
        public TrieTree(){
            this.root=new Node();
        }
        public void insert(String str){
            Node cur=root;
            for(char ch :str.toCharArray()){
                if(cur.children[ch-'a']!=null){
                    cur=cur.children[ch-'a'];
                }else{
                    cur.children[ch-'a']=new Node();
                    cur=cur.children[ch-'a'];
                }
            }
            cur.end=true;
            cur.val=str;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        if(board==null || board.length==0 || words==null || words.length==0)
            return new ArrayList<>();
        int row=board.length;
        int col=board[0].length;
        int len=words.length;
        boolean[][] visited=new boolean[row][col];
        TrieTree trieTree=new TrieTree();
        for(int i=0;i<len;i++){
            trieTree.insert(words[i]);
        }

        Set<String> set=new HashSet<>();//将可能的结果加入的set中，防止重复
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){//以board中的每一个字符为开始进行遍历
                process(i,j,visited,board,set,trieTree.root);
            }
        }
        return new ArrayList<>(set);

    }

    //i,j:表示下一步要去board中要去的位置，
    public void process(int i,int j,boolean[][] visited,char[][] board,Set<String> set,Node cur){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j]) //越界或者已经访问了
            return ;
        cur=cur.children[board[i][j]-'a'];
        visited[i][j]=true;
        if(cur==null){
            visited[i][j]=false;
            return;
        }

        //已经找到了单词
        if(cur.end){
            set.add(cur.val);//找到单词后不回退，因为可能同时存在"add",“addd"这样的单词
        }

        process(i+1,j,visited,board,set,cur);
        process(i-1,j,visited,board,set,cur);
        process(i,j+1,visited,board,set,cur);
        process(i,j-1,visited,board,set,cur);
        visited[i][j]=false;//最后回退



    }
    public static void main(String[] args) {
        String []words={"oath","pea","eat","rain"};
        char[][] boards={{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
                  };

        List<String> list = new Solution212().findWords(boards, words);
        System.out.println(list.size());

    }
}
