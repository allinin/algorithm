package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.链表.反转系列.medium;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;

/**
 * 两数相加II MEDIUM
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * <p>
 * <p>
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 * <p>
 * <p>
 * 进阶：如果输入链表不能翻转该如何解决？
 *
 * @author: ZBL
 * @date: 2024-09-09  18:56
 */
public class Code445 {



    //反转链表的形式
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);
        return reverse(addTwo(head1, head2));
    }

    private ListNode reverse(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode newHead = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return newHead;
    }

    private ListNode addTwo(ListNode node1, ListNode node2) {
        if (node2 == null || node1 == null) {
            return node1 == null ? node2 : node1;
        }
        ListNode dumpy = new ListNode(-1);
        ListNode cur = dumpy;
        int carry = 0;
        while (node1 != null || node2 != null || carry != 0) {
            int val1 = node1 != null ? node1.val : 0;
            int val2 = node2 != null ? node2.val : 0;
            int sum = val2 + val1 + carry;
            ListNode next = new ListNode(sum % 10);
            cur.next = next;
            cur = cur.next;
            carry = sum / 10;
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null;
        }
        return dumpy.next;
    }
}
