package datastructure.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

    public static void main(String[] args) {
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node root = createHuffmanTree(arr);
        preOrder(root);

    }
    public static void preOrder(Node root)
    {
        if(root!=null)
        {
            root.preOrder();
        }else{
            System.out.println("空树");
        }
    }

    public static Node createHuffmanTree(int[] arrs)
    {

        List<Node> nodes=new ArrayList<>();
        //将数组遍历，转化为一个链表
        for(int arr:arrs)
        {
          Node node=new Node(arr);
          nodes.add(node);
        }

        while(nodes.size()>1) {
            //对数组元素进行排序
            Collections.sort(nodes);
            //取出最小的两个元素，组合成新的结点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node node = new Node(leftNode.getValue() + rightNode.getValue());
            node.setLeft(leftNode);
            node.setRight(rightNode);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(node);
        }
        return nodes.get(0);//返回根节点
    }


}


//
class Node implements Comparable<Node>
{
    private int value;
    private char c;
    private Node left;
    private Node right;

    //写一个前序遍历
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

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
       //从小到大排序
        return this.value-o.value;
    }
}