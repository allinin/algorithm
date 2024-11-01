package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.BFS;

import 工作后刷题.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的堂兄弟节点II medium
 * 给你一棵二叉树的根 root ，请你将每个节点的值替换成该节点的所有 堂兄弟节点值的和 。
 * <p>
 * 如果两个节点在树中有相同的深度且它们的父节点不同，那么它们互为 堂兄弟 。
 * <p>
 * 请你返回修改值之后，树的根 root 。
 * <p>
 * 注意，一个节点的深度指的是从树根节点到这个节点经过的边数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,4,9,1,10,null,7]
 * 输出：[0,0,0,7,7,null,11]
 * 解释：上图展示了初始的二叉树和修改每个节点的值之后的二叉树。
 * - 值为 5 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 4 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 9 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 1 的节点有一个堂兄弟，值为 7 ，所以值修改为 7 。
 * - 值为 10 的节点有一个堂兄弟，值为 7 ，所以值修改为 7 。
 * - 值为 7 的节点有两个堂兄弟，值分别为 1 和 10 ，所以值修改为 11 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [3,1,2]
 * 输出：[0,0,0]
 * 解释：上图展示了初始的二叉树和修改每个节点的值之后的二叉树。
 * - 值为 3 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 1 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 2 的节点没有堂兄弟，所以值修改为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目的范围是 [1, 105] 。
 * 1 <= Node.val <= 104
 *
 * @author: ZBL
 * @date: 2024-10-29  09:24
 */
public class Code2641 {
    public TreeNode replaceValueInTree(TreeNode root) {
        Deque<Node> deque = new LinkedList<>();
        deque.add(new Node(root));
        int sum = root.val;
        int nextSum = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.poll();
                TreeNode treeNode = node.treeNode;
                treeNode.val = sum - treeNode.val - node.brotherValue;
                if (treeNode.left != null) {
                    deque.add(new Node(treeNode.left, treeNode.right != null ? treeNode.right.val : 0));
                    nextSum += treeNode.left.val;
                }
                if (treeNode.right != null) {
                    deque.add(new Node(treeNode.right, treeNode.left != null ? treeNode.left.val : 0));
                    nextSum += treeNode.right.val;
                }
            }
            sum = nextSum;
            nextSum = 0;
        }
        return root;
    }
}

class Node {
    TreeNode treeNode;

    public int brotherValue; //当前treeNode 节点兄弟节点的值

    public Node(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    public Node(TreeNode treeNode, int brotherValue) {
        this.treeNode = treeNode;
        this.brotherValue = brotherValue;
    }

}
