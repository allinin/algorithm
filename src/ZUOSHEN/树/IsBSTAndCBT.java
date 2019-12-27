package ZUOSHEN.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一颗树是否是搜索二叉树，判断一颗树是否是完全二叉树
 */
public class IsBSTAndCBT {

    public static class Node{
        public int value;
        public Node right;
        public Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    //moris中序遍历的方式
    public static boolean isBST(Node head)
    {
        if(head==null)
            return true;
        boolean res=true;
        Node pre=null;
        Node cur1=head;
        Node cur2=null;
        while(cur1!=null)
        {
            cur2=cur1.left;
            if(cur2!=null)
            {
                while(cur2.right!=null && cur2.right!=cur1)
                {
                    cur2=cur2.right;
                }
                if(cur2.right==null)
                {
                    cur2.right=cur1;
                    cur1=cur1.left;
                    continue;
                }else{
                    cur2.right=null;
                    }
            }
            if(pre!=null && pre.value>cur1.value)
                res=false;
            pre=cur1;
            cur1=cur1.right;
        }
        return res;
    }

    //判断你是否是完全二叉树
    public static boolean isCBT(Node head)
    {
       if(head==null)
           return true;
        Queue<Node>queue=new LinkedList<>();
        boolean leaf=false;////是否开启了叶节点的阶段，即：存在左孩子，但没有右孩子，开启叶节点的阶段。此时遍历遇到的结点应该都是叶节点，
        queue.offer(head);
        Node left=null;
        Node right=null;
        while(!queue.isEmpty())
        {
            head=queue.poll();
            left=head.left;
            right=head.right;
            if((leaf && (left!=null || right!=null)) || (left==null && right!=null)) //左子节点不存在，右子节点存在，为false；开启叶子结点步骤后，还存在叶子结点，为false
                return false;
            if(left!=null)
            {
                queue.offer(left);
            }
            if(right!=null)
                queue.offer(right);
            // 即当两个节点不都存在的时候开启叶子结点步骤
            if(left==null || right==null)
                leaf=true;
        }
        return true;

    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }
}
