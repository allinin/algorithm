package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.链表.删除系列.easy;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;

import java.util.List;

/**
 * 移动链表元素 easy
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，
 * 并返回 新的头节点 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * @Author:zbl
 * @Date:2024/9/15 14:53
 */
public class Code203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dumpy = new ListNode(-1);
        ListNode cur = dumpy;
        while (head != null) {
            if (head.val != val) {
                cur.next = head;
                cur = cur.next;
                head = head.next;
            } else {
                head = head.next;
                //针对最后一个节点的值是val的情况
                if (head == null) {
                    cur.next = null;
                }
            }
        }
        return dumpy.next;
    }
}
