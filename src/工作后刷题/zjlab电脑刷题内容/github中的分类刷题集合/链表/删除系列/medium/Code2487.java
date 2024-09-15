package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.链表.删除系列.medium;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 从链表中移除节点 medium
 * 给你一个链表的头节点 head 。
 * <p>
 * 移除每个右侧有一个更大数值的节点。
 * <p>
 * 返回修改后链表的头节点 head 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [5,2,13,3,8]
 * 输出：[13,8]
 * 解释：需要移除的节点是 5 ，2 和 3 。
 * - 节点 13 在节点 5 右侧。
 * - 节点 13 在节点 2 右侧。
 * - 节点 8 在节点 3 右侧。
 * 示例 2：
 * <p>
 * 输入：head = [1,1,1,1]
 * 输出：[1,1,1,1]
 * 解释：每个节点的值都是 1 ，所以没有需要移除的节点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定列表中的节点数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 *
 * @Author:zbl
 * @Date:2024/9/15 15:13
 */
public class Code2487 {

    //方法一：栈(可以用deque模拟)的方式

    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList<ListNode> deque = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            while (!deque.isEmpty() && deque.peekLast().val < cur.val) {
                ListNode node = deque.pollLast();
                node.next = null;
            }
            //头节点的元素的next指向cur
            if (!deque.isEmpty()) {
                deque.peekLast().next = cur;
            }
            deque.addLast(cur);
            cur = cur.next;
        }
       return deque.peekFirst();
    }
    //方法二：递归
    public ListNode removeNodes2(ListNode head) {
       if(head == null || head.next == null) {
           return head;
       }
       //head2是子链表处理后的最大值
       ListNode head2 = removeNodes2(head.next);
       if(head.val < head2.val) {
           return head2;
       }
       head.next = head2;
       return head;
    }
}
