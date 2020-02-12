package 韩顺平算法与数据结构.datastructure.list;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5= new HeroNode(6, "林冲111", "豹子111");
        HeroNode hero6= new HeroNode(7, "林冲54", "豹子55");
        HeroNode hero7= new HeroNode(5, "林冲23", "豹子67");
        //创建要给链表
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        SingleLinkedList singleLinkedList2= new SingleLinkedList();

        //加入
        singleLinkedList1.addByOrder(hero1);
        singleLinkedList1.addByOrder(hero4);
        singleLinkedList1.addByOrder(hero3);
        singleLinkedList1.addByOrder(hero5);
        singleLinkedList2.addByOrder(hero2);
        singleLinkedList2.addByOrder(hero7);
        singleLinkedList2.addByOrder(hero6);
        //singleLinkedList.updata(hero5);
       // singleLinkedList.delete(4);
        HeroNode heroNode1=singleLinkedList1.getHead();
        HeroNode heroNode2=singleLinkedList2.getHead();
        HeroNode heroNode = mergeList(heroNode1, heroNode2);
        singleLinkedList1.list();
        System.out.println("======================");
        singleLinkedList2.list();
//        singleLinkedList1.list();
//        reversePrint(heroNode1);
//        System.out.println(findLastIndexNode(singleLinkedList.getHead(),2));
//
//        reverseList(heroNode);
//        singleLinkedList.list();
   }

    //获取单链表的结点的个数，不加头结点
    public static int getLength(HeroNode head)
    {
        if(head.next==null)
        {
            return 0;
        }
        int count=0;
        HeroNode temp=head.next;
        while(temp!=null)
        { count++;
        temp=temp.next;

        }
        return count;
    }

    //查找单链表的倒数第k个结点
    public static HeroNode findLastIndexNode(HeroNode head,int index)
    {
        //检查是否为空
        if(head.next==null)
        {
            System.out.println("链表为空");
            return null;
        }
        //第一遍遍历，得到链表的有效长度
        int size=getLength(head);
        //判断选取的结点是否合理
        if(index<=0 || index>size)
        {
            return null;
        }
        HeroNode temp=head.next;
        for(int i=0;i<size-index;i++)
        {
            temp=temp.next;
        }
        return temp;
    }
       //单链表的翻转
    public static  void reverseList(HeroNode head){
        if(head.next==null || head.next.next==null)
        {
            return;
        }

        //辅助接点，一个替代head，来遍历，另一个记住当前遍历的位置的下一各节点
        HeroNode cur=head.next;
        HeroNode next=null;
        //定义一个新的头结点
        HeroNode reverseNode=new HeroNode(0," "," ");
        while(cur!=null)
        {
            next=cur.next;//记住下一个位置
            cur.next=reverseNode.next;
            reverseNode.next=cur;
            cur=next;//后移一个位置

        }
         head.next=reverseNode.next;
    }

    //从头到尾打印单链表(利用栈）
    public static void reversePrint(HeroNode head)
    {
        if(head.next==null)
        {
            return;
        }
        HeroNode temp=head.next;
        Stack<HeroNode> stack=new Stack<>();
        while(temp!=null)
        {
            stack.push(temp);
            temp=temp.next;
        }
        while(stack.size()>0)
        {
            System.out.println(stack.pop());
        }
    }

    //合并两个有序链表，合并之后仍然要有序
    public static HeroNode  mergeList(HeroNode head1,HeroNode head2)
    {
        HeroNode cur1=head1.next;
        HeroNode cur2=head2.next;
        HeroNode result=new HeroNode(0," "," ");//合并产生的新的链表头结点
        HeroNode tail=null;//新链表的尾结点，便于直接插入
        HeroNode temp;//记住当前遍历的位置
        while(cur1==null || cur2==null)
        {
            if(cur1.no<=cur2.no)
            {
                if(result.next!=null)
                {   temp=cur1.next;
                    //插入过程
                    tail.next=cur1;
                    cur1.next=null;
                    //保存新的最后的结点
                    tail=cur1;
                    cur1=temp;
                }else {
                    temp = cur1.next;
                    result.next = cur1;
                    cur1.next = null;
                    tail = cur1;
                    cur1 = temp;
                }

            }else{
                if(result.next!=null)
                {
                    temp=cur2.next;
                    tail.next=cur2;
                    cur2.next=null;
                    tail=cur2;
                    cur2=temp;
                }else{
                    temp=cur2.next;
                    result.next=cur2;
                    cur2.next=null;
                    tail=cur2;
                    cur2=temp;

                }
            }
        }
        if(cur1==null)
        {
            tail.next=cur2;
        }
        if(cur2==null)
        {
            tail.next=cur1;
        }
     return result;
    }
       //递归方式实现：head1,head2为链表的第一个有效结点
    public static HeroNode merge(HeroNode head1,HeroNode head2)
    {

        if(head1==null)
        {
            return head2;
        }
        if(head2==null)
        {
            return head1;
        }
        HeroNode result=null;
        if(head1.no<head2.no)
        {
            result=head1;
            result.next=merge(head1.next,head2);
        }else{
            result=head2;
            result.next=merge(head1,head2.next);
        }
        return result;
    }



}

class SingleLinkedList{
    //先初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode head=new HeroNode(0, " "," ");

    //获取头结点
    public HeroNode getHead()
    {
        return head;
    }

    //依次添加新的结点

    public void add(HeroNode heroNode)
    {
        HeroNode temp=head;
        while(true)
        {
            if(temp.next==null)
            {
                break;
            }else{
                temp=temp.next;
            }
        }
        temp.next=heroNode;
    }

    //插入指定位置,找到插入结点的后一个结点
    public void addByOrder(HeroNode heroNode)
    {

        HeroNode temp=head;
        boolean flag=false;//flag标志添加的编号是否存在，默认为false
        while(true)
        {
            if(temp.next==null)
            {
                break;
            }
            if(temp.next.no>heroNode.no) //找到插入的位置，
            {
                break;
            }else if(temp.next.no==heroNode.no)
            {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag)
        {
            System.out.println("准备插入的结点已经存在");

        }else {
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }

    //根据no来修改结点，即，结点的no值不能修改
    public void updata(HeroNode heroNode)
    {
        //判断是否为空
        if(head.next==null)
        {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head.next;
        boolean flag=false;//用来判断是否找到了要修改的结点
        while(true)
        {
            if(temp==null)//说明要修改的结点不存在
            {
                break;
            }if(temp.no==heroNode.no)//已经找到了
            {
              flag=true;
              break;
            }
            temp=temp.next;
        }
        if(flag)
        {
            temp.name=heroNode.name;
            temp.nickName=heroNode.nickName;
        }else{
            System.out.println("没有找到要修改的结点！！！");
        }
    }

    //根据指定的no值，删除指定的结点,并且需要找到要删除的结点的前一个结点
    public void delete(int no){
        HeroNode temp=head;
        boolean flag=false;//标志着我们是否找到要删除的结点
        while(true)
        {
            if(temp.next==null)
            {break;}
            if(temp.next.no==no)
            {
                flag=true;
                break;
            }
            temp=temp.next;

        }
        //判断flag
        if(flag)
        {
            temp.next=temp.next.next;
        }else {
            System.out.println("要删除的结点不存在");
        }
    }

    //显示链表的内容，遍历
    public  void list()
    {
        //先判断链表是否为空
        if(head.next==null)
        {
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp=head.next;
        while(true)
        {
            System.out.println(temp);
            temp=temp.next;
            if(temp==null)
            {
                break;
            }
        }
    }



}
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no,String name,String nickName)
    {
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }

    public String toString()
    {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
    }
}