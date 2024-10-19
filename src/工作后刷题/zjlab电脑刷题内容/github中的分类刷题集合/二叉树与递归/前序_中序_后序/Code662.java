package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二叉树与递归.前序_中序_后序;

import 工作后刷题.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的最大宽度 medium
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * <p>
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * <p>
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
 * 将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * <p>
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5,3,null,9]
 * 输出：4
 * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5,null,null,9,6,null,7]
 * 输出：7
 * 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5]
 * 输出：2
 * 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目范围是 [1, 3000]
 * -100 <= Node.val <= 100
 *
 * @Author:zbl
 * @Date:2024/10/19 12:27
 */
public class Code662 {

    //输入是树的形式
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Node> deque = new LinkedList<>();
        deque.add(new Node(root, 0));
        int ans = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            int left = 0, right = 0;
            for (int i = 0; i < size; i++) {
                Node node = deque.poll();
                TreeNode treeNode = node.treeNode;
                if (i == 0) {
                    left = node.index;
                }
                if (i == size - 1) {
                    right = node.index;
                }
                if (treeNode.left != null) {
                    deque.add(new Node(treeNode.left, 2 * node.index + 1));
                }
                if (treeNode.right != null) {
                    deque.add(new Node(treeNode.right, 2 * node.index + 2));
                }
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    //输入是树的按层遍历的数组形式
    public int widthOfBinaryTree(Integer[] arr) {
        //按行构建二叉树
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int ans = 1;
        Deque<Node2> deque = new LinkedList<>();
        deque.add(new Node2(arr[0], 0));
        int idx = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            int left = 0, right = 0;
            for (int i = 0; i < size; i++) {
                Node2 node = deque.poll();
                if (i == 0) {
                    left = node.index;
                }
                if (i == size - 1) {
                    right = node.index;
                }
                if (idx < arr.length && arr[idx++] != null) {
                    Node2 leftNode = new Node2(arr[idx - 1], node.index * 2 + 1);
                    deque.add(leftNode);
                }
                if (idx < arr.length && arr[idx++] != null) {
                    Node2 rightNode = new Node2(arr[idx - 1], node.index * 2 + 2);
                    deque.add(rightNode);
                }
            }
            ans = Math.max(ans,right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Code662().widthOfBinaryTree(new Integer[]{1,3,2,5}));
    }


}

class Node {
    TreeNode treeNode;
    int index; // 当前node的索引编号

    public Node(TreeNode treeNode, int idx) {
        this.index = idx;
        this.treeNode = treeNode;
    }
}

class Node2 {
    int val;

    Node2 left;
    Node2 right;
    int index; // 当前node的索引编号

    public Node2(int val, int idx) {
        this.index = idx;
        this.val = val;
    }

    public Node2(int val, int idx, Node2 left, Node2 right) {
        this.index = idx;
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

