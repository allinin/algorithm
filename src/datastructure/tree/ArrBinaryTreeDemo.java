package datastructure.tree;

import javax.sound.midi.SoundbankResource;

public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree=new ArrBinaryTree(arr);
        //arrBinaryTree.preOrder();
        arrBinaryTree.postOrder();
        System.out.println("-================-=-=-=-=-==-=-=-==-");
        arrBinaryTree.midOrder();
    }

}

class ArrBinaryTree{
    //存储数据结点的数组
    private int[] arr;
    public ArrBinaryTree(int[] arr)
    {
        this.arr=arr;
    }


    //重载preOrder
    public void preOrder()
    {
        this.preOrder(0);
    }
     //重载midOrder
    public void midOrder()
    {
        this.midOrder(0);
    }

     //重载postOrder
    public void postOrder()
    {
        this.postOrder(0);
    }
    //实现顺序存储二叉树的前序遍历
    public void preOrder(int index) {

        if (arr == null || arr.length == 0)
        {
            System.out.println("数组为空，不能遍历");
        }
        //输出当前元素
        System.out.print(arr[index]);
        if(index*2+1<arr.length)
        {
            preOrder(2*index+1);
        }

        if(index*2+2<arr.length)
        {
            preOrder(index*2+2);
        }
    }

    //顺序存储的中序遍历
    public void midOrder(int index)
    {
        if(arr==null || arr.length==0)
        {
            System.out.println("数组为空不能进行遍历");
        }

        if(index*2+1<arr.length)
        {
            midOrder(index*2+1);
        }

        System.out.println(arr[index]);

        if(index*2+2<arr.length)
        {
            midOrder(index*2+2);
        }
    }

    //后序
    public void postOrder(int index)
    {
        if(arr==null || arr.length==0)
        {
            System.out.println("遍历失败");
        }

        if(index*2+1<arr.length)
        {
            postOrder(index*2+1);
        }
        if(index*2+2<arr.length)
        {
            postOrder(index*2+2);
        }
        System.out.println(arr[index]);
    }
}
