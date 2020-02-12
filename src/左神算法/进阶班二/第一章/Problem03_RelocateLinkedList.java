package 左神算法.进阶班二.第一章;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 给定一个链表list，
如果：
list = 1 调整之后1。
list = 1->2 调整之后1->2
list = 1->2->3 调整之后1->2->3
list = 1->2->3->4 调整之后1->3->2->4
list = 1->2->3->4->5 调整之后1->3->2->4->5
list = 1->2->3->4->5->6 调整之后1->4->2->5->3->6
list = 1->2->3->4->5->6->7 调整之后1->4->2->5->3->6->7
根据上面的规律，调整一个任意长度的链表。
 * @date 2020/2/11 17:34
 */
public class Problem03_RelocateLinkedList {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //使用辅助数组的方式
    public static void relocate1(Node head){

        if(head==null || head.next==null || head.next.next==null){
            return;
        }
        int len=0;
        Node cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        Node [] arr=new Node[(len & 1)==1 ?len-1:len];
        cur=head;
        for(int i=0;i<arr.length;i++)
        {//最终cur会到达链表的最后位值
            arr[i]=cur;
            cur=cur.next;
        }
        Node[] help=new Node[arr.length];
        for(int i=0;i<help.length;i++){
            if(i<help.length/2){
                help[2*i]=arr[i];
            }else
            {
                help[(i-help.length/2)*2+1]=arr[i];
            }
        }
        int j=1;
        Node temp=head;
        while(j<help.length){
            temp.next=help[j];
            j++;
            temp=temp.next;
        }
        temp.next=cur;
    }

    //使用快慢指针的方式
    public static void relocate(Node head){
        if(head==null || head.next==null || head.next.next==null)
            return;
        Node left=head;
        Node right=head.next;//为了使right走到最后的时候，left处在左半部分的最后一个结点
        while(right.next!=null && right.next.next!=null){
            right=right.next.next;
            left=left.next;
        }
        right=left.next;//right指向右半部分的第一个节点
        left.next=null;//断开左右两部分
        mergeLR(head,right);

    }

    public static void mergeLR(Node left,Node right){
       Node next=null;
       while(left.next!=null){
           next=right.next;
           right.next=left.next;
           left.next=right;
           left=right.next;
           right=next;
       }
       left.next=right;
    }


    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        relocate(head);
        printLinkedList(head);
    }

}
