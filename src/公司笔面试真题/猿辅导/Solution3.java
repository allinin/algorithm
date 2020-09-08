package 公司笔面试真题.猿辅导;

/**
 * @author zbl
 * @version 1.0
 * @content:将一个链表中位置m到位置n的节点进行反转，要求只遍历一次

 * @date 2020/8/29 21:36
 */
public class Solution3 {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
        }

    }

    public static ListNode reverseBetween(ListNode head,int m,int n){
        if(head==null)
            return null;
        int i=1;
        ListNode cur=head,pre=null,next=null;
        if(m==1){

            while(i<=n && cur!=null){
                next=cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
                i++;
            }
            head.next=cur;
            return pre;
        }else{
            ListNode tmp=null;
            while(i<m){
                tmp=cur;
                cur=cur.next;
                i++;
            }
            //tmp.next=null;
            ListNode help=cur;
            while(i<=n && cur!=null){
                next=cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
                i++;
            }
            tmp.next=pre;
            help.next=cur;
            return head;

        }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode next1=new ListNode(2);
        ListNode next2=new ListNode(3);
        ListNode next3=new ListNode(4);
        ListNode next4=new ListNode(5);
        ListNode next5=new ListNode(7);
        head.next=next1;
        next1.next=next2;
        next2.next=next3;
        next3.next=next4;
        next4.next=next5;
        ListNode listNode = reverseBetween(head, 1, 8);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }


    }
}
