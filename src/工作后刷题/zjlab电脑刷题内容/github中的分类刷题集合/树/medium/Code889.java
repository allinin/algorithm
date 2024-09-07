package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.树.medium;

import 工作后刷题.TreeNode;

/**
 * 根据前序与后序遍历构造二叉树（medium)
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 * <p>
 * 如果存在多个答案，您可以返回其中 任何 一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [1], postorder = [1]
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= preorder.length <= 30
 * 1 <= preorder[i] <= preorder.length
 * preorder 中所有值都 不同
 * postorder.length == preorder.length
 * 1 <= postorder[i] <= postorder.length
 * postorder 中所有值都 不同
 * 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历
 *
 * @author: ZBL
 * @date: 2024-08-26  19:05
 */
public class Code889 {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return process(preorder, 0, postorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode process(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preEnd < preStart) {
            return null;
        }
        if (preEnd == preStart) {
            return new TreeNode(preorder[preEnd]);
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = 0;
        for (int i = postStart; i < postEnd; i++) {
            if (postorder[i] == preorder[preStart + 1]) {
                idx = i;
                break;
            }
        }

        root.left = process(preorder, preStart + 1, preStart + (idx - postStart + 1), postorder, postStart, idx);
        root.right = process(preorder, preStart + (idx - postStart + 2), preEnd, postorder, idx + 1, postEnd - 1);
        return root;
    }
}
