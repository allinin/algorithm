package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.树形dp.hard;

import 工作后刷题.TreeNode;

/**
 * 二叉树中的最大路径和 hard
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 *
 * @author: ZBL
 * @date: 2024-09-10  19:26
 */
public class Code124 {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        process(root);
        return ans;
    }

    //从root节点开始外子树方向遍历的最大路径
    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = root.val;
        int left = process(root.left);
        int right = process(root.right);
        ans = Math.max(ans, res + (Math.max(left, 0)) + (Math.max(right, 0)));
        return res + Math.max(0, Math.max(left, right));
    }
}
