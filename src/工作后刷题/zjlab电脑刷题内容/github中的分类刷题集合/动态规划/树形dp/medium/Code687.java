package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.树形dp.medium;

import 工作后刷题.TreeNode;

/**
 * 最长同值路径 medium
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 *
 * 两个节点之间的路径长度 由它们之间的边数表示。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 * 示例 2:
 *
 *
 *
 * 输入：root = [1,4,5,4,4,5]
 * 输出：2
 *
 *
 * 提示:
 *
 * 树的节点数的范围是 [0, 104]
 * -1000 <= Node.val <= 1000
 * 树的深度将不超过 1000
 * @author: ZBL
 * @date: 2024-09-10  19:27
 */
public class Code687 {

    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        process(root);
        return ans;
    }

    //从root节点开始往下连续相同节点的最大数量
    private int process(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = process(root.left);
        int right = process(root.right);
        int res = 1;
        if(root.left != null && root.left.val == root.val && root.right != null && root.right.val == root.val) {
            res += Math.max(left,right);
            ans = Math.max(ans,left + right);
            return res;
        }
        if(root.right != null && root.right.val == root.val) {
            res += right;
            ans = Math.max(ans,res - 1);
            return res;
        }
        if(root.left != null && root.left.val == root.val) {
            res += left;
            ans = Math.max(ans,res - 1);
            return res;
        }
        return res;
    }

}
