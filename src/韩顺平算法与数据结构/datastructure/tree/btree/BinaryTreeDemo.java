package 韩顺平算法与数据结构.datastructure.tree.btree;

public class BinaryTreeDemo {
    public static void main(String[] args) {

        BinaryTree binaryTree=new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);


       // binaryTree.setRoot(root);

//        binaryTree.preOrder();
//        binaryTree.midOrder();
        //binaryTree.postOrder();

        System.out.println(root.postOrderSearch(2));
    }
}

class BinaryTree{

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder()
    {
        root.preOrder();
    }

    //中序遍历
    public void midOrder()
    {
        root.midOrder();
    }

    //后序遍历
    public void postOrder()
    {
        root.postOrder();
    }
    public HeroNode preOrderSearch(int no) {
        if(root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }
    //中序遍历
    public HeroNode midOrderSearch(int no) {
        if(root != null) {
            return root.midOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序遍历
    public HeroNode postOrderSearch(int no) {
        if(root != null) {
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }

    public void delNode(int no)
    {
        if(root!=null)
        {
          if(root.getId()==no)
          root=null;
        }else{
            root.delNode(no);
        }
    }

}

class HeroNode{

    private int id;
    private String name;
    private HeroNode right;
    private HeroNode left;

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null)
        {
            this.left.preOrder();
        }
        if(this.right!=null)
        {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void midOrder()
    {
        if(this.left!=null)
        {
            this.left.midOrder();
        }
        //输出父结点
        System.out.println(this);

        if(this.right!=null)
            this.right.midOrder();
    }

    //后序遍历
    public void postOrder()
    {
        if(this.left!=null)
            this.left.postOrder();
        if(this.right!=null)
            this.right.postOrder();
        System.out.println(this);

    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no)
    {
        System.out.println("进入前序遍历");
        if(this.id==no)
        {
            return this;
        }
        //判断当前节点的左子树是否为空，如果不为空，则递归查找
        HeroNode resNode=null;
        if(this.left!=null)
        {
            resNode=this.left.preOrderSearch(no);
        }
        if(resNode!=null)
        {
            return resNode;
        }

        if(this.right!=null)
        {
            resNode=this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode midOrderSearch(int no)
    {
      HeroNode resNode=null;
        if(this.left!=null)
        {
           resNode= this.left.midOrderSearch(no);
        }
        if(resNode!=null)
        {
            return resNode;
        }
        if(this.id==no)
        {
            return this;
        }
        if(this.right!=null)
        {
            resNode=this.right.midOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no)
    {
        //定义一个结点用来接收返回值
        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.postOrderSearch(no);
        }
        if(resNode!=null)
        {
            return resNode;
        }
        if(this.right!=null)
        {
            resNode=this.right.postOrderSearch(no);
        }
        if(resNode!=null)
        {
            return resNode;
        }
        if(this.id==no)
        {
            return this;
        }
            return resNode;
    }

    public void delNode(int no)
    {
        if(this.left!=null && this.left.id==no)
        {
            this.left=null;
            return;
        }
        if(this.right!=null && this.right.id==no)
        {
            this.right=null;
            return;
        }
        //递归遍历左子树
        if(this.left!=null)
        {
            this.left.delNode(no);
        }
        if(this.right!=null)
        {
            this.right.delNode(no);
        }
    }



}