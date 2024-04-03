package 工作后刷题.树;

import 工作后刷题.TreeNode;

/**
 * @Author: ZBL
 * @Date: 2024-04-03  09:06
 * <p>
 * 另一棵树的子树(easy)
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * root 树上的节点数量范围是 [1, 2000]
 * subRoot 树上的节点数量范围是 [1, 1000]
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 */
public class Code572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }

        return process(root,subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    //从root1,root2节点开始判断是否是子树
    private boolean process(TreeNode root1, TreeNode root2) {
        if (root1 == null && root1 == null) {
            return true;
        }
        if (root1 == null || root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return process(root1.left, root2.left) && process(root1.right, root2.right);
    }
}
