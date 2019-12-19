package ZUOSHEN.第四课;

import java.util.Stack;

public class PreInPostTree {      //非递归的方式实现树的前序，中序，后序遍历


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static void preOrderRecur(Node head) {
        System.out.println("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + "\t");
                if (head.right != null)
                    stack.add(head.right);
                if (head.left != null)
                    stack.add(head.left);
            }
        }
        System.out.println();
    }

    public static void inOrderRecur(Node head) {
        System.out.println("In-Order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.add(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + "\t");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void  posOrderRecur(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
//        System.out.println("============unrecursive=============");
//        preOrderUnRecur(head);
//        inOrderUnRecur(head);
//        posOrderUnRecur1(head);
//        posOrderUnRecur2(head);

    }
}
