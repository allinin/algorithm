package 工作后刷题.zjlab电脑刷题内容.打家劫舍系列;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.TreeNode;

import java.util.HashMap;

/**
 * 打家截舍III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * <p>
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树的节点数在 [1, 104] 范围内
 * 0 <= Node.val <= 104
 */
public class Code337 {

    private HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int val1 = rob(root.left) + rob(root.right);
        int val2 = root.val;
        if (root.left != null) {
            val2 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val2 += rob(root.right.left) + rob(root.right.right);
        }
        map.put(root, Math.max(val1, val2));
        return Math.max(val1, val2);
    }

    public int rob2(TreeNode root) {
        int[] ans = process(root);
        return Math.max(ans[0],ans[1]);
    }

    private int[] process(TreeNode root) {
        if(root == null) {
            return new int[] {0,0};
        }
        int[] ans = new int[2];

        int[] left = process(root.left);
        int[] right = process(root.right);
        //ans[0]:不抢当前节点能够获得最大值
        ans[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        //ans[1]:抢当前节点能够获得的最大值
        ans[1] = root.val + left[0] + right[0];
        return ans;
    }


}
