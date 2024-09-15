package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.链表.删除系列.medium;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;

/**
 * 删除链表的倒数第n个节点 medium
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 * @Author:zbl
 * @Date:2024/9/15 14:34
 */
public class Code19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        while(n-- > 0 && tmp != null) {
            tmp = tmp.next;
        }
        if(tmp == null) {
            return head.next;
        }
        ListNode cur = head;
        ListNode pre = null;
        while(tmp != null) {
            tmp = tmp.next;
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return head;
    }
}
