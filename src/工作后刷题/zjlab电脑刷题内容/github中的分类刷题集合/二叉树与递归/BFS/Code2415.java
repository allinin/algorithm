package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.BFS;

import 工作后刷题.TreeNode;

import java.util.*;

/**
 * 反转二叉树的奇数层 medium
 * 给你一棵 完美 二叉树的根节点 root ，请你反转这棵树中每个 奇数 层的节点值。
 * <p>
 * 例如，假设第 3 层的节点值是 [2,1,3,4,7,11,29,18] ，那么反转后它应该变成 [18,29,11,7,4,3,1,2] 。
 * 反转后，返回树的根节点。
 * <p>
 * 完美 二叉树需满足：二叉树的所有父节点都有两个子节点，且所有叶子节点都在同一层。
 * <p>
 * 节点的 层数 等于该节点到根节点之间的边数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,3,5,8,13,21,34]
 * 输出：[2,5,3,8,13,21,34]
 * 解释：
 * 这棵树只有一个奇数层。
 * 在第 1 层的节点分别是 3、5 ，反转后为 5、3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [7,13,11]
 * 输出：[7,11,13]
 * 解释：
 * 在第 1 层的节点分别是 13、11 ，反转后为 11、13 。
 * 示例 3：
 * <p>
 * 输入：root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
 * 输出：[0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
 * 解释：奇数层由非零值组成。
 * 在第 1 层的节点分别是 1、2 ，反转后为 2、1 。
 * 在第 3 层的节点分别是 1、1、1、1、2、2、2、2 ，反转后为 2、2、2、2、1、1、1、1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数目在范围 [1, 214] 内
 * 0 <= Node.val <= 105
 * root 是一棵 完美 二叉树
 *
 * @author: ZBL
 * @date: 2024-10-28  20:09
 */
public class Code2415 {

    //方法一：交换的是节点
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<TreeNode> help = new ArrayList<>();
        deque.add(root);
        int row = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                list.add(node);
            }
            if (row++ % 2 == 1) {
                Collections.reverse(list);
            }
            help.addAll(list);
        }
        reBuildTree(help);
        return root;
    }

    private void reBuildTree(List<TreeNode> nodes) {
        Deque<TreeNode> deque = new LinkedList<>();
        int idx = 0;
        deque.add(nodes.get(idx++));
        while (!deque.isEmpty() && idx < nodes.size()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                node.left = nodes.get(idx++);
                node.right = nodes.get(idx++);
                deque.add(node.left);
                deque.add(node.right);
            }
        }
    }

    //方法二：交换节点的值
    public TreeNode reverseOddLevels2(TreeNode root) {
        if (root == null) {
            return root;
        }
        //对称二叉树的思路
        dfs(root.left, root.right, 1);
        return root;
    }

    private void dfs(TreeNode left, TreeNode right, int level) {
        if(left == null || right == null) {
            return;
        }
        if (level % 2 == 1) {
            //奇数层交换值
            int value = left.val;
            left.val = right.val;
            right.val = value;
        }
        dfs(left.left,right.right,level + 1);
        dfs(left.right,right.left,level + 1);

    }

}
