package 剑指offer牛客上没有的题目;

/**
 * @author zbl
 * @version 1.0
 * @content:给定链表的头指针和一个结点指针，在O(1)时间删除该结点
 * @date 2020/3/29 11:49
 */
public class DeleteLinkedNode {

    public static class Node{
        private int val;
        private Node next;
        public  Node(int val){
            this.val=val;
        }
    }
    public static void delete(Node head,Node del){
        if(head==null) return;
        if(head==del) head=head.next;
        if(del.next!=null){
            del.val=del.next.val;
            del.next=del.next.next;
        }else{
            Node temp=head;
            while(temp.next.next==null){
                temp=temp.next;
            }
            temp.next=null;
        }
    }
}
