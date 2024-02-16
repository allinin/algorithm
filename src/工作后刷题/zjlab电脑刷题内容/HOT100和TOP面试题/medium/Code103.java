package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2023-12-20  15:44
 * <p>
 * 二叉树的锯齿形层次遍历
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */
public class Code103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean reverse = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                if (reverse) {
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }
            }
            //或者list定义为ArrayList,根据是否需要reverse,通过Collections.reverse(list)来控制内部列表的翻转
            reverse = !reverse;
            res.add(list);
        }
        return res;

    }
}
