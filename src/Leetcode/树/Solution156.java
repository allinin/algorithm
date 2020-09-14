package Leetcode.树;

/**
 * @author zbl
 * @version 1.0
 * @content:Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

Example:

Input: [1,2,3,4,5]

1
/ \
2   3
/ \
4   5

Output: return the root of the binary tree [4,5,2,#,#,3,1]

4
/ \
5   2
/ \
3   1
Clarification:

Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is serialized on OJ.

The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:

1
/ \
2   3
/
4
\
5
The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].
 * @date 2020/9/14 21:14
 */
public class Solution156 {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
   //递归的思路
    public static  TreeNode upsideDownBinaryTree(TreeNode root){
        if(root==null ||root.left==null) return root;
        TreeNode newRoot=upsideDownBinaryTree(root.left);
        root.left.left=root.right;
        root.left.right=root;
        //将原来root左右孩子设置为null
        root.left=null;
        root.right=null;
        return newRoot;

    }
    //迭代
    public static TreeNode upsideDownBinaryTree2(TreeNode root){
        TreeNode cur=root;
        TreeNode pre=null;
        TreeNode next=null;
        TreeNode tmp=null;
        while(cur!=null){
            next=cur.left;
            cur.left=tmp;
            tmp=cur.right;
            cur.right=pre;

            pre=cur;
            cur=next;
        }
        return pre;
    }



}
