package 左神算法.基础班.第三课;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {

    public static class TwoStackQueue{
        private Stack<Integer>stackPush;
        private Stack<Integer>stackPop;

        public TwoStackQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
            this.stackPush = stackPush;
            this.stackPop = stackPop;
        }

        public void push(int nums)
        {
            stackPush.push(nums);
        }
        public int pop()
        {
            if(stackPush.isEmpty() && stackPop.isEmpty())
                throw new RuntimeException("queue is empty");
            else if(stackPop.isEmpty())
            {
                while(!stackPop.isEmpty())
                stackPop.push(stackPush.pop());
            }
            return stackPop.pop();
        }
        public int peek()
        {
            if(stackPush.isEmpty() && stackPop.isEmpty())
                throw new RuntimeException("queue is empty");
            else if(stackPop.isEmpty())
            {
                while(!stackPop.isEmpty())
                    stackPop.push(stackPush.pop());
            }
            return stackPop.peek();
        }


    }

    public static class twoQueueStack{

        private Queue<Integer>queue;
        private Queue<Integer>help;
        public twoQueueStack(){
            this.help=new LinkedList<>();
            this.queue=new LinkedList<>();
        }

        public void push(Integer nums)
        {
            queue.add(nums);
        }

        public int peek()
        {
            if(queue.isEmpty())
                throw new RuntimeException("stack is empty");
            while(queue.size()!=1)
            {
                help.add(queue.poll());
            }
            int res=queue.peek();
            help.add(res);
            swap(queue,help);
            return res;
        }


        public void swap(Queue queue,Queue help)
        {
            Queue temp=queue;
            queue=help;
            help=temp;
        }

        public int poll()
        {
            if(queue.isEmpty())
                throw new RuntimeException("stack is empty");
            while(queue.size()!=1)
            {
                help.add(queue.poll());
            }
            int res=queue.poll();
            swap(queue,help);
            return res;
        }


    }
}
