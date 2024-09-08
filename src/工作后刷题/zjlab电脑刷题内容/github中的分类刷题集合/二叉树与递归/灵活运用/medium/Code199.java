package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.灵活运用.medium;

import 工作后刷题.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图 medium
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 *
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 *
 * 输入: []
 * 输出: []
 *
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 * @Author:zbl
 * @Date:2024/9/8 17:26
 */
public class Code199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()) {
            int size = deque.size();
            for(int i = 0;i < size;i++) {
                TreeNode node = deque.poll();
                if(i == size - 1) {
                    res.add(node.val);
                }
                if(node.left != null) {
                    deque.add(node.left);
                }
                if(node.right != null) {
                    deque.add(node.right);
                }
            }
        }
        return res;
    }
}
