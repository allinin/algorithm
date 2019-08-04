package datastructure.stack;

public class Calculator {
    public static void main(String[] args) {
       String s="7*2*2-500+120-5+3-4";
       Calculator calculator=new Calculator();
        int i = calculator.resultCal(s);
        System.out.println(i);
    }

    public int resultCal(String s){
        ArrayStack2 numStack=new ArrayStack2(10);
        ArrayStack2 operStack=new ArrayStack2(10);
        //定义相关变量
        int index=0;
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        char ch= ' ';//将每次扫描得到的char保存到ch
        String keepNum="";//用于拼接多位数
        while (true)
        {
            ch=s.substring(index,index+1).charAt(0);
            if(operStack.isOper(ch))
            {
                if(operStack.isEmpty())
                {
                    operStack.push(ch);
                }else {
                    if(operStack.priority(ch)<=operStack.priority(operStack.peek()))
                    {
                       oper = operStack.pop();
                       num1=numStack.pop();
                       num2=numStack.pop();
                       res=numStack.cal(num1,num2,oper);
                       numStack.push(res);
                       operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }
            }else{
                keepNum+=ch;
                if(index==s.length()-1)
                {
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    if(operStack.isOper(s.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum="";
                    }
                }

            }
            index++;
            if(index>=s.length())
                break;
        }
        while(true)
        {
           if(operStack.isEmpty())
               break;
           num1=numStack.pop();
           num2=numStack.pop();
           oper=operStack.pop();
           res=numStack.cal(num1,num2,oper);
           numStack.push(res);
        }
        res=numStack.pop();
        return res;


    }
}


class ArrayStack2{
    private int maxSize;
    private int[] stack;
    private int top=-1;

    public ArrayStack2(int maxSize)
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

    //查看栈顶的元素,不是真的弹出栈
    public int peek()
    {
        return stack[top];
    }

    //返回运算符的优先级，优先级的高低是由程序员自己来定义的。优先级使用数字表示
    //数字越大，优先级越高
    public int priority(int oper)
    {
        if(oper=='*' || oper =='/')
            return 1;
        else if(oper=='+' || oper =='-')
            return 0;
        else
            return -1;
    }

    //判断是否是一个运算符
    public boolean isOper(char val)
    {
       return val=='*' || val=='/' || val=='+'|| val=='-';

    }

    //计算方法
    public int cal (int num1,int num2,int oper)
    {
        int res=0;
        switch(oper){
            case'+':
                res=num2+num1;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num2*num1;
                break;
            case '/':
                res=num2/num1;
                break;
            default:
                break;
        }
        return res;
    }

}