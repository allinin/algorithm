package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.easy;

/**
 * 二叉树的直径
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
 */
public class Code543_Actually_Is_Difficult {
    // todo 与124题类似的做法
    private Integer max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        process(root);
        return max;
    }

    //计算当前节点到叶子节点的节点数量
    private int process(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int left = process(root.left);
        int right = process(root.right);
        //因为最长路径不一定经过根节点，所以在每次递归的时候判断计算以当前递归节点为根节点的子树的最长路径
        max = Math.max(max,left + right);
        return 1 + Math.max(left,right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}