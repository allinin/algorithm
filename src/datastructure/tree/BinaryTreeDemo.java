package datastructure.tree;

import javax.sound.midi.SoundbankResource;
import java.util.Hashtable;

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


        binaryTree.setRoot(root);

//        binaryTree.preOrder();
//        binaryTree.midOrder();
        binaryTree.postOrder();
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
}