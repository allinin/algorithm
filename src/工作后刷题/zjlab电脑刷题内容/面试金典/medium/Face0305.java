package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.Stack;

/**
 * @Author: ZBL
 * @Date: 2024-01-04  13:36
 * <p>
 * 栈排序。
 * 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null,null,null,1,null,2]
 * 示例2:
 * <p>
 * 输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 * 输出：
 * [null,null,null,null,null,true]
 * 说明:
 * <p>
 * 栈中的元素数目在[0, 5000]范围内。
 */
public class Face0305 {

    class SortedStack {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public SortedStack() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void push(int val) {
            if (stack1.isEmpty()) {
                stack1.push(val);
            } else {
                while (!stack1.isEmpty() && stack1.peek() < val) {
                    stack2.push(stack1.pop());
                }
                stack1.push(val);
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }

        }

        public void pop() {
            if (!stack1.isEmpty()) {
                stack1.pop();
            }
        }

        public int peek() {
            if (stack1.isEmpty()) {
                return -1;
            }
            return stack1.peek();
        }

        public boolean isEmpty() {
            return stack1.isEmpty();
        }
    }

    //惰性的方式
    class SortedStack2 {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public SortedStack2() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void push(int val) {
            while (!stack1.isEmpty() && stack1.peek() < val) {
                stack2.push(stack1.pop());
            }
            while(!stack2.isEmpty() && stack2.peek() > val) {
                stack1.push(stack2.pop());
            }
            stack1.push(val);
        }

        public void pop() {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            if (!stack1.isEmpty()) {
                stack1.pop();
            }

        }

        public int peek() {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            if (stack1.isEmpty()) {
                return -1;
            }
            return stack1.peek();
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
