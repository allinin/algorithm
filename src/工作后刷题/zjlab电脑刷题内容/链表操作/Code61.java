package 工作后刷题.zjlab电脑刷题内容.链表操作;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 *
 * @author: ZBL
 * @date: 2024-07-19  19:43
 */
public class Code61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int num = 0;
        ListNode cur = head;
        ListNode last = null;
        while (cur != null) {
            last = cur;
            cur = cur.next;
            num++;
        }
        //此时pre是最后一个节点
        if (k % num == 0) {
            return head;
        }
        int targetNum = num - (k % num);
        ListNode pre = head;
        cur = head;
        //右移k后 <==> 移动targetNum后所在的节点为新的头结点，然后将last指向头结点即可
        while (targetNum-- > 0) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        last.next = head;
        return cur;
    }
}
