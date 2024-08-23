package 工作后刷题.zjlab电脑刷题内容.链表操作;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;

import java.util.List;

/**
 * 排序链表（medium)
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * <p>
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * @author: ZBL
 * @date: 2024-07-25  18:58
 */
public class Code148 {

    //类似二分的方式
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        //将原来的链表分为两部分
        slow.next = null;
        //前半部分排序
        ListNode sortHead1 = sortList(head);
        //后半部分排序
        ListNode sortHead2 = sortList(head2);
        //合并排序的结果
        return merge(sortHead1,sortHead2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dumpy = new ListNode(0);
        ListNode cur = dumpy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 == null) {
            cur.next = head2;
        } else if (head2 == null) {
            cur.next = head1;
        }
        return dumpy.next;
    }
}
