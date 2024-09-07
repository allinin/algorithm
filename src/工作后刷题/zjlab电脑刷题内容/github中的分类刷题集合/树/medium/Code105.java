package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.树.medium;

import 工作后刷题.TreeNode;

/**
 * 从前序与中序遍历序列构造二叉树(medium)
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 *
 * @author: ZBL
 * @date: 2024-08-26  19:04
 */
public class Code105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        int len = preorder.length;
        return process(preorder, 0, len - 1, inorder, 0, len - 1);
    }

    private TreeNode process(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preEnd < preStart) {
            return null;
        }
        if (inStart == inEnd) {
            return new TreeNode(inorder[inEnd]);
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                idx = i;
                break;
            }
        }

        root.left = process(preorder, preStart + 1, preStart + (idx - inStart), inorder, inStart, idx - 1);
        root.right = process(preorder, preStart + (idx - inStart + 1), preEnd, inorder, idx + 1, inEnd);
        return root;
    }
}
