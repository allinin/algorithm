package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.BFS;

import 工作后刷题.TreeNode;

import java.util.*;

/**
 * 二叉树的层序遍历ii medium
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 * @author: ZBL
 * @date: 2024-10-28  19:47
 */
public class Code107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < size;i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if(node.left != null) {
                    deque.add(node.left);
                }
                if(node.right != null) {
                    deque.add(node.right);
                }
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}
