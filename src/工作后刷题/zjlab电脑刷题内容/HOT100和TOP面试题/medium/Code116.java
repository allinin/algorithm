package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.LinkedList;

/**
 * @Author: ZBL
 * @Date: 2023-12-20  15:46
 * <p>
 * 填充每一个节点的下一个右侧指针
 * <p>
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * 示例 2:
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数量在 [0, 212 - 1] 范围内
 * -1000 <= node.val <= 1000
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Code116 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node cur = deque.poll();
                if (cur.left != null) {
                    deque.add(cur.left);
                }
                if (cur.right != null) {
                    deque.add(cur.right);
                }
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;
            }
        }
        return root;
    }

    //TODO 进阶：常量级别的空间复杂度
    public Node connect2(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        Node head = root;
        while(root.left != null) {
            Node cur = root;
            while(cur != null) {
                cur.left.next = cur.right;
                if(cur.right != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            root = root.left;
        }
        return head;
    }

    //返回root最左边及最右边的叶子节点
    private Node[] process(Node root) {
        Node[] res = new Node[2];
        //叶子节点
        if (root == null || root.left == null) {
            res[0] = root;
            res[1] = root;
            return res;
        }
        Node left = root.left;
        Node right = root.right;
        left.next = right;
        Node[] leftRes = process(left);
        Node[] rightRes = process(right);
        //节点间互联
        leftRes[1].next = rightRes[0];
        res[0] = leftRes[0];
        res[1] = rightRes[1];
        return res;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
