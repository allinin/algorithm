package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-04  10:28
 * 三合一。描述如何只用一个数组来实现三个栈。
 *
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 *
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * 示例1:
 *
 *  输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 *
 *  输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, -1, -1]
 *
 *
 * 提示：
 *
 * 0 <= stackNum <= 2
 */
public class Face0301 {
    class TripleInOne {

        int[] arr;
        int[] idx;
        int stackSize;

        public TripleInOne(int stackSize) {
            this.arr = new int[stackSize * 3];
            this.idx = new int[]{-1,-1,-1};
            this.stackSize = stackSize;
        }

        public void push(int stackNum, int value) {
            if(idx[stackNum] == stackSize - 1) {
                return;
            }
            arr[stackNum * stackSize + (++idx[stackNum])] = value;
        }

        public int pop(int stackNum) {
            if(idx[stackNum] == -1) {
                return -1;
            }
            return  arr[stackNum * stackSize + idx[stackNum]--];
        }

        public int peek(int stackNum) {
            if(idx[stackNum] == -1) {
                return -1;
            }
            return  arr[stackNum * stackSize + idx[stackNum]];
        }

        public boolean isEmpty(int stackNum) {
            return idx[stackNum] == -1;
        }
    }
}
