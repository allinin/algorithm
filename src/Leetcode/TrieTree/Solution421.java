package Leetcode.TrieTree;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/6/18 20:03
 */
public class Solution421 {

    public class Node{
        Node[] children=new Node[2];;
        public Node(){}
    }
    public int findMaximumXOR(int[] nums) {
        int len=nums.length;
        Node trie=new Node();
        int max_xor=0;
        for(int i=0;i<len;i++){
            int num=nums[i];
            Node cur=trie,xor_node=trie;
            int xor_num=0;
            for(int j=31;j>=0;j--){
                int index=num & (1<<j);
                if(cur.children[index]!=null){
                    cur=cur.children[index];
                }else{
                    cur.children[index]=new Node();
                    cur=cur.children[index];
                }

                //选择最大的xor的值
                int toggledindex=index==1 ? 0:1;
                if(xor_node.children[toggledindex]!=null){
                    xor_num=(xor_num<<1) | 1;
                    xor_node=xor_node.children[toggledindex];
                }else{
                    xor_num=xor_num<<1;
                    xor_node=xor_node.children[index];
                }

            }
            max_xor=Math.max(max_xor,xor_num);
        }
        return max_xor;
    }

    public static void main(String[] args) {
        int[] nums={3,10,5,25,2,8};
        System.out.println(new Solution421().findMaximumXOR(nums));
    }
}
