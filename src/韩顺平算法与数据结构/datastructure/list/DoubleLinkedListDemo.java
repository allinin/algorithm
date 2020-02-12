package 韩顺平算法与数据结构.datastructure.list;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        HeroNode2 hero5 = new HeroNode2(5, "林冲", "豹子头");

        // 创建一个双向链表
        SingleLinkedList2 doubleLinkedList = new SingleLinkedList2();
        doubleLinkedList.addByOrder(hero5);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero5);


        doubleLinkedList.list();
//
//        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
//        doubleLinkedList.updata(newHeroNode);
//        System.out.println("修改后的链表情况");
//        doubleLinkedList.list();
//        // 删除
//        doubleLinkedList.delete(3);
//        System.out.println("删除后的链表情况~~");
//        doubleLinkedList.list();
    }
}


class SingleLinkedList2 {
    //先初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, " ", " ");

    //获取头结点
    public HeroNode2 getHead() {
        return head;
    }

    //依次添加新的结点

    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                temp = temp.next;
            }
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //插入指定位置,找到插入结点的后一个结点
    public void addByOrder(HeroNode2 heroNode) {

        HeroNode2 temp = head;
        boolean flag = false;//flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) //找到插入的位置，
            {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("准备插入的结点已经存在");

        } else {
            if(temp.next!=null)
            {
               temp.next.pre=heroNode;
               heroNode.next=temp.next;
               temp.next=heroNode;
               heroNode.pre=temp;
            }else
            {
                temp.next=heroNode;
                heroNode.pre=temp;
            }
        }
    }

    //根据no来修改结点，即，结点的no值不能修改
    public void updata(HeroNode2 heroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//用来判断是否找到了要修改的结点
        while (true) {
            if (temp == null)//说明要修改的结点不存在
            {
                break;
            }
            if (temp.no == heroNode.no)//已经找到了
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.println("没有找到要修改的结点！！！");
        }
    }

    //根据指定的no值，删除指定的结点,并且需要找到要删除的结点的前一个结点
    public void delete(int no) {
        HeroNode2 temp = head.next;
        boolean flag = false;//标志着我们是否找到要删除的结点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;

        }
        //判断flag
        if (flag) {
            temp.pre.next=temp.next;
            if(temp.next!=null)
            temp.next.pre=temp.pre;
        } else {
            System.out.println("要删除的结点不存在");
        }
    }

    //显示链表的内容，遍历
    public void list() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true) {
            System.out.println(temp);
            temp = temp.next;
            if (temp == null) {
                break;
            }
        }
    }
}

    class HeroNode2 {
        public int no;
        public String name;
        public String nickName;
        public HeroNode2 next;
        public HeroNode2 pre;

        public HeroNode2(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        public String toString() {
            return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
        }
    }

