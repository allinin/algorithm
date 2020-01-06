package ZUOSHEN.进阶班.单调栈;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zbl
 * @version 1.0
 * @content: 一个数组的MaxTree定义如下，数组必须没有重复元素。MaxTree是一颗二叉树，数组的每一个值对应一个二叉树结点。包括MaxTree树在内且在其中的每一颗子树上
 * 值最大结点都是树的头。给定一个没有重复元素的数组arr,写出生成这个数组的MzxTree的函数，要求如果数组长度为N，则时间复杂度为O（N），额外空间复杂度为O(n)
 * @date 2019/12/31 11:25
 */
public class MaxTree {

    public static class Node{
        public int value;
        public Node right;
        public Node left;
        public Node(int value){
            this.value=value;
        }

    }


    //通过构建大根堆的方式实现
    public static Node getMaxTree1(int[] arr){

        if(arr==null || arr.length==0)
        {
            return null;
        }
        //将原数组构建成一个大根堆
      for(int i=0;i<arr.length;i++)
      {
          heapInsert(arr,i);
      }
       Node [] nodes=new Node[arr.length];
        for(int i=0;i<arr.length;i++){
            nodes[i]=new Node(arr[i]);
        }
        int index=0;
       Node head=nodes[index++];
       Queue<Node> queue=new LinkedList<>();
       queue.offer(head);
       while(!queue.isEmpty()){
           Node node=queue.poll();
           node.left=index<arr.length ? nodes[index++]:null;
           node.right=index<arr.length ? nodes[index++]:null;
           if(node.left!=null)
           {
               queue.offer(node.left);
           }
           if(node.right!=null){
               queue.offer(node.right);
           }

       }

       return head;
    }



    public static void heapInsert(int[]arr,int index){

        while(arr[index]>arr[(index-1)/2])
        {
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }

    public static void printPreOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        printPreOrder(head.left);
        printPreOrder(head.right);
    }
   //这个中序遍历这样写有问题，对于用大根堆实现的不对
    public static void printInOrder(Node head) {
        if (head == null) {
            return;
        }
        printPreOrder(head.left);
        System.out.print(head.value + " ");
        printPreOrder(head.right);
    }
    //单调栈实现
    public static Node  getMaxTree(int[] arr){
        Node[] nArr=new Node[arr.length];
        for(int i=0;i<arr.length;i++){
            nArr[i]=new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<Node>();
        HashMap<Node, Node> lBigMap = new HashMap<Node, Node>();//k:当前节点，v:左边第一个比他大的结点
        HashMap<Node, Node> rBigMap = new HashMap<Node, Node>();//k:当前节点，v:右边第一个比他大的结点
        //正着遍历数组，记录当前元素左边第一个比他大的值
        for (int i = 0; i != nArr.length; i++) {
            Node curNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }
        //最后栈中的元素不存在右边比他大的值

        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }
        //反着压入数组元素，记录下右边第一个比当前元素大的值
        for (int i = nArr.length - 1; i != -1; i--) {
            Node curNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }
        Node head = null;
        for (int i = 0; i != nArr.length; i++) {
            Node curNode = nArr[i];
            Node left =lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }
        }
        return head;

    }



  public static void popStackSetMap(Stack<Node> stack,HashMap<Node,Node> map){
        Node popNode=stack.pop();
        if(stack.isEmpty()){
            map.put(popNode,null);
        }else {
            map.put(popNode,stack.peek());
        }
  }

    public static void main(String[] args) {
        int[] uniqueArr = { 3, 4, 5, 1, 2,6,8 };

        Node head = getMaxTree1(uniqueArr);
        printPreOrder(head);
        System.out.println();
        printInOrder(head);
        System.out.println("+==========");
        Node maxTree = getMaxTree(uniqueArr);
        printPreOrder(maxTree);

    }
}
