package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;

import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-04  10:20
 * 链表求和
 *
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 */
public class Face0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumpy = new ListNode(0);
        ListNode cur = dumpy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            ListNode tmp = new ListNode(sum % 10);
            carry = sum / 10;
            cur.next = tmp;
            cur = cur.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

        }
        return dumpy.next;
    }
}
