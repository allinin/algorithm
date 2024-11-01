package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.BFS;

import 工作后刷题.TreeNode;

import java.util.*;

/**
 *  寻找树左下角的值 medium
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 *
 *
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * @author: ZBL
 * @date: 2024-10-28  19:44
 */
public class Code513 {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int ans = -1;
        while(!deque.isEmpty()) {
            int size = deque.size();
            for(int i = 0;i < size;i++) {
                TreeNode node = deque.poll();
                if(node.left != null) {
                    deque.add(node.left);
                }
                if(node.right != null) {
                    deque.add(node.right);
                }
                if(i == 0) {
                    ans = node.val;
                }
            }
        }
        return ans;
    }
}
