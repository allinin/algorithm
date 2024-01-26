package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

import java.util.Stack;

/**
 * @Author: ZBL
 * @Date: 2024-01-04  11:19
 *
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 *
 *
 * 示例：
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 说明：
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
public class Face0304 {
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;


        /** Initialize your data structure here. */
        public MyQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(!stack2.isEmpty()) {
                return stack2.pop();
            }

            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(!stack2.isEmpty()) {
                return stack2.peek();
            }

            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

    }

}
