package ZUOSHEN.第三课;

public class Array_to_Stack_Queue {

    public static class ArrayStack{
        private Integer[] arr;
        private Integer size; //记录了数组中将要添加的元素的位置

        public ArrayStack(int initSize)
        {
            if(initSize<0)
                throw new IllegalArgumentException("This init size is less than 0");
            arr= new Integer[initSize];
            size=0;
        }

        public Integer peek()
        {
            if(size==0)
                return null;
            return arr[size-1];
        }

        public void push(int obj)
        {
            if(size==arr.length)
                throw new ArrayIndexOutOfBoundsException("The stack is full");
            arr[size]=obj;
            size++;
        }
        public Integer pop()
        {
            if(size==0)
                throw new ArrayIndexOutOfBoundsException("The stack is empty");
            return arr[size--];
        }

    }

    //用数组构建循环队列
    public static class ArrayQueue{

        private Integer[] arr;
        private int size; //队列中实际元素的个数，利用size来解耦了。
        private int first;//指向对列头部，第一个元素的位置
        private int last;//指向对列尾部,新插入元素的位置

        public ArrayQueue(int init)
        {
            if(init<0)
                throw new IllegalArgumentException("The init size is less than 0");
            arr=new Integer[init];
            size=0;
            first=0;
            last=0;
        }

        public Integer peek()
        {
            if(size==0)
                return null;
            return arr[first];
        }
        public void push(int obj)
        {
            if(size==arr.length)
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            size++;
            arr[last]=obj;
            last=last==arr.length-1?0:last+1;
        }

        public Integer pop(){
            if(size==0)
                throw  new ArrayIndexOutOfBoundsException("The queue is empty");
            size--;
            int temp=first;
            first=first==arr.length-1?0:first+1;
            return arr[temp];
        }
    }
}
