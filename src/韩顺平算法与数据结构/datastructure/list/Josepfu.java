package 韩顺平算法与数据结构.datastructure.list;

public class Josepfu {
    public static void main(String[] args) {
        // 测试一把看看构建环形链表，和遍历是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);// 加入5个小孩节点
        circleSingleLinkedList.showBoy();

        //测试一把小孩出圈是否正确
        circleSingleLinkedList.countBoy(1, 2, 5); // 2->4->1->5->3
        //String str = "7*2*2-5+1-5+3-3";
    }
}

class CircleSingleLinkedList{
    private Boy first=null;
    //添加小孩结点，创建环形链表
    public void addBoy(int nums)
    {
        //数据校验
        if(nums<1)
        {
            System.out.println("nums的值不正确！");
            return;
        }
        Boy cur=null;//辅助指针，构建环形链表

       for(int i=1;i<=nums;i++)
       {
           //根据编号，创建结点
           Boy boy=new Boy(i);
           if(i==1)
           {
               first=boy;
               first.setNext(first);
               cur=first;
           }else{
               cur.setNext(boy);
               boy.setNext(first);
               cur=boy;
           }
       }
    }

    //遍历当前的环形链表
    public void showBoy()
    {
        if(first==null)
        {
            System.out.println("链表为空");
            return;
        }
        Boy cur=first;
        while(true)
        {
            System.out.println("小孩的编号为："+cur.getNo());
            if(cur.getNext()==first)
            {
                break;
            }
            cur=cur.getNext();
        }
    }

    //根据用户输入，计算出小孩的出圈顺序
   public void countBoy(int startNo,int countNums,int nums)
   {
       if(first==null || startNo<=0 || startNo>nums)
       {
           System.out.println("参数输入不正确！！");
           return;
       }
       Boy helper =first;//辅助指针，帮助完成小孩的出圈
       //辅助指针指向最后一个结点
       while (true)
       {
           if(helper.getNext()==first)
           {
               break;
           }
           helper=helper.getNext();
       }
       while(true) {
           //小孩在报数前先移动startNo-1次
           if(first==helper)
           {  //说明只有一个小孩还在
               break;
           }
           for (int i = 1; i <= startNo - 1; i++) {
               first = first.getNext();
               helper = helper.getNext();
           }
           //从开始报数小孩开始，移动countNums次，
           for (int j = 1; j <= countNums - 1; j++) {
               first = first.getNext();
               helper = helper.getNext();
           }
           System.out.println("出圈小孩编号为：" + first.getNo());
           first = first.getNext();
           helper.setNext(first);
       }
       System.out.println("最后留下的小孩是："+first.getNo());


   }

}
class Boy{
    private int no;
    private Boy next;

   public Boy(int no)
   {
       this.no=no;
   }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}