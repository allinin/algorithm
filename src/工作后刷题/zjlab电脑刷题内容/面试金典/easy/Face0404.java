package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZBL
 * @Date: 2024-01-05  09:50
 * <p>
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * <p>
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 */
public class Face0404 {

    //用于记忆化搜素树的高度，可以在判断子树是否是平衡树时快速得出结果，===========>执行时间竟然比普通递归慢了
    Map<TreeNode, Integer> heightMap = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //当前树左右子树高度差不超过1，并且左右子树也得是平衡树
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (heightMap.containsKey(root)) {
            return heightMap.get(root);
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        int ans = 1 + Math.max(left, right);
        heightMap.put(root, ans);
        return ans;
    }

    //方法二：直接在判断树的高度的同时，判断是否满足平衡性
    boolean res = true;

    public boolean isBalanced2(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        int ans = 1 + Math.max(left, right);
        return ans;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode leftParent = lowestCommonAncestor(root.left, p, q);
        TreeNode rightParent = lowestCommonAncestor(root.right, p, q);
        if (leftParent == null || rightParent == null) {
            return leftParent == null ? rightParent : leftParent;
        }
        return root;
    }

}
