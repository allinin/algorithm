package ZUOSHEN.基础班.第三课;

import java.util.Stack;

public class GetMinStack {


    //方式一
    public static class MyStack01{

        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack01()
        {
            this.stackData=new Stack<>();
            this.stackMin=new Stack<>();

        }
        public void push(int newNum)
        {
            if(this.stackMin.isEmpty())
                stackMin.push(newNum);
            else if(this.stackMin.peek()>=newNum)
                stackMin.push(newNum);
            stackData.push(newNum);
        }

        public Integer pop()
        {
            if(this.stackData.isEmpty())
                throw new RuntimeException("your stack is empty");
            int value=this.stackData.pop();
            if(value==this.getmin())
                stackMin.pop();
            return value;

        }
        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }




    }

    //方式二
    public static class MyStack02{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack02() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }
        public void push(int newNum)
        {
            if(this.stackMin.isEmpty())
                stackMin.push(newNum);
            else if(newNum<=stackMin.peek())
                stackMin.push(newNum);
            else
                stackMin.push(stackMin.peek());
            stackData.push(newNum);
        }

        public Integer pop(){
            if(this.stackData.isEmpty())
                throw new RuntimeException("Your stack is empty");
            this.stackMin.pop();
            return this.stackData.pop();
        }
    }
    public static void main(String[] args) {
        MyStack01 stack1 = new MyStack01();
        stack1.push(3);
        System.out.println(stack1.getmin());
        stack1.push(4);
        System.out.println(stack1.getmin());
        stack1.push(1);
        System.out.println(stack1.getmin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getmin());

        System.out.println("=============");

        MyStack01 stack2 = new MyStack01();
        stack2.push(3);
        System.out.println(stack2.getmin());
        stack2.push(4);
        System.out.println(stack2.getmin());
        stack2.push(1);
        System.out.println(stack2.getmin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getmin());
    }
}
