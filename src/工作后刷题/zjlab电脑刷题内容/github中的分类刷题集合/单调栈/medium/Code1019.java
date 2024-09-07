package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.单调栈.medium;


import 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.ListNode;

import java.util.*;

/**
 * @Author: ZBL
 * @Date: 2024-02-04  09:56
 * 链表中的下一个更大节点(medium)
 * 给定一个长度为 n 的链表 head
 *
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，
 * 找到它旁边的第一个节点的值，这个节点的值 严格大于它的值。
 *
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 *
 *
 *
 * 输入：head = [2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 *
 *
 * 提示：
 *
 * 链表中节点数为 n
 * 1 <= n <= 104
 * 1 <= Node.val <= 109
 */
public class Code1019 {
    public int[] nextLargerNodes(ListNode head) {
        List<int[]> list = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        int idx = 0;
        while(head != null) {
            while(!stack.isEmpty() && stack.peek()[1] < head.val) {
                int[] pop = stack.pop();
                list.add(new int[]{pop[0],head.val});
            }
            stack.add(new int[]{idx++,head.val});
            head = head.next;
        }
        while(!stack.isEmpty()) {
            list.add(new int[]{stack.pop()[0],0});
        }
        Collections.sort(list,(a,b) -> a[0] - b[0]);
        int[] ans = new int[list.size()];
        for(int i = 0;i < list.size();i++) {
            ans[i] = list.get(i)[1];
        }
        return ans;
    }
}
