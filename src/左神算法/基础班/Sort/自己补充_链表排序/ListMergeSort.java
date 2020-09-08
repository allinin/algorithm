package 左神算法.基础班.Sort.自己补充_链表排序;

/**
 * @author zbl
 * @version 1.0
 * @content:链表的归并排序 ：leetcode 148
 * @date 2020/8/6 17:56
 */
public class ListMergeSort {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

     public ListNode sortList(ListNode head){
         if(head==null || head.next==null)
             return head;
         return mergeSort(head);
     }

     private static ListNode mergeSort(ListNode head){
         if(head==null || head.next==null)
             return head;
         //通过快慢指针来找中点
         ListNode slow=head,fast=head.next;//这样可以保证在偶数个结点的时候也能恰好均分，而不是造成分布不均匀
         while(fast!=null && fast.next!=null){
             fast=fast.next.next;
             slow=slow.next;
         }
         ListNode rightStart=slow.next;
         slow.next=null;//断开连接
         ListNode left=mergeSort(head);
         ListNode right=mergeSort(rightStart);
         return merge(left,right);
     }


     private static ListNode merge(ListNode left,ListNode right){
         ListNode dumpy=new ListNode(0);//哑结点
         ListNode cur=dumpy;
         while(left!=null && right!=null){
             if(left.val<=right.val){
                 cur.next=left;
                 cur=left;
                 left=left.next;
             }else{
                 cur.next=right;
                 cur=right;
                 right=right.next;
             }
         }
         cur.next=left!=null ? left:right;
         return dumpy.next;
     }
}
