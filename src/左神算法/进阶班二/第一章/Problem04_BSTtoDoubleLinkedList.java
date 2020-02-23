package 左神算法.进阶班二.第一章;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zbl
 * @version 1.0
 * @content:把一棵搜索二叉树，转化成有序的双向链表。
 * @date 2020/2/17 15:42
 */
public class Problem04_BSTtoDoubleLinkedList {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    
    public static Node bstToDoubleLinkedList(Node head){
        if(head==null)
            return head;
        Node[] nodes=process1(head);
        return nodes[0];
    }

    //方法一：返回以head为头结点的子树形成的双向链表的最左值与最右值
    //node[0]:最左
    //node[1]:最后
    private static Node[] process1(Node head) {
        if(head==null)
            return new Node[]{null,null};
        Node[] leftNodes = process1(head.left);
        Node[] rightNodes = process1(head.right);
        head.left=null;
        head.right=null;
        if(leftNodes[1]!=null){
            head.left=leftNodes[1];
            leftNodes[1].right=head;
        }
        if(rightNodes[0]!=null){
            head.right=rightNodes[0];
            rightNodes[0].left=head;
        }
        Node left=leftNodes[0]!=null ? leftNodes[0]:head;
        Node right=rightNodes[1]!=null ? rightNodes[1]:head;
        return new Node[]{left,right};


    }

    // 方法二：返回以head为头结点的子树形成的双向链表的最右值，同时最右结点的right指向头结点
    public static Node process2(Node head){
        if(head==null)
            return head;
       Node rightEnd= process2(head.right);
       Node leftEnd=process2(head.left);
       Node rights=rightEnd!=null ? rightEnd.right:null; //right start
       Node lefts=leftEnd!=null ? leftEnd.right:null; //left start
       if(rightEnd!=null && leftEnd!=null){
           leftEnd.right=head;
           head.left=leftEnd;
           head.right=rights;
           rights.left=head;
           rightEnd.right=lefts;
           return rightEnd;
       }
       if(leftEnd!=null){
           leftEnd.right=head;
           head.left=leftEnd;
           head.right=lefts;
           return head;
       }
       if(rightEnd!=null){
           head.right=rights;
           rights.left=head;
           rightEnd.right=head;
           return rightEnd;
       }else{
           head.right=head;
           return head;
       }

    }

    public static Node bstToDoubleLinkedList2(Node head){
        if(head==null)
            return null;
        Node node = process2(head);
        head=node.right;
        node.right=null;
        return head;
    }


    //方法三，将bst中序遍历的方式放入一个对列，然后将对列中的元素弹出，组成双向链表
    public static Node bstToDoubleLinkedList3(Node head){
        Queue<Node> queue=new LinkedList<>();
        inOrderToQueue(head,queue);
        if(queue.isEmpty()){
            return null;
        }
        head=queue.poll();
        Node pre=null;
        Node cur=head;
        cur.left=pre;
        while(!queue.isEmpty()){
            pre=cur;
            cur=queue.poll();
            pre.right=cur;
            cur.left=pre;
        }
        return head;
    }

    public static void inOrderToQueue(Node head, Queue<Node> queue){
        if(head==null)
            return;
        inOrderToQueue(head.left,queue);
        queue.add(head);
        inOrderToQueue(head.right,queue);
    }
    public static void printBSTInOrder(Node head) {
        System.out.print("BST in-order: ");
        if (head != null) {
            inOrderPrint(head);
        }
        System.out.println();
    }

    public static void inOrderPrint(Node head) {
        if (head == null) {
            return;
        }
        inOrderPrint(head.left);
        System.out.print(head.value + " ");
        inOrderPrint(head.right);
    }

    public static void printDoubleLinkedList(Node head) {
        System.out.print("Double Linked List: ");
        Node end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.right;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.left;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(9);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.right.right = new Node(4);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        head.left.left = new Node(1);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(8);

        printBSTInOrder(head);
        head = bstToDoubleLinkedList3(head);
        printDoubleLinkedList(head);

        head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(9);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.right.right = new Node(4);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        head.left.left = new Node(1);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(8);

        printBSTInOrder(head);
        head = bstToDoubleLinkedList2(head);
        printDoubleLinkedList(head);

        head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(9);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.right.right = new Node(4);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        head.left.left = new Node(1);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(8);

        printBSTInOrder(head);
        head = bstToDoubleLinkedList(head);
        printDoubleLinkedList(head);

    }
}
