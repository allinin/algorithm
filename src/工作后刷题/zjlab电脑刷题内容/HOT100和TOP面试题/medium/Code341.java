package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.Iterator;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-02  11:24
 * <p>
 * 扁平化嵌套列表迭代器
 *
 * <p>
 * 给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
 * <p>
 * 实现扁平迭代器类 NestedIterator ：
 * <p>
 * NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
 * int next() 返回嵌套列表的下一个整数。
 * boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。
 * 你的代码将会用下述伪代码检测：
 * <p>
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 * append iterator.next() to the end of res
 * return res
 * 如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nestedList = [[1,1],2,[1,1]]
 * 输出：[1,1,2,1,1]
 * 解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2：
 * <p>
 * 输入：nestedList = [1,[4,[6]]]
 * 输出：[1,4,6]
 * 解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nestedList.length <= 500
 * 嵌套列表中的整数值在范围 [-106, 106] 内
 */
public class Code341 {

    class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        Node(int val) {
            this.val = val;
        }
    }



    class NestedIterator implements Iterator<Integer> {

        public Node head = new Node(-1);


        public Node cur;

        //仿照LinkedList的iterator,初始化的时候将integer元素组织成node节点组成的list
        public NestedIterator(List<NestedInteger> nestedList) {
            processList(head,nestedList);
            this.cur = head.next;
        }

        private Node processList(Node cur, List<NestedInteger> nestedIntegers) {
            Node last = cur;
            for (NestedInteger nestedInteger : nestedIntegers) {
                if (nestedInteger.isInteger()) {
                    Node next = new Node(nestedInteger.getInteger());
                    last.next = next;
                    last = next;
                } else {
                    last = processList(last,nestedInteger.getList());
                }
            }
            return last;
        }

        @Override
        public Integer next() {
            int val = cur.val;
            cur = cur.next;
            return val;
        }

        @Override
        public boolean hasNext() {
           return cur != null;
        }
    }
}

interface NestedInteger {

    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}
