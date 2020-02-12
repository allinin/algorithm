package 左神算法.基础班.第三课;

import java.util.HashSet;

/**
 * 给定两个单链表的头结点head1和head2,这两个链表可能有环，也可能无环，这两个链表可能相交，也可能不相交，实现一个函数
 * 如果两个链表相交，请返回相交的第一个结点，如果不相交，返回null.
 * 如果链表1的长度为n，链表2的长度为m，本题的实现中，时间复杂度为O（m+n),额外空间复杂度为O（1），
 */

public class FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2){
         if(head1==null || head2==null)
             return null;
         Node loop1=getLoopNode(head1);
         Node loop2=getLoopNode(head2);
         if(loop1==null && loop2==null)
         {
             return noLoop(head1,head2);
         }else if(loop1!=null && loop2!=null)
         {
             return bothLoop(head1,loop1,head2,loop2);
         }else {
             return null;
         }
    }

    //判断一个链表是否有环，并且返回入环结点，使用hashset的方式
    public static Node getLoopNode1(Node head)
    {
        if(head==null)
            return null;
        HashSet<Node>set=new HashSet<>(); //hashset中存储的引用，也就是地址
        Node cur=head;
        while(cur!=null)
        {
            if(set.contains(cur))
            {
                return cur;
            }
            set.add(cur);
            cur=cur.next;
        }
        return null;
    }

    //不使用hashset的方式判断
    public static Node getLoopNode(Node head)
    {
        if(head==null || head.next==null || head.next.next==null)
            return null;
        Node fast=head.next.next;
        Node slow=head.next;
        while(fast!=slow)
        {
            if(fast.next==null || fast.next.next==null)//即：快指针能够走到终点
                return null;
            fast=fast.next.next;
            slow=slow.next;
        }
        fast=head;  //快指针从头开始重新走
        while(fast!=slow)
        {
            fast=fast.next;
            slow=slow.next;
        }
        return fast;

    }

    public static Node noLoop(Node head1,Node head2)
    {
        if(head1==null || head2==null)
            return null;
        Node cur1=head1;
        Node cur2=head2;
        int n=0;
        while(cur1.next!=null)
        {
            n++;
            cur1=cur1.next;
        }
        while(cur2.next!=null)
        {
            n--;
            cur2=cur2.next;
        }
        if(cur1!=cur2) //两个链表的最后一个结点是否相同
            return null;

        cur1=n>0?head1:head2;//cur1指向长链表
        cur2=cur1==head1?head2:head1; //cur2指向短链表

        n=Math.abs(n);
        while(n!=0)//长链表先走二者之间的长度差
        {    n--;
            cur1=cur1.next;
        }
        while(cur1!=cur2)
        {
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;

    }

    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2)
    {
        Node cur1=null;
        Node cur2=null;
        if(loop1==loop2)
        {
            cur1=head1;
            cur2=head2;
            int n=0;
            while(cur1!=loop1)
            {
                n++;
                cur1=cur1.next;
            }
            while(cur2!=loop2)
            {
                n--;
                cur2=cur2.next;
            }
            cur1=n>0?head1:head2;
            cur2=cur1==head1?head2:head1;
            n=Math.abs(n);
            while(n!=0)
            {   n--;
                cur1=cur1.next;
            }
            while(cur1!=cur2)
            {
                cur1=cur1.next;
                cur2=cur2.next;
            }
            return cur1;
        }else{
            cur1=loop1.next;
            while(cur1!=loop1)
            {
                if(cur1==loop2)
                    return loop1;
                cur1=cur1.next;
            }
            return null;

        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }


}
