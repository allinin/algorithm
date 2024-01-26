package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import HOT100和TOP面试题.ListNode;
import HOT100和TOP面试题.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-05  09:39
 * 特定深度节点列表
 * <p>
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表
 * （比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[1,2,3,4,5,null,7,8]
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * /
 * 8
 * <p>
 * 输出：[[1],[2,3],[4,5,7],[8]]
 */
public class Face0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(tree);
        while (!deque.isEmpty()) {
            int size = deque.size();
            ListNode head = null, pre = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                ListNode cur = new ListNode(node.val);
                if (head == null) {
                    head = cur;
                } else {
                    pre.next = cur;
                }
                pre = cur;
                if(node.left != null) {
                    deque.add(node.left);
                }
                if(node.right != null) {
                    deque.add(node.right);
                }
            }
            list.add(head);
        }
        return list.toArray(new ListNode[0]);

    }
}
