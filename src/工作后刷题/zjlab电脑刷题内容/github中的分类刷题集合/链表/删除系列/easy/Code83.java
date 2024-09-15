package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.链表.删除系列.easy;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;

/**
 * 删除链表中的重复元素 easy
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 * @Author:zbl
 * @Date:2024/9/15 14:40
 */
public class Code83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            while (cur != null && pre.val == cur.val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
        }
        return head;
    }
}
