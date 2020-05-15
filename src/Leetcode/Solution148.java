package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4

示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5

 * @date 2020/4/21 19:54
 */
public class Solution148 {

    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

    public ListNode sortList(ListNode head) {
        if(head==null ||head.next==null)
            return head;
        ListNode first=head;//新链表的头
        ListNode cur=head.next;
        ListNode last=head;//新链表的尾结点
        first.next=null;//将新链表与旧链表分开
        last.next=null;//将新链表与旧链表分开
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            if(cur.val>=last.val){
                last.next=cur;
                last=cur;
                last.next=null;
            }else if(first.val>=cur.val){
                cur.next=first;
                first=cur;
            }else{
                ListNode tmp=first;
                while(tmp.next!=null && tmp.next.val<cur.val){
                    tmp=tmp.next;
                }
                cur.next=tmp.next;
                tmp.next=cur;
            }
            cur=next;

        }

        return first;
    }

    //时间复杂度O(nlogn),空间复杂度O(1)
    public ListNode sortList2(ListNode head) {
        if(head==null ||head.next==null)
            return head;
        //通过快慢指针的方式找到链表的中点
        return sort(head);
    }

    public ListNode sort(ListNode head){
        if(head==null ||head.next==null)
            return head;
        //通过快慢指针的方式找到链表的中点
        ListNode slow=head;
        ListNode fast=head.next;//这样可以保证在偶数个结点的时候也能恰好均分，而不是造成分布不均匀
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode tmp=slow.next;//后半部分的起点
        slow.next=null;//前后两部分断开
        ListNode first=sort(head);
        ListNode second=sort(tmp);
        return merge(first,second);
    }

    public ListNode merge(ListNode first,ListNode second){
        ListNode tmp=new ListNode(0);//辅助结点
        ListNode res=tmp;
        while(first!=null && second!=null){
            if(first.val<=second.val){
                tmp.next=first;
                tmp=first;
                first=first.next;
            }else{
                tmp.next=second;
                tmp=second;
                second=second.next;
            }
        }
        tmp.next=first==null ? second:first;
        return res.next;
    }
}
