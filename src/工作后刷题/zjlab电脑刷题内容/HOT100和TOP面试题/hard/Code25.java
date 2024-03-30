package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

import java.util.List;

/**
 * @Author:zbl
 * @Date:2024/3/30 14:45
 * k个一组翻转链表(hard)
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * <p>
 * <p>
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * <p>
 * <p>
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 */
public class Code25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int sum = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            sum++;
        }
        if (sum < k) {
            return head;
        }
        int reverseTime = sum / k;
        ListNode start = head, nowEnd = null, ans = null;
        for (int i = 0; i < reverseTime; i++) {
            ListNode[] res = reverse(start, k);
            start = res[2];

            if (ans == null) {
                ans = res[1];
            }

            if (nowEnd == null) {
                nowEnd = res[0];
            } else {
                nowEnd.next = res[1];
                nowEnd = res[0];
            }

        }
        //连接起来
        nowEnd.next = start;
        return ans;
    }

    private ListNode[] reverse(ListNode head, int k) {
        ListNode[] res = new ListNode[3];
        res[0] = head; //从head位置开始翻转k个后子链表的末尾节点
        ListNode cur = head, pre = null, next = null;
        while (k > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            --k;
        }
        res[1] = pre;//从head位置开始翻转k个后子链表的起始节点
        res[2] = cur;//下一次翻转的起始节点
        return res;
    }
}
