package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import HOT100和TOP面试题.ListNode;

/**
 * @Author: ZBL
 * @Date: 2024-01-04  10:14
 * 分割链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class Face0204 {
    public ListNode partition(ListNode head, int x) {
        ListNode dumpyLess = new ListNode(0);
        ListNode dumpyBig = new ListNode(0);
        ListNode cur = head, less = dumpyLess, big = dumpyBig;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                less.next = cur;
                less = less.next;
            } else {
                big.next = cur;
                big = big.next;
            }
            cur.next = null;
            cur = next;
        }
        less.next = dumpyBig.next;
        return dumpyLess.next;
    }
}
