package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.*;

/**
 * @Author: ZBL
 * @Date: 2024-01-04  10:36
 * 堆盘子。
 * 设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 * <p>
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
 * [[1], [1], [2], [1], [], []]
 * 输出：
 * [null, null, null, 2, 1, -1]
 * 示例2:
 * <p>
 * 输入：
 * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
 * [[2], [1], [2], [3], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, 3]
 */
public class Face0303 {

    class StackOfPlates {

        int cap;
        List<Stack<Integer>> stacks;

        //TODO 实现延迟删除空队列，当空队列不是在list末尾时，删除时间复杂度0(n)
        TreeSet<Integer> set = new TreeSet<>();

        public StackOfPlates(int cap) {
            this.stacks = new ArrayList<>();
            this.cap = cap;
        }

        public void push(int val) {
            if(cap <= 0) {
                return ;
            }
            int size = stacks.size();
            Stack stack = size == 0 ? new Stack<Integer>() : stacks.get(size - 1);
            //当前栈已满
            if (stack.size() == cap) {
                Stack newStack = new Stack<Integer>();
                newStack.push(val);
                stacks.add(newStack);
            } else {
                stack.push(val);
                if(size > 0) {
                    stacks.set(size - 1,stack);
                } else {
                    stacks.add(stack);
                }

            }
        }

        public int pop() {
            int idx = stacks.size() - 1;
            while (idx >= 0) {
                Stack<Integer> stack = stacks.get(idx);
                if (stack.isEmpty()) {
                    //为空的时候删除
                    stacks.remove(idx);
                    idx--;
                } else {
                    int val = stack.pop();
                    if (stack.isEmpty()) {
                        stacks.remove(idx);
                    }
                    return val;
                }

            }
            return -1;
        }

        public int popAt(int index) {
            if(index >= stacks.size()) {
                return -1;
            }
            Stack<Integer> stack = stacks.get(index);
            if(stack.isEmpty()) {
                return -1;
            }
            int val = stack.pop();
            if(stack.isEmpty()) {
                stacks.remove(index);
            }
            return val;
        }
    }
}
