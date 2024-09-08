package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.灵活运用.easy;

import 工作后刷题.TreeNode;

/**
 * 给定一个二叉树，判断它是否是
 * 平衡二叉树
 *
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：root = []
 * 输出：true
 *
 *
 * 提示：
 *
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 * @Author:zbl
 * @Date:2024/9/8 17:25
 */
public class Code110 {

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //计算树的高度
    private int treeHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        return 1 + Math.max(left,right);
    }
}
