package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.深入理解.easy;

import 工作后刷题.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树的最小深度 easy
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 *
 * 提示：
 *
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 * @Author:zbl
 * @Date:2024/9/7 18:04
 */
public class Code111 {

    //dfs
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int left = root.left == null ? Integer.MAX_VALUE : minDepth(root.left);
        int right = root.right == null ? Integer.MAX_VALUE : minDepth(root.right);
        return 1 + Math.min(left,right);
    }
    //bfs
    public int minDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int ans = 0;
        while(!deque.isEmpty()){
            int size = deque.size();
            ans++;
            for(int i = 0;i < size;i++) {
                TreeNode treeNode = deque.pollFirst();
                if(treeNode.left == null && treeNode.right == null) {
                    return ans;
                }
                if(treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if(treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
            }
        }
        return ans;
    }
}
