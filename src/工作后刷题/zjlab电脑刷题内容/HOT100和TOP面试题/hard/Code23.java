package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

/**
 * 合并k个有序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class Code23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return process(lists,0,lists.length - 1);
    }
    private ListNode process(ListNode[] list,int left,int right) {
        if(left == right) {
            return list[left];
        }
        if(left + 1 == right) {
            return merge(list[left],list[right]);
        }
        int mid = left + (right - left) / 2;
        ListNode leftNode = process(list,left,mid);
        ListNode rightNode = process(list,mid + 1,right);
        return merge(leftNode,rightNode);
    }

    private ListNode merge(ListNode list1,ListNode list2) {
        ListNode dumpy = new ListNode(0);
        ListNode cur = dumpy;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1 == null) {
            cur.next = list2;
        }
        if(list2 == null) {
            cur.next = list1;
        }
        return dumpy.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int  val) {
        this.val = val;
    }
    ListNode(int val,ListNode next) {
        this.val = val;
        this.next = next;
    }
}
