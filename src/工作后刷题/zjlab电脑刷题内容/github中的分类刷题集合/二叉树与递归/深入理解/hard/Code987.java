package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.深入理解.hard;

import 工作后刷题.TreeNode;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的垂直遍历 hard
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * <p>
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * <p>
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * <p>
 * 返回二叉树的 垂序遍历 序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 列 -1 ：只有结点 9 在此列中。
 * 列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
 * 列  1 ：只有结点 20 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 列 -2 ：只有结点 4 在此列中。
 * 列 -1 ：只有结点 2 在此列中。
 * 列  0 ：结点 1 、5 和 6 都在此列中。
 * 1 在上面，所以它出现在前面。
 * 5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
 * 列  1 ：只有结点 3 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,6,5,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
 * 因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中结点数目总数在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 *
 * @Author:zbl
 * @Date:2024/9/7 18:07
 */
public class Code987 {


    //自定义节点
    class Node {
        TreeNode treeNode;
        int row;
        int col;

        public Node(TreeNode treeNode, int row, int col) {
            this.treeNode = treeNode;
            this.row = row;
            this.col = col;
        }
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Node> help = new ArrayList<>();
        LinkedList<Node> deque = new LinkedList<>();
        deque.add(new Node(root, 0, 0));
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.poll();
                help.add(node);
                TreeNode treeNode = node.treeNode;
                if (treeNode.left != null) {
                    Node leftNode = new Node(treeNode.left, node.row + 1, node.col - 1);
                    deque.add(leftNode);

                }
                if (treeNode.right != null) {
                    Node rightNode = new Node(treeNode.right, node.row + 1, node.col + 1);
                    deque.add(rightNode);
                }
            }
        }
        Collections.sort(help, (a, b) -> {
            if(a.col != b.col) {
                return a.col - b.col;
            } else {
                if(a.row != b.row) {
                    return a.row - b.row;
                } else {
                    return a.treeNode.val - b.treeNode.val;
                }
            }
        });

        int nowCol = help.get(0).col;
        List<Integer> list = new ArrayList<>();
        for (Node node : help) {
            if (node.col == nowCol) {
                list.add(node.treeNode.val);
            } else {
                res.add(new ArrayList<>(list));
                list.clear();
                list.add(node.treeNode.val);
                nowCol = node.col;
            }
        }
        //将最后一个list中的元素放入
        res.add(new ArrayList<>(list));

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
        right.right = rightRight;
        List<List<Integer>> lists = new Code987().verticalTraversal(root);
        for(List<Integer> list : lists) {
            for(Integer num : list) {
                System.out.print(num +" ");
            }
            System.out.println();
        }

    }

}
