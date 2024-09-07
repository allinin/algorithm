package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.深入理解.medium;

import 工作后刷题.TreeNode;

/**
 * 求根节点到叶子节点数字之和 medium
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 9
 * 树的深度不超过 10
 *
 * @Author:zbl
 * @Date:2024/9/7 18:05
 */
public class Code129 {

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        process(root,0);
        return ans;
    }

    private void process(TreeNode root, int nowValue) {
        if (root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            ans += nowValue * 10 + root.val;
            return;
        }
        process(root.left,nowValue * 10 + root.val);
        process(root.right,nowValue * 10 + root.val);
    }
}
