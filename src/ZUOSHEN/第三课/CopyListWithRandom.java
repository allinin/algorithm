package ZUOSHEN.第三课;

import java.util.HashMap;

public class CopyListWithRandom {

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    //放入一个hashmap，找对应关系
    public static Node copyListWithRand1(Node head){
        HashMap<Node,Node>map=new HashMap<>();
        Node cur=head;
        while(cur!=null)
        {
            map.put(cur,new Node(cur.value));
            cur=cur.next;
        }
        cur=head;
        while(cur!=null)
        {
            map.get(cur).next=map.get(cur.next);
            map.get(cur).rand=map.get(cur.rand);
            cur=cur.next;
        }
        return map.get(head);
    }
    public static Node copyListWithRand2(Node head){

         if(head==null)
         {
             return null;
         }
        Node cur=head;
        Node next=null;
        //copy node and link
        while(cur!=null)
        {
            next=cur.next;
            Node node=new Node(cur.value);
            node.next=cur.next;
            cur.next=node;
            cur=next;
        }
        cur=head;
        Node curCopy=null;

        //set copyNode rand
        while(cur!=null)
        {
            next=cur.next.next;
            curCopy=cur.next;
            curCopy.rand=cur.rand!=null?cur.rand.next:null;//注意判断是否为null
            cur=next;
        }
        Node res=head.next;
        cur=head;
        //split              cur.next=next;//断开连接
        while(cur!=null)
        {
            next=cur.next.next;
            curCopy=cur.next;
            cur.next=next;//断开连接
            curCopy.next=next!=null?next.next:null;//注意判断是否为null,将复制的结点连接起来
            cur=next;

        }
        return res;

    }

    public static void printRandLinkedList(Node head)
    {
        Node cur=head;
        System.out.print("order: ");
        while(cur!=null)
        {
            System.out.print(cur.value+"\t");
            cur=cur.next;
        }
        System.out.println();
        cur=head;
        System.out.print("rand: ");
        while(cur!=null)
        {
            System.out.print(cur.rand==null? "-":cur.rand.value+"\t");
            cur=cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }

}
