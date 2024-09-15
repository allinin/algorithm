package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.链表.删除系列.medium;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;

import java.util.List;

/**
 * 删除链表中的重复元素II medium
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 * @Author:zbl
 * @Date:2024/9/15 14:44
 */
public class Code82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dumpy = new ListNode(-1111);
        ListNode cur = dumpy, curStart = head, curEnd = head.next;
        boolean delete = false;
        while (curEnd != null) {
            while (curEnd != null && curStart.val == curEnd.val) {
                curEnd = curEnd.next;
                delete = true;
            }
            if (!delete) {
                cur.next = curStart;
                cur = cur.next;
                curStart = curEnd;
                curEnd = curEnd.next;
            } else {
                delete = false;
                curStart = curEnd;
                curEnd = curEnd != null ? curEnd.next : null;
            }
        }
        cur.next = curStart;
        return dumpy.next;
    }
}
