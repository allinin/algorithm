package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.动态规划.树形dp.medium;

import 工作后刷题.TreeNode;

/**
 * 打家截舍III medium (最大独立集问题）
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 *
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 *
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * 示例 2:
 *
 *
 *
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 *
 *
 * 提示：
 *
 * 树的节点数在 [1, 104] 范围内
 * 0 <= Node.val <= 104
 * @author: ZBL
 * @date: 2024-09-11  18:36
 */
public class Code337 {

    public int rob(TreeNode root) {
        int[] res = process(root);
        return Math.max(res[0],res[1]);
    }

    private int[] process(TreeNode root) {
        if(root == null) {
            return new int[2];
        }
        int[] ans = new int[2];
        int[] left = process(root.left);
        int[] right = process(root.right);
        ans[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        ans[1] = root.val + left[0] + right[0];
        return ans;
    }
}
