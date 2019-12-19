package ZUOSHEN.第三课;

import java.util.Stack;

public class IsPalindromeList {

    public static class Node{
        public int value;
        public Node next;
        public Node(int value)
        {
            this.value=value;
        }

    }

    //need n extra space
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //need n/2 extra space
    public static boolean isPalindrome2(Node head)
    {
        if(head==null || head.next==null)
            return true;
        Node fast=head;
        Node cur=head.next;
        while(fast.next!=null && fast.next.next!=null)
        {
            cur=cur.next;
            fast=fast.next.next;
        }
        Stack<Node> stack=new Stack<>();
        while(cur!=null)
        {
            stack.push(cur);
            cur=cur.next;
        }
        while(!stack.isEmpty()){
            if(head.value!=stack.pop().value)
                return false;
            head=head.next;
        }
        return true;
    }


    //need O(1) extra space
    public static boolean isPalindrome3(Node head){
        if(head==null || head.next==null)
            return true;
        Node n1=head;
        Node n2=head;
        while(n2.next!=null && n2.next.next!=null)
        {
            n1=n1.next; //n1->mid
            n2=n2.next.next;//n2->end
        }
        n2=n1.next; //n2->right part first node
        n1.next=null;//mid.next->null
        Node n3=null;
        while(n2!=null)  //right part convert
        {
            n3=n2.next;//save next part
            n2.next=n1;//next of right node convert
            n1=n2;//n1 move
            n2=n3;//n2 move
        }
        n3=n1;//save the last node
        n2=head;//left first node
        boolean res=true;
        while(n1!=null && n2!=null)//对于链表一共有奇数个元素和偶数个元素都适用
        {
            if(n1.value!=n2.value)
            {
                res=false;
                break;
            }
            n1=n1.next;
            n2=n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return res;

    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }
}
