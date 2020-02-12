package 左神算法.基础班.图;

public class TrieTree {

    public static class TrieNode{
        private int path;//有多少个字符串到达过这个结点
        private int end;////有多少个字符串是以这个结点结尾的
        private TrieNode[] map;//每个结点可以有的路的数目（即数组的长度），也可以通过HashMap<Char,TrieNode>来定义。
        //这里为了简便使用了长度为26的数组，每条路必须是字母，数组的index表示路，map[index]!=null时，表示该条路的存在


        public TrieNode(){
            path=0;
            end=0;
            map=new TrieNode[26];
        }
    }

    public static class Trie{
        private TrieNode root;
        public Trie(){
            root=new TrieNode();
        }

        public void insert(String word){
            if(word==null)
            {
                return;
            }
            char[] chs=word.toCharArray();
            TrieNode node=root;
            int index=0;
            for(int i=0;i<chs.length;i++)
            {
                index=chs[i]-'a';
                if(node.map[index]==null)
                {
                    node.map[index]=new TrieNode();
                }
                node=node.map[index];
                node.path++;
            }
            node.end++;
        }

        public void delete(String word){
            if(search(word)){
                char[] chs=word.toCharArray();
                int index=0;
                TrieNode node=root;
                for(int i=0;i<chs.length;i++)
                {
                    index=chs[i]-'a';
                    if(node.map[index].path--==1)
                    {
                        node.map[index]=null;//置为null表示删除了。不在需要处理后序的结点了
                        return;
                    }
                    node=node.map[index];
                }
                node.end--;
            }
        }

        public boolean search(String word){
            if(word==null)
                return false;
            char[] chs=word.toCharArray();
            int index=0;
            TrieNode node=root;
            for(int i=0;i<chs.length;i++)
            {
                index=chs[i]-'a';
                if(node.map[index]==null)
                    return false;
                node=node.map[index];
            }
            return node.end!=0;
        }

        public int prefixNumber(String pre)
        {
            if(pre==null)
                return 0;
            char[] chs=pre.toCharArray();
            int index=0;
            TrieNode node=root;
            for(int i=0;i<chs.length;i++)
            {
                index=chs[i]-'a';
                if(node.map[index]==null)
                    return 0;
                node=node.map[index];
            }
            return node.path;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));


    }



}
