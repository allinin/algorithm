package 工作后刷题.前缀树;


import java.util.*;

/**
 * @Author:zbl
 * @Date:2024/1/11 21:51
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，
 * 设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。
 * 输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 * 提示：
 * <p>
 * 0 <= len(big) <= 1000
 * 0 <= len(smalls[i]) <= 1000
 * smalls的总字符数不会超过 100000。
 * 你可以认为smalls中没有重复字符串。
 * 所有出现的字符均为英文小写字母。
 */
public class Face1717 {

    //字符串的多次搜索问题，考虑使用前缀树
    public int[][] multiSearch(String big, String[] smalls) {
        Trie trie = new Trie(smalls.length);
        for (int i = 0; i < smalls.length; i++) {
            trie.insert(smalls[i], i);
        }
        for (int i = 0; i < big.length(); i++) {
            trie.search(big.substring(i, big.length()), i);
        }
        int[][] ans = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            List<Integer> list = trie.listArray[i];
            ans[i] = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                ans[i][j] = list.get(j);
            }
        }
        return ans;
    }

    class Node {
        int id;
        boolean end;
        Node[] children;

        public Node() {
            this.id = -1;
            this.end = false;
            this.children = new Node[26];
        }

    }

    class Trie {
        Node root;
        List<Integer>[] listArray;

        public Trie(int n) {
            this.root = new Node();
            this.listArray = new List[n];
            for(int i = 0; i < listArray.length;i++) {
                listArray[i] = new ArrayList<>();
            }
            // 这样写填充的是同一个list
//            Arrays.fill(listArray, new ArrayList<Integer>());Integer
        }

        public void insert(String str, int id) {
            Node cur = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node();
                }
                cur = cur.children[c - 'a'];
            }
            cur.id = id;
            cur.end = true;
        }

        public void search(String str, int idx) {
            Node cur = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    return;
                }
                cur = cur.children[c - 'a'];
                if (cur.end) {
                    listArray[cur.id].add(idx);
                }
            }
        }

    }


}
