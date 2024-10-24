package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.最近公共祖先;

import 工作后刷题.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 最深叶节点的最近公共祖先 medium
 * 给你一个有根节点 root 的二叉树，返回它 最深的叶节点的最近公共祖先 。
 * <p>
 * 回想一下：
 * <p>
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：我们返回值为 2 的节点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的节点。
 * 注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 解释：根节点是树中最深的节点，它是它本身的最近公共祖先。
 * 示例 3：
 * <p>
 * 输入：root = [0,1,3,null,2]
 * 输出：[2]
 * 解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数将在 [1, 1000] 的范围内。
 * 0 <= Node.val <= 1000
 * 每个节点的值都是 独一无二 的。
 *
 * @author: ZBL
 * @date: 2024-10-24  15:48
 */
public class Code1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        Deque<TreeNode> nowLevelList = new LinkedList<>();
        while (!deque.isEmpty()) {
            nowLevelList.clear();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                nowLevelList.add(node);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }
        if (nowLevelList.isEmpty()) {
            return root;
        }
        while (nowLevelList.size() > 1) {
            TreeNode treeNode = lowestCommonAncestor(root, nowLevelList.poll(), nowLevelList.poll());
            nowLevelList.add(treeNode);
        }
        return nowLevelList.poll();
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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

    int maxDepth = -1;
    TreeNode ans = null;

    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        dfs(root, -1);
        return ans;
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }
        int leftDepth = dfs(root.left, depth + 1);
        int rightDepth = dfs(root.right, depth + 1);
        //相等说明已经是叶子节点
        if(leftDepth == rightDepth && leftDepth == maxDepth) {
            ans = root;
        }
        return Math.max(leftDepth,rightDepth);
    }
}
