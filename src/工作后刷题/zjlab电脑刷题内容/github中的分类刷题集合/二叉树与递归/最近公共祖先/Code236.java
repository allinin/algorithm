package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.最近公共祖先;

import 工作后刷题.TreeNode;

/**
 * 二叉树的最近公共祖先 medium
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 *
 * @author: ZBL
 * @date: 2024-10-24  15:39
 */
public class Code236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftParent = lowestCommonAncestor(root.left, p, q);
        TreeNode rightParent = lowestCommonAncestor(root.right, p, q);
        //左子树的公共祖先与右子树的公共祖先有一个为null,说明二者在同一子树中，返回不为null的即可。
        if (leftParent == null || rightParent == null) {
            return leftParent != null ? leftParent : rightParent;
        }
        //如果二者都不为null,说名分别在不同的子树中，返回根节点
        return root;
    }
}
