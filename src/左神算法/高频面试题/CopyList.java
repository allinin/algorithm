package 左神算法.高频面试题;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content:  实现对一个特殊链表的拷贝
 * @date 2020/1/5 10:30
 */
public class CopyList {

    public static class Node{
        public int data;
        public Node next;
        public Node random;

        public Node(int data) {
            this.data = data;
        }
    }


    //通过hashmap的方式来拷贝
    public static Node copy1(Node head){
        HashMap<Node,Node>map=new HashMap<>();
        Node cur=head;
        while(cur!=null){
            map.put(cur,new Node(cur.data));
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }

    //非map的方法
    public static Node copy2(Node head){
        Node cur=head;
        Node next=null;
        if(head==null){
            return null;
        }
        while(cur!=null){
            next=cur.next;
            Node node=new Node(cur.data);
            cur.next=node;
            node.next=next;
            cur=next;

        }
        Node copy=null;
        cur=head;
        while(cur!=null){
            next=cur.next.next;
            copy=cur.next;
            copy.random=cur.random!=null?cur.random.next:null;//注意判断是否为null
            cur=next;
        }
        //split
        Node res=head.next;
        cur=head;
        while(cur!=null){
            next=cur.next.next;
            copy=cur.next;
            copy.next=next!=null ? next.next:null;//注意这里要判断是否为空
            cur.next=next;//断开连接
            cur=next;
        }
        return res;
    }

    public static void printRandLinkedList(CopyList.Node head)
    {
        CopyList.Node cur=head;
        System.out.print("order: ");
        while(cur!=null)
        {
            System.out.print(cur.data+"\t");
            cur=cur.next;
        }
        System.out.println();
        cur=head;
        System.out.print("rand: ");
        while(cur!=null)
        {
            System.out.print(cur.random==null? "-":cur.random.data+"\t");
            cur=cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CopyList.Node head = null;
        CopyList.Node res1 = null;
        CopyList.Node res2 = null;
        printRandLinkedList(head);
        res1 = copy1(head);
        printRandLinkedList(res1);
        res2 = copy2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new CopyList.Node(1);
        head.next = new CopyList.Node(2);
        head.next.next = new CopyList.Node(3);
        head.next.next.next = new CopyList.Node(4);
        head.next.next.next.next = new CopyList.Node(5);
        head.next.next.next.next.next = new CopyList.Node(6);

        head.random = head.next.next.next.next.next; // 1 -> 6
        head.next.random = head.next.next.next.next.next; // 2 -> 6
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = null; // 5 -> null
        head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copy1(head);
        printRandLinkedList(res1);
        res2 = copy2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
}
