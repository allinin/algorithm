package 工作后刷题.zjlab电脑刷题内容.链表操作;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;


/**
 * @Author: ZBL
 * @Date: 2024-03-11  10:51
 * 删除排序链表中的重复元素(II) medium
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
 */
public class Code82 {

    public ListNode deleteDuplicates(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode dumpy = new ListNode(-101);
        ListNode cur = dumpy;
        ListNode now1 = root, now2 = root.next;
        while (now2 != null) {
            if (now1.val != now2.val) {
                cur.next = now1;
                cur = cur.next;
                now1 = now2;
                now2 = now2.next;
            } else {
                //注意需要先判断now2是否为null
                while (now2 != null && now1.val == now2.val) {
                    now2 = now2.next;
                }

                if (now2 != null && now2.next != null) {
                    now1 = now2;
                    now2 = now2.next;
                } else if (now2 != null) {
                    cur.next = now2;
                    break;
                } else {
                    //说明从now1一直到最后一个元素都是重复元素，所以应该舍掉后续所有的元素
                    cur.next = null;
                }
            }
        }
        return dumpy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dumpy = new ListNode(-1);//哑结点
        ListNode pre = head,cur = head.next,help = dumpy;
        boolean isDelete = false; //当前节点是否需要删除
        while(cur != null) {
            if(pre.val == cur.val) {
                isDelete = true;
                cur = cur.next;
                continue;
            }
            //不相等的情况
            if(isDelete) {
                //如果前边的判断已经确定当前节点需要删除，则跳过，同时将isDelete设置为false
                pre = cur;
                isDelete = false;
            } else {
                //否则的话加入到结果链表
                help.next = pre;
                help = help.next;
                pre = cur;
                help.next = null;
            }
            cur = cur.next;
        }
        //连接上最后一个可能的节点
        if(!isDelete) {
            help.next = pre;
        }
        return dumpy.next;
    }
}
