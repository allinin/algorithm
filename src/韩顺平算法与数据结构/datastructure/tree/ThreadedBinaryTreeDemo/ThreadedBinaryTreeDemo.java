package 韩顺平算法与数据结构.datastructure.tree.ThreadedBinaryTreeDemo;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.postThreaded(root);
        //测试: 以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 ="  + leftNode); //3
        System.out.println("10号结点的后继结点是="  + rightNode); //1

        System.out.println("使用线索化的方式遍历 线索化二叉树");
       // threadedBinaryTree.postOrderThreadedTree(); // 8, 3, 10, 1, 14, 6
    }
}

//创建树
class ThreadedBinaryTree{

    private HeroNode root;

    //为了实现线索化，需要创建一个总是指向当前节点前驱结点的指针
    private HeroNode pre=null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes()
    {
        this.threadedNodes(root);
    }

   //对二叉树进行后序线索化
    public void postThreaded(HeroNode node)
    {
        if(node==null)
        {
            return;
        }

        postThreaded(node.getLeft());

        postThreaded(node.getRight());

        if(node.getLeft()==null)
        {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if(pre!=null && pre.getRight()==null)
        {
            pre.setRight(node);
            pre.setRigthType(1);
        }
        pre=node;
    }


    //编写对二叉树进行中序线索化的方法
    public void threadedNodes(HeroNode node)
    {
        if(node==null)
        {
            return;
        }
        //先线索化左子树
        threadedNodes(node.getLeft());

        //线索化当前节点的前驱结点，即：如果当前节点的左结点为空，则指向前驱结点
        if(node.getLeft()==null)
        {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //前一个结点的后继结点指向当前节点，
        if(pre!=null && pre.getRight()==null)
        {
            //让前驱结点的右指针指向当前节点
           pre.setRight(node);
           pre.setRigthType(1);
        }
         pre=node;//没处理一个结点后，让当前节点是下一个节点的前驱结点
        //最后线索化右子树
        threadedNodes(node.getRight());
    }

    //编写对二叉树进行前序线索化二叉树的方法
    public void preThreaded(HeroNode node)
    {
        if(node==null)
        {
            return;
        }
        //处理当前节点的前驱结点
        if(node.getLeft()==null)
        {
            node.setLeft(pre);
            node.setLeftType(1);
        }
       // System.out.println(node);
        //处理后继结点，如果
        if(pre!=null && pre.getRight()==null)
        {
            pre.setRight(node);
            pre.setRigthType(1);
        }
        pre=node;
        //处理左子树
        if(node.getLeftType()==0)
        {
            preThreaded(node.getLeft());
        }

         //处理右子树
        if(node.getRigthType()==0)
        {
            preThreaded(node.getRight());
        }

    }

    //中序遍历线索化二叉树
    public void midThreadedOrder()
    {
        HeroNode node=root;
        while(node!=null)
        {
            while(node.getLeftType()==0)
                node=node.getLeft();
            System.out.println(node);
            //如果当前节点的右指针指向的是后继结点，则就一直输出
            while (node.getRigthType()==1)
            {
                node=node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的结点
            node=node.getRight();
        }
    }

    //前序遍历线索化二叉树
    public void preOrderThreadedTree()
    {
        HeroNode node=root;
        while(node!=null)
        {
            System.out.println(node);
            while(node.getLeftType()==0)
            {
                node=node.getLeft();
                System.out.println(node);
            }
           while(node.getRigthType()==1)
           {
               node=node.getRight();
               System.out.println(node);
           }
            node=node.getRight();

        }
    }
    //后序遍历线索化二叉树
    public void postOrderThreadedTree()
    {
        HeroNode node=root;
        //找到后序遍历开始的结点
        while(node !=null && node.getLeftType()==0)
        {
            node=node.getLeft();
        }
        //
        while(node!=null)
        {
            if(node.getRigthType()==1)
            {
                System.out.println(node);
                pre=node;
                node=node.getRight();
            }else{
                if(node.getRight()==pre)
                {
                    System.out.println(node);
                    if(node==root)
                        break;
                     pre=node;

                }
            }
        }
    }

}


//创建结点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //标志位
    private int leftType; //0表示指向的是左子树，1表示指向的是前驱结点
    private int rigthType;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRigthType() {
        return rigthType;
    }

    public void setRigthType(int rigthType) {
        this.rigthType = rigthType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


}
