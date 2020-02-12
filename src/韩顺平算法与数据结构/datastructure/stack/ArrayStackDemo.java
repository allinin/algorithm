package 韩顺平算法与数据结构.datastructure.stack;

import javax.sound.midi.SoundbankResource;

public class ArrayStackDemo {
}
class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top=-1;

    public ArrayStack(int maxSize)
    {
        this.maxSize=maxSize;
        stack=new int[maxSize];
    }
    //栈满
    public boolean isFull()
    {
        return top==maxSize-1;
    }
    //栈空
    public boolean isEmpty()
    {
        return top==-1;
    }
    //入栈
    public void push(int value)
    {
        if(isFull())
        {
            System.out.println("栈满");
            return;
        }else{
            top++;
            stack[top]=value;
        }
    }
    //出栈
    public int pop()
    {
        if(isEmpty())
        {
          throw new  RuntimeException("栈空，没有数据");
        }
        int value=stack[top];
        top--;
        return value;
    }

    //遍历显示栈
    public void list()
    {
        if(isEmpty())
        {
            System.out.println("栈空");
            return;
        }
        //需要从栈顶显示数据
        for(int i=top;i>=0;i--)
        {
            System.out.println(stack[i]);
        }
    }
}
