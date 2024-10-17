package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.前序_中序_后序;

import 工作后刷题.TreeNode;

/**
 * 对称二叉树 easy
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * @author: ZBL
 * @date: 2024-10-17  18:29
 */
public class Code101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root.left, root.right);
    }

    private boolean process(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        return process(leftNode.left, rightNode.right) && process(leftNode.right, rightNode.left);
    }
}
