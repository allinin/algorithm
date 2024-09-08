package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.灵活运用.medium;

import 工作后刷题.TreeNode;

/**
 * 根到叶路径上的不足节点 medium
 * 给你二叉树的根节点 root 和一个整数 limit ，请你同时删除树中所有 不足节点 ，并返回最终二叉树的根节点。
 * <p>
 * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。
 * <p>
 * 叶子节点，就是没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
 * 输出：[1,2,3,4,null,null,7,8,9,null,14]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
 * 输出：[5,4,8,11,null,17,4,7,null,null,null,5]
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,2,-3,-5,null,4,null], limit = -1
 * 输出：[1,null,-3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 5000] 内
 * -105 <= Node.val <= 105
 * -109 <= limit <= 109
 *
 * @Author:zbl
 * @Date:2024/9/8 17:30
 */
public class Code1080_NOTE {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return process(root, limit, 0);
    }

    private TreeNode process(TreeNode root, int limit, int sum) {
        if (root == null) {
            return null;
        }
        //已经是叶子节点，并且小于limit
        if (root.left == null && root.right == null) {
            if (root.val + sum < limit) {
                return null;
            } else {
                return root;
            }
        }
        //不是叶子节点
        TreeNode left = process(root.left, limit, root.val + sum);
        TreeNode right = process(root.right, limit, root.val + sum);
        //如果不是叶子节点并且子节点路径都不满足，则删除
        if (left == null && right == null) {
            return null;
        }

        root.left = left;
        root.right = right;
        return root;
    }

}
