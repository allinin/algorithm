package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.链表.快慢指针.easy;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;

/**
 *  链表的中间节点 easy
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[3,4,5]
 * 解释：链表只有一个中间结点，值为 3 。
 * 示例 2：
 *
 *
 * 输入：head = [1,2,3,4,5,6]
 * 输出：[4,5,6]
 * 解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
 *
 *
 * 提示：
 *
 * 链表的结点数范围是 [1, 100]
 * 1 <= Node.val <= 100
 * @author: ZBL
 * @date: 2024-09-09  19:15
 */
public class Code876 {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head,fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast == null ? slow : slow.next;
    }
}
