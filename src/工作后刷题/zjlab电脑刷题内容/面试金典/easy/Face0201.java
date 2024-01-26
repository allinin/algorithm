package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

import HOT100和TOP面试题.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ZBL
 * @Date: 2024-01-04  09:41
 * <p>
 * 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 */
public class Face0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode dumpy = new ListNode(0);
        ListNode cur = dumpy;
        while (head != null) {
            if (!set.contains(head.val)) {
                cur.next = head;
                cur = cur.next;
                set.add(head.val);
            }
            head = head.next;
        }
        cur.next = null;
        return dumpy.next;
    }
}
