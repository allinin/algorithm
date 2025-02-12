package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import 工作后刷题.TreeNode;

/**
 * 二叉搜素树种的中序后继节点 medium
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * <p>
 * The successor of a node p is the node with the smallest key greater than p.val.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [2,1,3], p = 1
 * Output: 2
 * Explanation: 1's in-order successor node is 2. Note that both p
 * and the return value is of TreeNode type.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 * Output: null
 * Explanation: There is no in-order successor of the current
 * node, so the answer is null.
 * Note:
 * <p>
 * If the given node has no in-order successor in the tree, return null.
 * It's guaranteed that the values of the tree are unique.
 *
 * @author: ZBL
 * @date: 2025-02-10  18:50
 */
public class Code285 {

    TreeNode ans = null;
    TreeNode pre = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //如果p存在右子树，则后继节点是p右子树的最左节点
        if (p.right != null) {
            TreeNode rightNode = p.right;
            while (rightNode.left != null) {
                rightNode = rightNode.left;
            }
            return rightNode;
        }
        //否则p的父节点即为后继节点，直接中序遍历找到即可
        inOrder(root, p);
        return ans;
    }

    private void inOrder(TreeNode root, TreeNode target) {
        if (root != null) {
            inOrder(root.left, target);
            if (pre != null && pre == target) {
                ans = root;
                return;
            } else {
                pre = root;
            }
            inOrder(root.right, target);
        }
    }

    // 方法二:
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        while (root != null) {
            if (root.val <= p.val) { //当前节点小于等于p，则p的中序后继节点一定不在左子树
                root = root.right;
            } else {
                //当前节点大于p,则后继节点有可能是当前节点或者在左子树中。
                ans = root;
                root = root.left;
            }
        }
        return ans;
    }
}
