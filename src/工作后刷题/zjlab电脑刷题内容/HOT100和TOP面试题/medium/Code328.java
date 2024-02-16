package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;

import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-02  09:17
 * <p>
 * 奇偶链表
 * <p>
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * <p>
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * <p>
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * <p>
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 * <p>
 * <p>
 * 提示:
 * <p>
 * n ==  链表中的节点数
 * 0 <= n <= 104
 * -106 <= Node.val <= 106
 */
public class Code328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode cur = even.next;
        ListNode oddCur = odd, evenCur = even;
        oddCur.next = null;
        evenCur.next = null;
        int num = 3;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            //奇数
            if (num % 2 == 1) {
                oddCur.next = cur;
                oddCur = oddCur.next;
            } else {
                evenCur.next = cur;
                evenCur = evenCur.next;
            }
            cur = next;
            num++;
        }
        oddCur.next = even;
        return odd;
    }
}
