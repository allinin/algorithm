package 韩顺平算法与数据结构.datastructure;

import java.util.Hashtable;
import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab=new HashTab(7);
        //写一个简单的菜单
        String key="";
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("add: 添加雇员信息");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出系统");
            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id=scanner.nextInt();
                    System.out.println("请输入名字");
                    String name=scanner.next();
                    //创建雇员
                    Emp emp=new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case"list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id=scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case"exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;

            }
        }
    }


}
class HashTab{

    private EmpLinkList[] empLinkListArray;
    private int size;//表示有多少条链表

     public HashTab(int size)
     {
         this.size=size;
         empLinkListArray=new EmpLinkList[size];
         for(int i=0;i<size;i++)
         {
             empLinkListArray[i]=new EmpLinkList();
         }
     }

     //添加雇员
    public void add(Emp emp)
    {
        int empLinkedListNo=hashFun(emp.id);
        empLinkListArray[empLinkedListNo].add(emp);
    }

    //遍历所有的链表，遍历hashtab
    public void list()
    {
        for(int i=0;i<size;i++)
            empLinkListArray[i].list(i);
    }
    //根据输入的id，查找雇员
    public void findEmpById(int id){
         int empLinkedListNo=hashFun(id);
         Emp emp=empLinkListArray[empLinkedListNo].findEmpById(id);
         if(emp!=null) {//找到
             System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (empLinkedListNo + 1), id);
         }else{
             System.out.println("在哈希表中，没有找到该雇员~");
         }
    }
    //编写散列函数
    public int hashFun(int id){
         return id%size;
    }

}
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkList{

    //头指针,指向第一个Emp,因此我们这个链表的head是直接指向第一个emp
    private Emp head;

    //添加,不带头结点，即链表的第一个头结点就存放雇员信息
    public void add(Emp emp){

        if(head==null){
            head=emp;
            return;
        }
        //如果不是第一个雇员，就使用辅助接点，插入到指定位置
        Emp curEmp=head;
        boolean flag=false;//标志位，判断插入点是否已经存在

        while(true){
            if(curEmp.next==null){
                break;

            }
            if(curEmp.next.id>emp.id){
                break;
            }
            if(curEmp.id==emp.id)
            {
                flag=true;
                break;
            }
            curEmp=curEmp.next;
        }
        //插入点不存在
        if(!flag){
            emp.next=curEmp.next;
            curEmp.next=emp;
        }else{
            System.out.println("插入结点已经存在！！！");
        }
    }

    //遍历雇员信息
    public void list(int no){
        if(head==null){
            System.out.println("第 "+(no+1)+"链表为空");
            return;
        }
        System.out.print("第 "+(no+1)+" 链表的信息为");
        Emp curEmp = head; //辅助指针
        while(true)
        {
            System.out.printf("=>id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id){
        if(head==null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp=head;
        while(true){
            if(curEmp.id==id)
            {
                break;
            }
            if(curEmp.next==null){
                curEmp=null;
                break;
            }
            curEmp=curEmp.next;
        }
        return curEmp;
    }

}