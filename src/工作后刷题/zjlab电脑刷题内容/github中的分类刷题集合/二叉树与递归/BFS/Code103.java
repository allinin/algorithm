package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.BFS;

import 工作后刷题.TreeNode;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历 medium
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
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
 * -100 <= Node.val <= 100
 * @author: ZBL
 * @date: 2024-10-28  19:40
 */
public class Code103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int row = 0;
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
            if(++row % 2 == 0) {
                Collections.reverse(list);
            }
            res.add(list);
        }
        return res;
    }
}
