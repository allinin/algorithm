package codeTopLeetCodeVIP;

/**
 * 给定一棵二叉搜索树和其中的一个节点 node ，找到该节点在树中的中序后继。
 *
 * 如果节点没有中序后继，请返回 null 。
 *
 * 一个结点 node 的中序后继是键值比 node.val大所有的结点中键值最小的那个。
 *
 * 你可以直接访问结点，但无法直接访问树。每个节点都会有其父节点的引用。节点定义如下：
 *
 * class Node {undefined
 *
 * public int val;
 *
 * public Node left;
 *
 * public Node right;
 *
 * public Node parent;
 *
 * }
 */

public class InOrderSuccessor {

    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
    }

    public static TreeNode inOrderSuccessor(TreeNode node){
        //右子树存在，则右子树的最左子树为下一个节点
        if(node.right != null){
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
        //否则向上遍历，如果该节点是父节点的左子树则直接返回父节点，如果是父节点的右子树，则到父节点继续遍历
        while(node.parent != null && node.parent.right == node) node = node.parent;
        return node.parent;
    }
}
