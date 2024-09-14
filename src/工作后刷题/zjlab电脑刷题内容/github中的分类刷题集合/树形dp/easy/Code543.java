package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.树形dp.easy;

import 工作后刷题.TreeNode;

/**
 * 二叉树的直径 easy
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * <p>
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * <p>
 * 两节点之间路径的 长度 由它们之间边数表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 * 示例 2：
 * <p>
 * 输入：root = [1,2]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 104] 内
 * -100 <= Node.val <= 100
 *
 * @author: ZBL
 * @date: 2024-09-10  19:15
 */
public class Code543 {

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        process(root);
        return ans;
    }

    // 从root到根节点的最大节点数量
    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = process(root.left);
        int right = process(root.right);
        ans = Math.max(ans, left + right);
        return 1 + Math.max(left, right);
    }
}
