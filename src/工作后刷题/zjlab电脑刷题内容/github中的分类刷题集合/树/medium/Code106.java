package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.树.medium;

import 工作后刷题.TreeNode;

/**
 * 从中序与后序遍历序列构造二叉树（medium）
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 *
 * @author: ZBL
 * @date: 2024-08-26  19:03
 */
public class Code106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        int len = postorder.length;
        return process(inorder, 0, len - 1, postorder, 0, len - 1);
    }

    private TreeNode process(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        if (inStart == inEnd) {
            return new TreeNode(inorder[inEnd]);
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                idx = i;
                break;
            }
        }
        root.left = process(inorder, inStart, idx - 1, postorder, postStart, postStart + (idx - 1 - inStart));
        root.right = process(inorder, idx + 1, inEnd, postorder, postStart + (idx - inStart), postEnd - 1);
        return root;
    }
}
