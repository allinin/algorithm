package Leetcode.list;

import java.util.LinkedList;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/7/21 22:35
 */
public class Solution82 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        LinkedList<ListNode>list=new LinkedList<>();
        ListNode cur=head;
        while(cur!=null){
            if(list.isEmpty() || list.peekLast().val!=cur.val){
                list.add(cur);
                cur=cur.next;
            }else{
                while(cur!=null && list.peekLast().val==cur.val){
                    cur=cur.next;
                }
                list.pollLast();
                if(!list.isEmpty())list.peekLast().next=null;//断开list中最后一个元素与原来元素的连接关系
            }
        }
        if(list.isEmpty()) return null;
        ListNode newhead=list.pollFirst();
        ListNode next=newhead;
        while(!list.isEmpty()){
            next.next=list.pollFirst();
            next=next.next;
        }
        return newhead;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode cur=head,pre=null,prepre=null;
        boolean flag=false;//表示 是否找到了头结点
        ListNode newHead=null;
        while(cur!=null){
            if(cur!=cur.next){
                if(!flag){
                    newHead=cur;
                    flag=true;
                }
                prepre=pre;
                pre=cur;
                cur=cur.next;
            }else{
                if(pre!=null) pre.next=null;//断开连接
                while(cur!=null && cur==cur.next){
                    cur=cur.next;
                }
                if(cur!=null){
                    ListNode tmp=cur.next;
                    cur.next=null;//断开连接
                    cur=tmp;
                    if(pre!=null) pre.next=cur;
                }
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(2);
        deleteDuplicates(head);
    }

}
