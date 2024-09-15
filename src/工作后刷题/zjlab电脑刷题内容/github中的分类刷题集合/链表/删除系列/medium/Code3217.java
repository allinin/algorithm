package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.链表.删除系列.medium;

import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 从链表中移除数组中存在的节点 medium
 * 给你一个整数数组 nums 和一个链表的头节点 head。从链表中移除所有存在于 nums 中的节点后，
 * 返回修改后的链表的头节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,3], head = [1,2,3,4,5]
 * <p>
 * 输出： [4,5]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 移除数值为 1, 2 和 3 的节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1], head = [1,2,1,2,1,2]
 * <p>
 * 输出： [2,2,2]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 移除数值为 1 的节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [5], head = [1,2,3,4]
 * <p>
 * 输出： [1,2,3,4]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 链表中不存在值为 5 的节点。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * nums 中的所有元素都是唯一的。
 * 链表中的节点数在 [1, 105] 的范围内。
 * 1 <= Node.val <= 105
 * 输入保证链表中至少有一个值没有在 nums 中出现过。
 *
 * @Author:zbl
 * @Date:2024/9/15 15:00
 */
public class Code3217 {

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode dumpy = new ListNode(-1);
        ListNode cur = dumpy;
        while (head != null) {
            if (!set.contains(head.val)) {
                cur.next = head;
                head = head.next;
                cur = cur.next;
            } else {
                head = head.next;
                //已经到达最后了，即:最后一个节点需要删除的情况
                if(head == null) {
                    cur.next = null;
                }
            }
        }
        return dumpy.next;
    }
}
