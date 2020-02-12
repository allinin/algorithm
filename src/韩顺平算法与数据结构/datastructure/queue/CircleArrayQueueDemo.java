package 韩顺平算法与数据结构.datastructure.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例：");
        CircleArray circleArray=new CircleArray(4);
        char key=' ';//接受用户的输入
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        while(loop)
        {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key=scanner.next().charAt(0);//接受一个字符
            switch (key){
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value=scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArray.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
                }
            }
        System.out.println("程序退出");
        }
    }

class CircleArray{
    private int maxsize;
    private int front;
    private int rear;
    private int[] arr;
    public CircleArray(int maxsize)
    {
        this.maxsize=maxsize;
        arr=new int[maxsize];
    }
    //判断是否已经满了
    public boolean isFull()
    {
        return (rear+1)%maxsize==front;
    }
    //判断是否为空
    public boolean isEmpty()
    {
        return rear==front;
    }

    //添加数据
    public void addQueue(int n)
    {
        if(isFull())
        {
            System.out.println("队列满");
            return;
        }
        //直接将数据插入
        arr[rear]=n;
        //将rear后移
        rear=(rear+1)% maxsize;
    }
    //获取数据出队列
    public int getQueue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("队列空，不能取数据");
        }
        int value=arr[front];
        front=(front+1)%maxsize;
        return value;
    }

    //展示所有数据
    public void showQueue()
    {
        if(isEmpty())
        {
            System.out.println("队列空");
            return;
        }
        for(int i=front;i<front+size();i++)
        {
            System.out.printf("arr[%d]=%d\n",i%maxsize,arr[i % maxsize]);
        }
    }

    public int size()
    {
        return (rear+maxsize-front)%maxsize;
    }

    //显示队列的头数句
    public int headQueue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("队列空");
        }
        return arr[front];
    }
}
