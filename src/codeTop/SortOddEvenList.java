package codeTop;

/**
 * 给定一个奇数位升序，偶数位降序的链表，将其重新排序。
 *
 * 输入: 1->8->3->6->5->4->7->2->NULL
 * 输出: 1->2->3->4->5->6->7->8->NULL
 */
public class SortOddEvenList {
    class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortOddEvenList(ListNode root){
        if(root == null || root.next == null){
            return root;
        }
        ListNode oddHead = root,evenHead = root.next;
        ListNode cur1 = oddHead,cur2 = evenHead;
        //将链表分成两部分
        while(cur2 != null && cur2.next != null){
            cur1.next = cur2.next;
            cur2.next = cur2.next.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        //将偶数位置的链表翻转
        ListNode pre = null;
        ListNode cur = evenHead;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //合并两个链表
        ListNode dumpy = new ListNode(0);
        ListNode tmp =  dumpy;
        while(pre != null && oddHead != null){
            if(pre.val <= oddHead.val){
                tmp.next = pre;
                pre = pre.next;
            }else{
                tmp.next = oddHead;
                oddHead = oddHead.next;
            }
            tmp = tmp.next;
        }
        if(pre != null){
            tmp.next = pre;
        }
        if(oddHead != null){
            tmp.next = oddHead;
        }
        return dumpy.next;
    }

}
