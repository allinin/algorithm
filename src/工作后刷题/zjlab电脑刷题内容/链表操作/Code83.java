package 工作后刷题.zjlab电脑刷题内容.链表操作;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;


/**
 * @Author: ZBL
 * @Date: 2024-03-11  10:56
 * 删除排序链表中的重复元素(easy)
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class Code83 {

    public ListNode deleteDuplicates(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode cur = root.next;
        ListNode pre = root;
        pre.next = null;
        while (cur != null) {
            if (cur.val == pre.val) {
                cur = cur.next;
                continue;
            }

            pre.next = cur;
            pre = cur;
            cur = cur.next;
            pre.next = null;
        }
        return root;
    }
}
